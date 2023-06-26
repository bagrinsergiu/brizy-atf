package com.brizy.io.web.test.hook;

import com.brizy.io.web.test.storage.Storage;
import io.cucumber.java.After;
import io.qameta.allure.Allure;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ReportingHooks {

    Storage storage;

    @After
    @SneakyThrows
    public void attachRecordings() {
        addResourceToReport("target/recordings", "Recordings", "video/webm");
    }


    private void addResourceToReport(String resourceParentPath, String resourceName, String resourceType) {
        String resourceExtension = resourceType.replaceAll(".*/", StringUtils.EMPTY);
        Path pathToRecordings = Paths.get(resourceParentPath);
        try (Stream<Path> fileList = Files.list(pathToRecordings)) {
            fileList.map(Path::toFile)
                    .map(File::getAbsolutePath)
                    .map(this::getFileInputStreamFromString)
                    .forEach(fileStream -> Allure.addAttachment(resourceName, resourceType, fileStream, resourceExtension));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    private FileInputStream getFileInputStreamFromString(String filePath) {
        return new FileInputStream(filePath);
    }

}
