package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.sys.entity.SysRoleDeptEntity;
import io.renren.modules.sys.service.SysRoleDeptService;
import io.renren.utils.PageUtils;
import io.renren.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;





/**
 * 角色与部门对应关系
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-08-31 16:45:54
 */
@RestController
@RequestMapping("sys/sysroledept")
public class SysRoleDeptController {
    @Autowired
    private SysRoleDeptService sysRoleDeptService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:sysroledept:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysRoleDeptService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:sysroledept:info")
    public R info(@PathVariable("id") Long id){
			SysRoleDeptEntity sysRoleDept = sysRoleDeptService.selectById(id);

        return R.ok().put("sysRoleDept", sysRoleDept);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:sysroledept:save")
    public R save(@RequestBody SysRoleDeptEntity sysRoleDept){
			sysRoleDeptService.insert(sysRoleDept);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:sysroledept:update")
    public R update(@RequestBody SysRoleDeptEntity sysRoleDept){
			sysRoleDeptService.updateById(sysRoleDept);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:sysroledept:delete")
    public R delete(@RequestBody Long[] ids){
			sysRoleDeptService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
