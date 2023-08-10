package com.brizy.io.web.test.data.service;

import com.brizy.io.web.test.data.enums.TestDataFileType;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ResourceLoaderService {

    public InputStream getTestDataFile(TestDataFileType fileType, String fileName) {
        ClassLoader classLoader = ResourceLoaderService.class.getClassLoader();
        return classLoader.getResourceAsStream(fileType.getPath().concat("/") + fileName);
    }

    public Path getPathToResource(TestDataFileType fileType, String fileName) {
        ClassLoader classLoader = ResourceLoaderService.class.getClassLoader();
        return Paths.get(classLoader.getResource(fileType.getPath().concat("/").concat(fileName)).getPath());
    }

}
