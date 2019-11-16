package net.awaken.springboot.configuration;

import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Finn Zhao
 * @version 2019-11-16
 */
@Component(SecondaryBeanName.HIBERNATE_PROPERTIES_CUSTOMIZER)
public class SecondaryHibernatePropertiesCustomizer implements HibernatePropertiesCustomizer {

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
    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        // TODO
    }
}
