package com.brizy.io.web.kiwi.tcms.service;


import com.brizy.io.web.kiwi.tcms.dto.request.test_execution.UpdateTestExecutionStatusDto;
import com.brizy.io.web.kiwi.tcms.dto.request.test_execution.UpdateTestExecutionStatusRequestDto;
import com.brizy.io.web.kiwi.tcms.properties.api.KiwiTcmsApiProperties;
import com.brizy.io.web.kiwi.tcms.properties.api.TestExecutionApiProperties;
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
public class TestExecutionService extends AbstractService {

    TestExecutionApiProperties testExecutionProperties;

    @Autowired
    public TestExecutionService(RestTemplate restTemplate, KiwiTcmsApiProperties apiProperties) {
        super(restTemplate);
        this.testExecutionProperties = apiProperties.getTestExecution();
    }

    public String updateTestExecution(Long testExecutionId, UpdateTestExecutionStatusDto updateTestExecution) {
        List<Object> params = List.of(testExecutionId.toString(), updateTestExecution);
        UpdateTestExecutionStatusRequestDto body = UpdateTestExecutionStatusRequestDto.builder().method(testExecutionProperties.getUpdate()).params(params).build();
        return postAndGetRaw(body);
    }

}
