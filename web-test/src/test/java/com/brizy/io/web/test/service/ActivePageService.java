package com.brizy.io.web.test.service;

import com.brizy.io.web.property.WebDriverProperties;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.storage.Storage;
import com.microsoft.playwright.Page;
import io.cucumber.java.Scenario;
import io.cucumber.spring.ScenarioScope;
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
@ScenarioScope
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ActivePageService {

    Storage activeScenarioService;
    WebDriverProperties webDriverProperties;
    @NonFinal
    Page page;

    public void setPage(Page page) {
        closePage();
        this.page = page;
    }

    public void closePage() {
        if (Objects.isNull(page)) {
            return;
        }
        page.close();
        saveRecording();
    }

    @SneakyThrows
    private void saveRecording() {
        String scenarioName = activeScenarioService.getValue(StorageKey.CURRENT_SCENARIO, Scenario.class).getName();
        Path recordVideoDir = webDriverProperties.getContext().getRecordVideoDir();
        Path fileToSaveIn = Files.createFile(recordVideoDir.resolve(scenarioName.concat(String.valueOf(System.currentTimeMillis())).concat(".webm")));
        page.video().saveAs(fileToSaveIn);
    }

}
