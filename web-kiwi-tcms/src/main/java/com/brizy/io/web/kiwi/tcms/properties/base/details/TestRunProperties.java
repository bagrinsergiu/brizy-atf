package com.brizy.io.web.kiwi.tcms.properties.base.details;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class TestRunProperties {

    String product;
    String plan;
    String build;
    String defaultTester;
    Long manager;

}
