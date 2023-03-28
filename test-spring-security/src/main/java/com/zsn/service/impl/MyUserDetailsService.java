package com.zsn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zsn.dao.MenuDao;
import com.zsn.entity.*;
import com.zsn.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : zhou sen nan
 * @Date : 2022/8/15  16:51
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    RoleUserService roleUserService;
    @Autowired
    MenuService menuService;
    @Autowired
    RoleMenuService roleMenuService;
    @Autowired
    MenuDao menuDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.getUserByUserName(username);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        List<RoleUserEntity> roleUserEntities = roleUserService.getRoleUserEntitiesByUserId(userEntity.getId());
        for (RoleUserEntity entity : roleUserEntities) {
            RoleEntity roleEntity = roleService.selectRoleByRoleId(entity.getId());
            List<RoleMenuEntity> roleMenuEntities = roleMenuService.selectRoleMenuEntityByRoleIds(roleEntity.getId());
            for (RoleMenuEntity r : roleMenuEntities) {
                List<MenuEntity> menuEntities = menuDao.selectList(new LambdaQueryWrapper<MenuEntity>().eq(MenuEntity::getId, r.getId()));
                for (MenuEntity menu:menuEntities) {
                    authorities.add(new SimpleGrantedAuthority(menu.getPermissions()));
                }
            }
        }


        return new User(userEntity.getUsername(), userEntity.getPassword(), authorities);
    }
}
