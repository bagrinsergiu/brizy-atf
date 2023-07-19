package com.brizy.io.web.test.model.page;

import lombok.AccessLevel;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;

@ToString
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FileName {

    String name;
    String extension;

    public FileName(String fileName) {
        this.name = fileName.replaceAll("\\..*", StringUtils.EMPTY);
        this.extension = fileName.replaceAll(".*\\.", StringUtils.EMPTY);
    }

    public String getFullName() {
        return name.concat(".").concat(extension);
    }

}
