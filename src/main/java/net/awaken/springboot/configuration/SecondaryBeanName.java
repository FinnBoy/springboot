package net.awaken.springboot.configuration;

/**
 * @author Finn Zhao
 * @version 2019-11-15
 */
public interface SecondaryBeanName {

    String DATA_SOURCE = "secondaryDataSource";

    String JPA_PROPERTIES = "secondaryJpaProperties";

    String HIBERNATE_PROPERTIES = "secondaryHibernateProperties";

    String HIBERNATE_PROPERTIES_CUSTOMIZER = "secondaryHibernatePropertiesCustomizer";

    String HIBERNATE_SETTINGS = "secondaryHibernateSettings";

    String ENTITY_MANAGER_FACTORY = "secondaryEntityManagerFactory";

    String TRANSACTION_MANAGER = "secondaryTransactionManager";

}
