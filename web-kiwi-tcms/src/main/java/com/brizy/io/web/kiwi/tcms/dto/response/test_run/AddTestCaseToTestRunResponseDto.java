package com.brizy.io.web.kiwi.tcms.dto.response.test_run;

import com.brizy.io.web.kiwi.tcms.dto.response.AbstractResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
public class AddTestCaseToTestRunResponseDto extends AbstractResponseDto {

    List<AddTestCaseToTestRunDto> result;

}
