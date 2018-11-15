package pro.onlyou.ysu2013.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@PropertySource(
        value="classpath:application.properties"
)
public class DataSourceConfigurer {

    @Value("${druid.mysql.driver}")
    private String driverClass;
    @Value("${druid.mysql.username}")
    private String username;
    @Value("${druid.mysql.password}")
    private String password;
    @Value("${druid.mysql.url}")
    private String url;

    @Value("${druid.initial-size}")
    private int intialSize = 10;
    @Value("${druid.max-active}")
    private int maxActive = 30;
    @Value("${druid.min-idle}")
    private int minIdle = 1;


    @Bean(name = "dataSource")
    public DataSource dataSource(){
        DruidDataSource dataSource =
                new DruidDataSource();

        dataSource.setDriverClassName(driverClass);
        dataSource.setUsername(username);
        dataSource.setMaxActive(maxActive);
        dataSource.setMinIdle(minIdle);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setInitialSize(intialSize);

        return dataSource;
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(){
        DataSourceTransactionManager transactionManager =
                new DataSourceTransactionManager();

        transactionManager.setDataSource(this.dataSource());

        return transactionManager;
    }


}
