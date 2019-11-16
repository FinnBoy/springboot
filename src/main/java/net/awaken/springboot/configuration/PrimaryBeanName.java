package net.awaken.springboot.configuration;

/**
 * @author Finn Zhao
 * @version 2019-11-15
 */
public interface PrimaryBeanName {

    String DATA_SOURCE_PROPERTIES = "primaryDataSourceProperties";

    String DATA_SOURCE = "primaryDataSource";

    String JPA_PROPERTIES = "primaryJpaProperties";

    String HIBERNATE_PROPERTIES = "primaryHibernateProperties";

    String HIBERNATE_PROPERTIES_CUSTOMIZER = "primaryHibernatePropertiesCustomizer";

    String HIBERNATE_SETTINGS = "primaryHibernateSettings";

    String ENTITY_MANAGER_FACTORY = "primaryEntityManagerFactory";

    String TRANSACTION_MANAGER = "primaryTransactionManager";

    String ENTITY_MANAGER = "primaryEntityManager";

}
