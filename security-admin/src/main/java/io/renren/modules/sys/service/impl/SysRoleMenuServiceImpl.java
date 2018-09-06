package io.renren.modules.sys.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.Query;
import io.renren.modules.sys.dao.SysRoleMenuDao;
import io.renren.modules.sys.entity.SysRoleMenuEntity;
import io.renren.modules.sys.service.SysRoleMenuService;
import io.renren.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuDao, SysRoleMenuEntity> implements SysRoleMenuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysRoleMenuEntity> page = this.selectPage(
                new Query<SysRoleMenuEntity>(params).getPage(),
                new EntityWrapper<SysRoleMenuEntity>()
        );

        return new PageUtils(page);
    }

}
