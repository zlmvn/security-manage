package io.renren.datasources;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 *读取配置文件
 */
@Configuration
public class DynamicDataSourceConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.druid.first")
    public DataSource firstDataSource(){return DruidDataSourceBuilder.create().build();}
    @Bean
    @ConfigurationProperties("spring.datasource.druid.second")
    public DataSource secondDataSource(){return DruidDataSourceBuilder.create().build();}
    @Bean
    @Primary
    public DynamicDataSouce dataSource (DataSource firstDataSource, DataSource secondDataSource){
        Map<Object,Object> targeDataSource=new HashMap<>();
        targeDataSource.put(DataSouceName.FIRST,firstDataSource);
        targeDataSource.put(DataSouceName.SECOND,secondDataSource);
        return new DynamicDataSouce(firstDataSource,targeDataSource);

    }






}
