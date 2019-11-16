package net.awaken.springboot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Collections;
import java.util.Map;

/**
 * @author Finn Zhao
 * @version 2019-11-15
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = PrimaryBeanName.ENTITY_MANAGER_FACTORY
        , transactionManagerRef = PrimaryBeanName.TRANSACTION_MANAGER
        , basePackages = {"net.awaken.springboot.repository.primary"})
public class PrimaryJpaConfiguration implements PrimaryBeanName {

    @Primary
    @Bean(JPA_PROPERTIES)
    @ConfigurationProperties("app.jpa.primary")
    public JpaProperties jpaProperties() {
        return new JpaProperties();
    }

    @Primary
    @Bean(HIBERNATE_PROPERTIES)
    @ConfigurationProperties("app.jpa.hibernate.primary")
    public HibernateProperties hibernateProperties() {
        return new HibernateProperties();
    }

    @Primary
    @Bean(HIBERNATE_SETTINGS)
    public Map<String, ?> properties(
            @Qualifier(HIBERNATE_PROPERTIES_CUSTOMIZER) HibernatePropertiesCustomizer hibernatePropertiesCustomizer
            , @Qualifier(HIBERNATE_PROPERTIES) HibernateProperties hibernateProperties
            , @Qualifier(JPA_PROPERTIES) JpaProperties jpaProperties) {
        HibernateSettings hibernateSettings = new HibernateSettings();
        hibernateSettings.hibernatePropertiesCustomizers(Collections.singletonList(hibernatePropertiesCustomizer));
        return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), hibernateSettings);
    }

    @Primary
    @Bean(ENTITY_MANAGER_FACTORY)
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder
            , @Qualifier(DATA_SOURCE) DataSource dataSource
            , @Qualifier(HIBERNATE_SETTINGS) Map<String, ?> properties) {
        return builder.dataSource(dataSource)
                .properties(properties)
                .packages("net.awaken.springboot.domain.primary")
                .persistenceUnit("primaryPersistenceUnit")
                .build();
    }

    @Primary
    @Bean(TRANSACTION_MANAGER)
    public PlatformTransactionManager transactionManager(
            @Qualifier(ENTITY_MANAGER_FACTORY) EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Primary
    @Bean(ENTITY_MANAGER)
    public EntityManager entityManager(
            @Qualifier(ENTITY_MANAGER_FACTORY) EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

}
