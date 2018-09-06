package io.renren.datasources.aspect;

import io.renren.datasources.DataSouceName;
import io.renren.datasources.DynamicDataSouce;
import io.renren.datasources.annotation.DataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;


import java.lang.reflect.Method;

/**
 * 动态数据源切面处理
 */
@Aspect
@Component
public class DataSourceAspect implements Ordered {
    private Logger logger= LoggerFactory.getLogger(getClass());
    @Pointcut("@annotation(io.renren.datasources.annotation.DataSource)")
    public void  dataSourcePointCut(){
    }
    @Around("dataSourcePointCut()")
    public  Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature= (MethodSignature) point.getSignature();
        Method method=signature.getMethod();
        DataSource ds=method.getAnnotation(DataSource.class);
        if (ds==null){
            DynamicDataSouce.setDataSource(DataSouceName.FIRST);
            logger.debug("set datasource is"+DataSouceName.FIRST);

        }else {
            DynamicDataSouce.setDataSource(ds.name());
            logger.debug("set datasource is "+ ds.name());
        }
        try {
            return  point.proceed();
        }finally {
            DynamicDataSouce.clearDataSouce();
            logger.debug("clear datasource");
        }
    }


    @Override
    public int getOrder() {
        return 1;
    }
}
