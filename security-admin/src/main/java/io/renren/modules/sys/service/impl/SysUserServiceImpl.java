package io.renren.modules.sys.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.Query;
import io.renren.modules.sys.dao.SysUserDao;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import io.renren.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysUserEntity> page = this.selectPage(
                new Query<SysUserEntity>(params).getPage(),
                new EntityWrapper<SysUserEntity>()
        );

        return new PageUtils(page);
    }

}
