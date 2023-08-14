package com.brizy.io.web.test.data.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum TestDataFileType {

    JSON_FILE("testData"),
    FILE("files");

    String path;
}
