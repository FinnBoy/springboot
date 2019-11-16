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

    /**
     * Spring is trying to close BasicDataSource twice:<br/>
     * 1. BasicDataSource close itself automatically when application close<br/>
     * 2. Spring use default destroy method to close DataSource but it's already closed<br/>
     *
     * @return
     */
    @Bean(name = DATA_SOURCE, destroyMethod = "")
    @ConfigurationProperties("app.datasource.secondary")
    public BasicDataSource dataSource() {
        return DataSourceBuilder.create().type(BasicDataSource.class).build();
    }
}
