package com.brizy.io.web.interactions;

import com.brizy.io.web.common.property.CustomYamlProcessor;
import com.brizy.io.web.interactions.properties.WebLocatorsProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@Configuration
@EnableConfigurationProperties(WebLocatorsProperties.class)
@PropertySource(value = "classpath:web-locators.yml", factory = CustomYamlProcessor.class)
public class WebInteractionsConfiguration {
}
