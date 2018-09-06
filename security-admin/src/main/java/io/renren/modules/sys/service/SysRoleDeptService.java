package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.modules.sys.entity.SysRoleDeptEntity;
import io.renren.utils.PageUtils;

import java.util.Map;

/**
 * 角色与部门对应关系
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-08-31 16:45:54
 */
public interface SysRoleDeptService extends IService<SysRoleDeptEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

