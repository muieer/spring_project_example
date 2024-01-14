package org.muieer.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@ToString
@Getter
@Configuration
@PropertySource("classpath:/custom.properties")
public class CustomProperties {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomProperties.class);

    @Autowired
    private Environment env;

    @Value("${spring.profiles.active}")
    private String profile;

    @Value("${spring.kafka.template.default-topic}")
    private String topicName;

    @PostConstruct
    void init() {
        LOGGER.info(this.toString());
    }
}
