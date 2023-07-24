package com.brizy.io.web.kiwi.tcms.dto.response.test_plan;

import com.brizy.io.web.kiwi.tcms.dto.response.CreateResponseDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class CreateTestPlanResponseDto extends CreateResponseDto<CreateTestPlanDto> {
}
