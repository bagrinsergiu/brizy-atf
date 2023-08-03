package com.brizy.io.web.kiwi.tcms.service;


import com.brizy.io.web.kiwi.tcms.dto.request.test_plan.*;
import com.brizy.io.web.kiwi.tcms.dto.response.test_plan.AddTestCaseToTestPlanResponseDto;
import com.brizy.io.web.kiwi.tcms.dto.response.test_plan.CreateTestPlanResponseDto;
import com.brizy.io.web.kiwi.tcms.dto.response.test_plan.GetTestPlanDto;
import com.brizy.io.web.kiwi.tcms.dto.response.test_plan.TestPlanResponseDto;
import com.brizy.io.web.kiwi.tcms.properties.api.KiwiTcmsApiProperties;
import com.brizy.io.web.kiwi.tcms.properties.api.TestPlanApiProperties;
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
public class TestPlanService extends AbstractService {

    TestPlanApiProperties testPlanProperties;

    @Autowired
    public TestPlanService(RestTemplate restTemplate, KiwiTcmsApiProperties apiProperties) {
        super(restTemplate);
        this.testPlanProperties = apiProperties.getTestPlan();
    }

    public GetTestPlanDto getTestPlanByName(String testPlanName) {
        List<TestPlanByNameDto> params = List.of(TestPlanByNameDto.builder().name(testPlanName).build());
        TestPlanByNameRequestDto body = TestPlanByNameRequestDto.builder().method(testPlanProperties.getFilter()).params(params).build();
        TestPlanResponseDto response = postAndGetEntity(body, TestPlanResponseDto.class);
        return response.getResult().stream().findFirst().orElse(new GetTestPlanDto());
    }

    public com.brizy.io.web.kiwi.tcms.dto.response.test_plan.CreateTestPlanDto createTestPlan(CreateTestPlanDto createTestPlan) {
        CreateTestPlanRequestDto body = CreateTestPlanRequestDto.builder().method(testPlanProperties.getCreate()).params(List.of(createTestPlan)).build();
        CreateTestPlanResponseDto TestPlanResponseDto = postAndGetEntity(body, CreateTestPlanResponseDto.class);
        return TestPlanResponseDto.getResult();
    }

    public com.brizy.io.web.kiwi.tcms.dto.response.test_plan.AddTestCaseToTestPlanDto addTestCaseToPlan(AddTestCaseToTestPlanDto addTestCaseToTestPlan) {
        AddTestCaseToTestPlanRequestDto body = AddTestCaseToTestPlanRequestDto.builder().method(testPlanProperties.getAddCase()).params(addTestCaseToTestPlan).build();
        AddTestCaseToTestPlanResponseDto testRunResponseDto = postAndGetEntity(body, AddTestCaseToTestPlanResponseDto.class);
        return testRunResponseDto.getResult();
    }

}
