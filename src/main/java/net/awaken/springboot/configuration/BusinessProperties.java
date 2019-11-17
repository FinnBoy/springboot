package net.awaken.springboot.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Finn Zhao
 * @version 2019-11-17
 */
@PropertySource(value = "classpath:config/business.properties")
@ConfigurationProperties(prefix = "business")
@Component
public class BusinessProperties {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
