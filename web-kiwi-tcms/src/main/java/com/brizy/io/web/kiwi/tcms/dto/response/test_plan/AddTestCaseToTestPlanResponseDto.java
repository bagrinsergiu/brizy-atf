package com.brizy.io.web.kiwi.tcms.dto.response.test_plan;

import com.brizy.io.web.kiwi.tcms.dto.response.AbstractResponseDto;
import com.brizy.io.web.kiwi.tcms.dto.response.CreateResponseDto;
import com.brizy.io.web.kiwi.tcms.dto.response.test_run.AddTestCaseToTestRunDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
public class AddTestCaseToTestPlanResponseDto extends CreateResponseDto<AddTestCaseToTestPlanDto> {
}
