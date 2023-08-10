package com.brizy.io.web.test.data.service;

import com.brizy.io.web.test.data.enums.TestDataFileType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class TestDataFileService {

    ObjectMapper objectMapper;
    ResourceLoaderService resourceLoaderService;

    @SneakyThrows
    public <T> List<T> getItemProperties(String fileName, Class<T[]> clazz) {
        InputStream fileFromResource = resourceLoaderService.getTestDataFile(TestDataFileType.JSON_FILE, fileName);
        return Arrays.asList(objectMapper.readValue(fileFromResource, clazz));
    }

    @SneakyThrows
    public String getFileContent(String fileName) {
        InputStream fileFromResource = resourceLoaderService.getTestDataFile(TestDataFileType.JSON_FILE, fileName);
        return new String(fileFromResource.readAllBytes());
    }

    public Path getResourceFilePath(TestDataFileType fileType, String fileName) {
        return resourceLoaderService.getPathToResource(fileType, fileName);
    }

}
