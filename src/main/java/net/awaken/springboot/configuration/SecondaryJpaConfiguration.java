package net.awaken.springboot.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author Finn Zhao
 * @version 2019-11-15
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = SecondaryBeanName.ENTITY_MANAGER_FACTORY
        , transactionManagerRef = SecondaryBeanName.TRANSACTION_MANAGER
        , basePackages = {"net.awaken.springboot.repository.secondary"})
public class SecondaryJpaConfiguration implements SecondaryBeanName {

    // @Bean(JPA_PROPERTIES)
    public JpaProperties jpaProperties() {
        return new JpaProperties();
    }

    @Bean(ENTITY_MANAGER_FACTORY)
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder
            , @Qualifier(DATA_SOURCE) DataSource dataSource
            , JpaProperties jpaProperties) {
        return builder.dataSource(dataSource)
                .properties(jpaProperties.getProperties())
                .packages("net.awaken.springboot.domain.secondary")
                .persistenceUnit("secondaryPersistenceUnit")
                .build();
    }

    @Bean(TRANSACTION_MANAGER)
    public PlatformTransactionManager transactionManager(
            @Qualifier(ENTITY_MANAGER_FACTORY) EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
