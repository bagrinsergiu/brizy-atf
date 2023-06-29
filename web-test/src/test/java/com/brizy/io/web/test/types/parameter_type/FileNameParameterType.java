package com.brizy.io.web.test.types.parameter_type;

import com.brizy.io.web.test.exception.InvalidFileNameException;
import com.brizy.io.web.test.model.page.FileName;
import io.cucumber.java.ParameterType;

public class FileNameParameterType {

    @ParameterType(name = "fileName", value = ".*")
    public FileName getFileName(String rawValue) {
        if (!rawValue.contains(".json")) {
            throw new InvalidFileNameException("Make sure you provide a supported file name with json extension");
        }
        return new FileName(rawValue);
    }

}
