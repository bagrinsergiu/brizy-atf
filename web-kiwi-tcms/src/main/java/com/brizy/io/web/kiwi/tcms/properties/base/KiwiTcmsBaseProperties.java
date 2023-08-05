package com.brizy.io.web.kiwi.tcms.properties.base;

import com.brizy.io.web.kiwi.tcms.properties.base.details.KiwiTcmsDetailsProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@ConfigurationProperties
public class KiwiTcmsBaseProperties {

    String serverUrl;
    @NestedConfigurationProperty
    KiwiTcmsCredentialsProperties credentials;
    @NestedConfigurationProperty
    KiwiTcmsTimeoutsProperties timeouts;
    @NestedConfigurationProperty
    KiwiTcmsDetailsProperties details;
}
