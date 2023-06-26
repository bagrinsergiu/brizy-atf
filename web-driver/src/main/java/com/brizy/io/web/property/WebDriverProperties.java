package com.brizy.io.web.property;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor
@ConfigurationProperties
public class WebDriverProperties {

    @NestedConfigurationProperty
    BrowserProperties browser;
    @NestedConfigurationProperty
    ContextProperties context;
    @NestedConfigurationProperty
    PlaywrightProperties playwright;

}
