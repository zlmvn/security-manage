package io.renren.modules.sys.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.modules.sys.entity.SysUserEntity;

import java.util.List;

/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-08-31 16:45:54
 */
public interface SysUserDao extends BaseMapper<SysUserEntity> {
    /**
     * 查询用户的所有权限
     * @param userId  用户ID
     */
    List<String> queryAllPerms(Long userId);

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);
}
