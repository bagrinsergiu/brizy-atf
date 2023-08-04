package com.brizy.io.web.kiwi.tcms.service;


import com.brizy.io.web.kiwi.tcms.dto.request.test_run.*;
import com.brizy.io.web.kiwi.tcms.dto.response.test_run.AddTestCaseToTestRunDto;
import com.brizy.io.web.kiwi.tcms.dto.response.test_run.*;
import com.brizy.io.web.kiwi.tcms.properties.api.KiwiTcmsApiProperties;
import com.brizy.io.web.kiwi.tcms.properties.api.TestRunApiProperties;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class TestRunService extends AbstractService {

    TestRunApiProperties testRunProperties;

    @Autowired
    public TestRunService(RestTemplate restTemplate, KiwiTcmsApiProperties apiProperties) {
        super(restTemplate);
        this.testRunProperties = apiProperties.getTestRun();
    }

    public GetTestRunDto getTestRunByName(String testRunName) {
        List<TestRunByNameDto> params = List.of(TestRunByNameDto.builder().name(testRunName).build());
        TestRunByNameRequestDto body = TestRunByNameRequestDto.builder().method(testRunProperties.getFilter()).params(params).build();
        TestRunResponseDto response = postAndGetEntity(body, TestRunResponseDto.class);
        return response.getResult().stream().findFirst().orElse(new GetTestRunDto());
    }

    public com.brizy.io.web.kiwi.tcms.dto.response.test_run.CreateTestRunDto createTestRun(com.brizy.io.web.kiwi.tcms.dto.request.test_run.CreateTestRunDto createTestRun) {
        CreateTestRunRequestDto body = CreateTestRunRequestDto.builder().method(testRunProperties.getCreate()).params(List.of(createTestRun)).build();
        CreateTestRunResponseDto testRunResponseDto = postAndGetEntity(body, CreateTestRunResponseDto.class);
        return testRunResponseDto.getResult();
    }

    public String updateTestRun(Long testRunId, UpdateTestRunTimeStampsDto updatedDuration) {
        List<Object> params = List.of(testRunId.toString(), updatedDuration);
        UpdateTestRunTimestampsRequestDto body = UpdateTestRunTimestampsRequestDto.builder().method(testRunProperties.getUpdate()).params(params).build();
        return postAndGetRaw(body);
    }

    public List<AddTestCaseToTestRunDto> addTestCaseToRun(com.brizy.io.web.kiwi.tcms.dto.request.test_run.AddTestCaseToTestRunDto createTestRun) {
        AddTestCaseToTestRunRequestDto body = AddTestCaseToTestRunRequestDto.builder().method(testRunProperties.getAddCase()).params(createTestRun).build();
        AddTestCaseToTestRunResponseDto testRunResponseDto = postAndGetEntity(body, AddTestCaseToTestRunResponseDto.class);
        return testRunResponseDto.getResult();
    }


}
