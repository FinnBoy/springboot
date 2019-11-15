package net.awaken.springboot.configuration;

import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Finn Zhao
 * @version 2019-11-16
 */
@Component
public class CommonHibernatePropertiesCustomizer implements HibernatePropertiesCustomizer {

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        // TODO
    }
}
