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

import com.zsn.entity.RoleMenuEntity;
import com.zsn.service.RoleMenuService;
import com.zsn.utils.PageUtils;
import com.zsn.utils.Query;



/**
 * 角色菜单关系
 *
 * @author zsn
 * @email 1765509297@qq.com
 * @date 2022-08-05 17:50:26
 */
@RestController
@RequestMapping("zsn/rolemenu")
public class RoleMenuController {
    @Autowired
    private RoleMenuService roleMenuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
   // @RequiresPermissions("zsn:rolemenu:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = roleMenuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
   // @RequiresPermissions("zsn:rolemenu:info")
    public R info(@PathVariable("id") Long id){
		RoleMenuEntity roleMenu = roleMenuService.getById(id);

        return R.ok().put("roleMenu", roleMenu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
   // @RequiresPermissions("zsn:rolemenu:save")
    public R save(@RequestBody RoleMenuEntity roleMenu){
		roleMenuService.save(roleMenu);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("zsn:rolemenu:update")
    public R update(@RequestBody RoleMenuEntity roleMenu){
		roleMenuService.updateById(roleMenu);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("zsn:rolemenu:delete")
    public R delete(@RequestBody Long[] ids){
		roleMenuService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
