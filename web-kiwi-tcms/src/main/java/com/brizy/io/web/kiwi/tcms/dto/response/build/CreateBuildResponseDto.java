package com.brizy.io.web.kiwi.tcms.dto.response.build;

import com.brizy.io.web.kiwi.tcms.dto.response.CreateResponseDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@Builder(toBuilder = true)
public class CreateBuildResponseDto extends CreateResponseDto<BuildDto> {
}
