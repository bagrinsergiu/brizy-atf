package com.brizy.io.web.kiwi.tcms.dto.response.test_run;

import com.brizy.io.web.kiwi.tcms.dto.response.AbstractResponseDto;
import com.brizy.io.web.kiwi.tcms.dto.response.CreateResponseDto;
import lombok.Data;

import java.util.List;

@Data
public class AddTestCaseToTestRunResponseDto extends AbstractResponseDto {

    List<AddTestCaseToTestRunDto> result;

}
