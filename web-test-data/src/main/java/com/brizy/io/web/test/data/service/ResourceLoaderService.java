package com.brizy.io.web.test.data.service;

import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class ResourceLoaderService {

    public InputStream getTestDataFile(String fileName) {
        ClassLoader classLoader = ResourceLoaderService.class.getClassLoader();
        return classLoader.getResourceAsStream("testData/" + fileName);
    }

}
