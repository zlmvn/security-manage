package io.renren.modules.sys.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.Query;
import io.renren.modules.sys.dao.SysRoleDeptDao;
import io.renren.modules.sys.entity.SysRoleDeptEntity;
import io.renren.modules.sys.service.SysRoleDeptService;
import io.renren.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("sysRoleDeptService")
public class SysRoleDeptServiceImpl extends ServiceImpl<SysRoleDeptDao, SysRoleDeptEntity> implements SysRoleDeptService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysRoleDeptEntity> page = this.selectPage(
                new Query<SysRoleDeptEntity>(params).getPage(),
                new EntityWrapper<SysRoleDeptEntity>()
        );

        return new PageUtils(page);
    }

}
