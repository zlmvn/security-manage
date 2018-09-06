package io.renren.modules.sys.service;



import com.baomidou.mybatisplus.service.IService;
import io.renren.modules.sys.entity.SysConfigEntity;
import io.renren.utils.PageUtils;

import java.util.Map;

/**
 * 系统配置信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-08-31 16:45:54
 */
public interface SysConfigService extends IService<SysConfigEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

