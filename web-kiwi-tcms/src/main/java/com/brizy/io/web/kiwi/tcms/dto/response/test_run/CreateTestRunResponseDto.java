package com.brizy.io.web.kiwi.tcms.dto.response.test_run;

import com.brizy.io.web.kiwi.tcms.dto.response.CreateResponseDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class CreateTestRunResponseDto extends CreateResponseDto<CreateTestRunDto> {
}
