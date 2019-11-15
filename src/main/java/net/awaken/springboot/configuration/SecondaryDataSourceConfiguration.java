package net.awaken.springboot.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Finn Zhao
 */
@Configuration
public class SecondaryDataSourceConfiguration implements SecondaryBeanName {

    @Bean(DATA_SOURCE)
    @ConfigurationProperties("app.datasource.secondary")
    public BasicDataSource dataSource() {
        return DataSourceBuilder.create().type(BasicDataSource.class).build();
    }
}
