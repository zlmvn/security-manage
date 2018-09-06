package io.renren.datasources;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * 动态数据源配置
 */
public class DynamicDataSouce extends AbstractRoutingDataSource {

    private  static  final  ThreadLocal<String> contextHolder=new ThreadLocal<>();
    public DynamicDataSouce(DataSource defaultDataSource,Map<Object,Object> targetDataSource) {
        super.setDefaultTargetDataSource(defaultDataSource);//默认数据源配置
        super.setTargetDataSources(targetDataSource);//动态数据源配置
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }
    public  static  void  setDataSource(String dataSource){
        contextHolder.set(dataSource);
    }
    public static String getDataSource(){
        return  contextHolder.get();
    }
    public static  void  clearDataSouce(){
        contextHolder.remove();
    }
}
