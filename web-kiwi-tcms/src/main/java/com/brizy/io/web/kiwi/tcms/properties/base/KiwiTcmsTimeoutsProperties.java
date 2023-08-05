package com.brizy.io.web.kiwi.tcms.properties.base;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.Duration;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class KiwiTcmsTimeoutsProperties {

    Duration connectionTimeout;
    Duration readTimeout;

}
