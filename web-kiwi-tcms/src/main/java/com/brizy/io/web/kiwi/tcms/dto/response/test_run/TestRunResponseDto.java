package com.brizy.io.web.kiwi.tcms.dto.response.test_run;

import com.brizy.io.web.kiwi.tcms.dto.response.GetResponseDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class TestRunResponseDto extends GetResponseDto<GetTestRunDto> {
}
