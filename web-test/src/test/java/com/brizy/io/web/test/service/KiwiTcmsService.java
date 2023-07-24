package com.brizy.io.web.test.service;

import com.brizy.io.web.kiwi.tcms.dto.request.build.CreateBuildDto;
import com.brizy.io.web.kiwi.tcms.dto.request.product.CreateProductDto;
import com.brizy.io.web.kiwi.tcms.dto.request.test_case.CreateTestCaseDto;
import com.brizy.io.web.kiwi.tcms.dto.request.test_case.UpdateTestCaseDurationDto;
import com.brizy.io.web.kiwi.tcms.dto.request.test_execution.UpdateTestExecutionStatusDto;
import com.brizy.io.web.kiwi.tcms.dto.request.test_plan.CreateTestPlanDto;
import com.brizy.io.web.kiwi.tcms.dto.request.test_run.CreateTestRunDto;
import com.brizy.io.web.kiwi.tcms.dto.request.test_run.UpdateTestRunTimeStampsDto;
import com.brizy.io.web.kiwi.tcms.dto.request.version.CreateVersionDto;
import com.brizy.io.web.kiwi.tcms.dto.response.test_plan.AddTestCaseToTestPlanDto;
import com.brizy.io.web.kiwi.tcms.dto.response.test_run.AddTestCaseToTestRunDto;
import com.brizy.io.web.kiwi.tcms.properties.base.KiwiTcmsBaseProperties;
import com.brizy.io.web.kiwi.tcms.properties.base.details.*;
import com.brizy.io.web.kiwi.tcms.service.*;
import com.brizy.io.web.test.constants.TestRunDetails;
import com.brizy.io.web.test.listener.TestPhase;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.HookTestStep;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;
import io.cucumber.plugin.event.TestCaseStarted;
import io.vavr.API;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

import static com.brizy.io.web.test.constants.TestRunDetails.getStringFormattedCurrentDateTime;
import static io.cucumber.java.Status.*;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class KiwiTcmsService {

    TestRunService testRunService;
    TestExecutionService testExecutionService;
    @NonFinal
    @Getter
    Long planId;
    @NonFinal
    @Getter
    Long runId;

    KiwiTcmsBaseProperties baseProperties;
    AuthenticationService authenticationService;
    ClassificationService classificationService;
    ProductService productsService;
    TestPlanService testPlanService;
    @Value("${useKiwi}")
    @NonFinal
    String useKiwi;
    TestCaseService testCaseService;
    @NonFinal
    LocalDateTime start;
    VersionService versionService;
    BuildService buildService;

    @PostConstruct
    public void authenticateAndCreateRequiredData() {
        if (isKiwiUsed()) {
            String testRunStartDate = getStringFormattedCurrentDateTime.get();
            authenticate();
            createDefaultClassification();
            createDefaultProduct();
            createDefaultVersion();
            createDefaultBuild();
            createDefaultTestPlan();
            planId = createDefaultTestPlan();
            runId = createTestRun(testRunStartDate).getId();
            start = LocalDateTime.now();
        }
    }

    @PreDestroy
    public void writeInformationAboutTheRun() {
        if (isKiwiUsed()) {
            String testRunFinishDate = getStringFormattedCurrentDateTime.get();
            updateTestRunEndTime(runId, testRunFinishDate);
        }
    }

    private Boolean isKiwiUsed() {
        return useKiwi.contains("true");
    }

    private void authenticate() {
        authenticationService.login();
    }

    private void createDefaultClassification() {
        String classificationName = baseProperties.getDetails().getClassification().getName();
        if (Objects.isNull(classificationService.getClassificationByName(classificationName).getId())) {
            classificationService.createDefaultClassification();
        }
    }

    private void createDefaultProduct() {
        ProductProperties product = baseProperties.getDetails().getProduct();
        if (Objects.isNull(productsService.getProductByName(product.getName()).getId())) {
            Long classificationId = classificationService.getClassificationByName(product.getClassification()).getId();
            CreateProductDto withBody = CreateProductDto.builder().name(product.getName()).description(product.getDescription()).classification(classificationId).build();
            productsService.createProduct(withBody);
        }
    }

    private void createDefaultVersion() {
        VersionProperties version = baseProperties.getDetails().getVersion();
        if (Objects.isNull(versionService.getVersionByValue(version.getValue()).getId())) {
            Long productId = productsService.getProductByName(version.getProduct()).getId();
            CreateVersionDto withBody = CreateVersionDto.builder().value(version.getValue()).product(productId).build();
            versionService.createVersion(withBody);
        }
    }

    private void createDefaultBuild() {
        BuildProperties build = baseProperties.getDetails().getBuild();
        if (Objects.isNull(buildService.getBuildByName(build.getName()).getId())) {
            Long productId = productsService.getProductByName(build.getProduct()).getId();
            Long versionId = versionService.getVersionByValue(build.getVersion()).getId();
            CreateBuildDto withBody = CreateBuildDto.builder().name(build.getName()).product(productId).version(versionId).build();
            buildService.createBuild(withBody);
        }
    }

    private Long createDefaultTestPlan() {
        TestPlanProperties testPlan = baseProperties.getDetails().getTestPlan();
        if (Objects.isNull(testPlanService.getTestPlanByName(testPlan.getName()).getId())) {
            Long productId = productsService.getProductByName(testPlan.getProduct()).getId();
            Long versionId = versionService.getVersionByValue(testPlan.getVersion()).getId();
            CreateTestPlanDto withBody = CreateTestPlanDto.builder()
                    .name(testPlan.getName())
                    .product(productId)
                    .productVersion(versionId)
                    .type(testPlan.getType())
                    .referenceLink(testPlan.getReferenceLink())
                    .text(testPlan.getText())
                    .notifyAuthor(testPlan.getNotifyAuthor())
                    .notifyDefaultTester(testPlan.getNotifyDefaultTester())
                    .notifyTestCaseAuthor(testPlan.getNotifyTestCaseAuthor())
                    .notifyWhenTestPlanIsUpdated(testPlan.getNotifyWhenTestPlanIsUpdated())
                    .notifyWhenTestCaseAreUpdated(testPlan.getNotifyWhenTestCaseAreUpdated())
                    .build();
            return testPlanService.createTestPlan(withBody).getId();
        }
        return testPlanService.getTestPlanByName(testPlan.getName()).getId();
    }

    private com.brizy.io.web.kiwi.tcms.dto.response.test_run.CreateTestRunDto createTestRun(String startingDate) {
        TestRunProperties testRun = baseProperties.getDetails().getTestRun();
        Long productId = productsService.getProductByName(testRun.getProduct()).getId();
        Long planId = testPlanService.getTestPlanByName(testRun.getPlan()).getId();
        Long buildId = buildService.getBuildByName(testRun.getBuild()).getId();
        CreateTestRunDto withBody = CreateTestRunDto.builder()
                .summary("Automation Framework Regression Test Run For ".concat(startingDate))
                .notes("It will run every day at midnight to check regression tests")
                .defaultTester(testRun.getDefaultTester())
                .manager(testRun.getManager())
                .product(productId)
                .plan(planId)
                .build(buildId)
                .plannedStart(startingDate)
                .startDate(startingDate)
                .build();
        return testRunService.createTestRun(withBody);
    }

    public Long createTestCase() {
        if (isKiwiUsed()) {
            Map<TestPhase, Object> testRunDetails = TestRunDetails.testRunDetails;
            TestCase testCase = ((TestCaseStarted) testRunDetails.get(TestPhase.TEST_CASE_STARTED)).getTestCase();
            TestCaseProperties testCaseProperties = baseProperties.getDetails().getTestCase();
            if (Objects.isNull(testCaseService.getTestCaseBySummary(testCase.getName()).getId())) {
                Long productId = productsService.getProductByName(testCaseProperties.getProduct()).getId();
                CreateTestCaseDto withBody = CreateTestCaseDto.builder()
                        .isAutomated(true)
                        .script(testCase.getUri().toString().replaceAll(".*(?=features)", ""))
                        .arguments("N/A")
                        .category(1L)
                        .extraLink("N/A")
                        .summary(testCase.getName())
                        .requirement("N/A")
                        .product(productId)
                        .notes("N/A")
                        .text(getTestCaseText(testCase))
                        .setupDuration(0.2)
                        .testingDuration(0.0)
                        .author(testCaseProperties.getDefaultTester())
                        .defaultTester(testCaseProperties.getDefaultTester())
                        .caseStatus(testCaseProperties.getStatus())
                        .priority(testCaseProperties.getPriority())
                        .notifyAuthor(testCaseProperties.getNotifyAuthor())
                        .notifyManagerOfRuns(testCaseProperties.getNotifyManagerOfRuns())
                        .notifyAssignees(testCaseProperties.getNotifyAssignees())
                        .notifyDefaultTester(testCaseProperties.getNotifyDefaultTester())
                        .notifyTesterOfRuns(testCaseProperties.getNotifyTesterOfRuns())
                        .notifyWhenTestCaseIsUpdated(testCaseProperties.getNotifyWhenTestCaseIsUpdated())
                        .notifyWhenTestCaseIsDeleted(testCaseProperties.getNotifyWhenTestCaseIsDeleted())
                        .build();
                return testCaseService.createTestCase(withBody).getId();
            }
            return testCaseService.getTestCaseBySummary(testCase.getName()).getId();
        }
        return 0L;
    }

    public Long attachTestCastToTestRun(Long testCaseId) {
        if (isKiwiUsed()) {
            var withBody = com.brizy.io.web.kiwi.tcms.dto.request.test_run.AddTestCaseToTestRunDto.builder().runId(runId).caseId(testCaseId).build();
            return testRunService.addTestCaseToRun(withBody).stream().findFirst().map(AddTestCaseToTestRunDto::getId).orElse(0L);
        }
        return 0L;
    }

    public void updateTestCaseDuration(Long testCaseId, Duration duration) {
        if (isKiwiUsed()) {
            UpdateTestCaseDurationDto withBody = UpdateTestCaseDurationDto.builder().testingDuration(duration.toSeconds()).build();
            testCaseService.updateTestCase(testCaseId, withBody);
        }
    }

    public void updateTestExecutionDetails(Long testExecution, Scenario scenario) {
        if (isKiwiUsed()) {
            String stopDate = getStringFormattedCurrentDateTime.get();
            String status = getStatus(scenario.getStatus());
            UpdateTestExecutionStatusDto withBody = UpdateTestExecutionStatusDto.builder().stopDate(stopDate).status(status).build();
            testExecutionService.updateTestExecution(testExecution, withBody);
        }
    }

    public void updateTestRunEndTime(Long testRunId, String time) {
        if (isKiwiUsed()) {
            UpdateTestRunTimeStampsDto withBody = UpdateTestRunTimeStampsDto.builder().plannedStop(time).stopDate(time).build();
            testRunService.updateTestRun(testRunId, withBody);
        }
    }

    public AddTestCaseToTestPlanDto attachTestCastToTestPlan(Long testCaseId) {
        if (isKiwiUsed()) {
            var withBody = com.brizy.io.web.kiwi.tcms.dto.request.test_plan.AddTestCaseToTestPlanDto.builder().planId(planId).caseId(testCaseId).build();
            return testPlanService.addTestCaseToPlan(withBody);
        }
        return new AddTestCaseToTestPlanDto();
    }

    protected String getTestCaseText(TestCase testCase) {
        String concat = "**Scenario:** ".concat(testCase.getName().concat(System.lineSeparator()));
        return testCase.getTestSteps().stream().filter(step -> !(step instanceof HookTestStep)).map(step -> ((PickleStepTestStep) step)).map(el -> "\t**".concat(el.getStep().getKeyword()).concat("**").concat(el.getStep().getText())).reduce(concat, (string, step) -> string.concat(step).concat(System.lineSeparator()), String::concat);
    }

    private String getStatus(io.cucumber.java.Status status) {
        return API.Match(status).of(API.Case(API.$(PASSED), () -> "4"), API.Case(API.$(SKIPPED), () -> "8"), API.Case(API.$(PENDING), () -> "3"), API.Case(API.$(UNDEFINED), () -> "1"), API.Case(API.$(AMBIGUOUS), () -> "1"), API.Case(API.$(FAILED), () -> "5"), API.Case(API.$(UNUSED), () -> "6"));
    }

}
