package com.brizy.io.web.kiwi.tcms.dto.response.test_case;

import com.brizy.io.web.kiwi.tcms.dto.response.GetResponseDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class TestCaseResponseDto extends GetResponseDto<GetTestCaseDto> {
}
