package com.brizy.io.web.test.service;

import com.brizy.io.web.property.WebDriverProperties;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.storage.Storage;
import com.microsoft.playwright.Page;
import io.cucumber.java.Scenario;
import jakarta.annotation.PreDestroy;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ActivePageService {

    Storage activeScenarioService;
    WebDriverProperties webDriverProperties;
    @NonFinal
    Page page;

    public ActivePageService(Page page, Storage activeScenarioService, WebDriverProperties webDriverProperties) {
        this.activeScenarioService = activeScenarioService;
        this.webDriverProperties = webDriverProperties;
        this.page = page;
    }

    public void setPage(Page page) {
        closePage();
        this.page = page;
    }

    @PreDestroy
    public void closePage() {
        if (Objects.isNull(page)) {
            return;
        }
        page.close();
        saveRecording();
    }

    @SneakyThrows
    private void saveRecording() {
        Path recordVideoDir = webDriverProperties.getContext().getRecordVideoDir();
        Path fileToSaveIn = Files.createFile(recordVideoDir.resolve(LocalDateTime.now().toString().concat(String.valueOf(System.currentTimeMillis())).concat(".webm")));
        page.video().saveAs(fileToSaveIn);
    }

}
