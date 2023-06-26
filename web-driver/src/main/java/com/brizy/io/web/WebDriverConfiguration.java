package com.brizy.io.web;

import com.brizy.io.web.common.property.CustomYamlProcessor;
import com.brizy.io.web.property.WebDriverProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@Configuration
@EnableConfigurationProperties(WebDriverProperties.class)
@PropertySource(value = "classpath:web-driver-properties.yml", factory = CustomYamlProcessor.class)
public class WebDriverConfiguration {
}
