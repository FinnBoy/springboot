package net.awaken.springboot.configuration;

import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Finn Zhao
 */
// @Configuration
public class CustomizedHibernateJpaConfiguration implements CommonBeanName {

    /**
     * HibernateJpaConfiguration 这个Bean的 AutoConfigure（自动创建）条件是：<br/>
     * DataSource只创建了一个、或者DataSource虽然创建了多个，但是只有一个Primary DataSource<br/>
     * <p>
     * HibernateJpaConfiguration 创建时，构造方法里传入了HibernateProperties对象、JpaProperties对象<br/>
     * 以及HibernatePropertiesCustomizer对象，说明这3个对象会提前Bean创建准备好<br/>
     * <p>
     * HibernateJpaConfiguration 创建后，其父类的 entityManagerFactory 方法开始判断 AutoConfigure（自动创建）条件：<br/>
     * 没有创建 entityManagerFactory 对象的话，就启动此方法创建，<br/>
     * 此时创建的过程中、正好用到了之前传入到 HibernateJpaConfiguration 对象内的 3 个配置对象：<br/>
     * HibernateProperties对象、JpaProperties对象、以及HibernatePropertiesCustomizer对象<br/>
     *
     * @return
     */
    // @Bean
    public HibernateSettings hibernateSettings() {
        // TODO
        return new HibernateSettings();
    }
}
