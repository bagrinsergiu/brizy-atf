package com.brizy.io.web.test.config;

import com.brizy.io.web.WebDriverConfiguration;
import com.brizy.io.web.common.WebCommonConfiguration;
import com.brizy.io.web.interactions.WebInteractionsConfiguration;
import com.brizy.io.web.reporting.WebReportingConfiguration;
import com.brizy.io.web.reporting.service.EnvironmentPropertiesWriter;
import com.brizy.io.web.test.data.WebTestDataConfiguration;
import io.cucumber.spring.CucumberContextConfiguration;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;

import java.nio.file.Path;
import java.util.Map;

@ContextConfiguration
@CucumberContextConfiguration
@EnableAspectJAutoProxy
@SpringBootTest(classes = {WebInteractionsConfiguration.class, WebTestDataConfiguration.class, WebDriverConfiguration.class, WebCommonConfiguration.class, WebReportingConfiguration.class})
public class BrizyTestsConfig {

    @Autowired
    EnvironmentPropertiesWriter environmentPropertiesWriter;

    @PreDestroy
    public void initProperties() {
        environmentPropertiesWriter.writeProperties(Path.of("target/allure-results/environment.properties"), Map.of(
                "Executor", System.getProperty("os.name"),
                "Java", System.getProperty("java.version")
        ));
    }

}
