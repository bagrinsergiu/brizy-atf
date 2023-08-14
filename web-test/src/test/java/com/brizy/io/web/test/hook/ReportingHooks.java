package com.brizy.io.web.test.hook;

import com.brizy.io.web.property.WebDriverProperties;
import com.brizy.io.web.test.storage.Storage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ReportingHooks {

    Storage storage;
    WebDriverProperties webDriverProperties;

    @After(order = 90)
    @SneakyThrows
    public void attachRecordings(Scenario scenario) {
        Path recordVideoDir = webDriverProperties.getContext().getRecordVideoDir();
        String scenarioName = scenario.getName();
        Files.list(recordVideoDir)
                .filter(file -> file.toFile().getName().startsWith(scenarioName))
                .forEach(file -> addResourceToReport(file.toAbsolutePath().toString(), scenarioName.concat(" Recordings"), "video/webm"));
    }

    private void addResourceToReport(String resourceParentPath, String resourceName, String resourceType) {
        String resourceExtension = resourceType.replaceAll(".*/", StringUtils.EMPTY);
        Allure.addAttachment(resourceName, resourceType, getFileInputStreamFromString(resourceParentPath), resourceExtension);
    }

    @SneakyThrows
    private FileInputStream getFileInputStreamFromString(String filePath) {
        return new FileInputStream(filePath);
    }

}
