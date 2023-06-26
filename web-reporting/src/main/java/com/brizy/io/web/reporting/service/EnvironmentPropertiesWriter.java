package com.brizy.io.web.reporting.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;

@Service
public class EnvironmentPropertiesWriter {

    @SneakyThrows
    public void writeProperties(Path path, Map<String, String> valuesToWrite) {
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        List<String> entryStrings = valuesToWrite.entrySet()
                .stream()
                .map(el -> el.getKey().concat(":").concat(el.getValue()))
                .toList();
        Files.write(path, entryStrings, StandardOpenOption.APPEND);
    }

}
