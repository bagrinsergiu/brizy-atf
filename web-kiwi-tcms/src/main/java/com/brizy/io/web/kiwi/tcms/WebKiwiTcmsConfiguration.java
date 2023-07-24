package com.brizy.io.web.kiwi.tcms;

import com.brizy.io.web.common.property.CustomYamlProcessor;
import com.brizy.io.web.kiwi.tcms.properties.api.KiwiTcmsApiProperties;
import com.brizy.io.web.kiwi.tcms.properties.base.KiwiTcmsBaseProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@ComponentScan
@Configuration
@EnableConfigurationProperties(value = {KiwiTcmsBaseProperties.class, KiwiTcmsApiProperties.class})
@PropertySources({
        @PropertySource(value = "classpath:web-kiwi-tcms.yml", factory = CustomYamlProcessor.class),
        @PropertySource(value = "classpath:web-kiwi-tcms-api.yml", factory = CustomYamlProcessor.class)
})
@EnableAutoConfiguration
public class WebKiwiTcmsConfiguration {
}
