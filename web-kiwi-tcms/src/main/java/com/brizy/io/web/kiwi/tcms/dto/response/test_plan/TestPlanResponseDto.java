package com.brizy.io.web.kiwi.tcms.dto.response.test_plan;

import com.brizy.io.web.kiwi.tcms.dto.response.GetResponseDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class TestPlanResponseDto extends GetResponseDto<GetTestPlanDto> {
}
