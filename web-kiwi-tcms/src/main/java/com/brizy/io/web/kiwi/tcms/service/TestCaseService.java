package com.brizy.io.web.kiwi.tcms.service;


import com.brizy.io.web.kiwi.tcms.dto.request.test_case.*;
import com.brizy.io.web.kiwi.tcms.dto.response.test_case.CreateTestCaseDto;
import com.brizy.io.web.kiwi.tcms.dto.response.test_case.CreateTestCaseResponseDto;
import com.brizy.io.web.kiwi.tcms.dto.response.test_case.GetTestCaseDto;
import com.brizy.io.web.kiwi.tcms.dto.response.test_case.TestCaseResponseDto;
import com.brizy.io.web.kiwi.tcms.properties.api.KiwiTcmsApiProperties;
import com.brizy.io.web.kiwi.tcms.properties.api.TestCaseApiProperties;
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
public class TestCaseService extends AbstractService {

    TestCaseApiProperties testCaseProperties;

    @Autowired
    public TestCaseService(RestTemplate restTemplate, KiwiTcmsApiProperties apiProperties) {
        super(restTemplate);
        this.testCaseProperties = apiProperties.getTestCase();
    }

    public GetTestCaseDto getTestCaseBySummary(String testCaseSummary) {
        List<TestCaseByNameDto> params = List.of(TestCaseByNameDto.builder().summary(testCaseSummary).build());
        TestCaseByNameRequestDto body = TestCaseByNameRequestDto.builder().method(testCaseProperties.getFilter()).params(params).build();
        TestCaseResponseDto response = postAndGetEntity(body, TestCaseResponseDto.class);
        return response.getResult().stream().findFirst().orElse(new GetTestCaseDto());
    }

    public String updateTestCase(Long testCaseId, UpdateTestCaseDurationDto updatedDuration) {
        List<Object> params = List.of(testCaseId.toString(), updatedDuration);
        UpdateTestCaseDurationRequestDto body = UpdateTestCaseDurationRequestDto.builder().method(testCaseProperties.getUpdate()).params(params).build();
        return postAndGetRaw(body);
    }

    public CreateTestCaseDto createTestCase(com.brizy.io.web.kiwi.tcms.dto.request.test_case.CreateTestCaseDto createTestCase) {
        CreateTestCaseRequestDto body = CreateTestCaseRequestDto.builder().method(testCaseProperties.getCreate()).params(List.of(createTestCase)).build();
        CreateTestCaseResponseDto TestCaseResponseDto = postAndGetEntity(body, CreateTestCaseResponseDto.class);
        return TestCaseResponseDto.getResult();
    }

}
