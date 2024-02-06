package com.zsn.controller;

import java.util.Arrays;
import java.util.Map;

import com.zsn.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zsn.entity.RoleUserEntity;
import com.zsn.service.RoleUserService;
import com.zsn.utils.PageUtils;
import com.zsn.utils.Query;



/**
 * 角色用户关系
 *
 * @author zsn
 * @email 1765509297@qq.com
 * @date 2022-08-05 17:50:26
 */
@RestController
@RequestMapping("zsn/roleuser")
public class RoleUserController {
    @Autowired
    private RoleUserService roleUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
   // @RequiresPermissions("zsn:roleuser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = roleUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
   // @RequiresPermissions("zsn:roleuser:info")
    public R info(@PathVariable("id") Long id){
		RoleUserEntity roleUser = roleUserService.getById(id);

        return R.ok().put("roleUser", roleUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
   // @RequiresPermissions("zsn:roleuser:save")
    public R save(@RequestBody RoleUserEntity roleUser){
		roleUserService.save(roleUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("zsn:roleuser:update")
    public R update(@RequestBody RoleUserEntity roleUser){
		roleUserService.updateById(roleUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("zsn:roleuser:delete")
    public R delete(@RequestBody Long[] ids){
		roleUserService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
