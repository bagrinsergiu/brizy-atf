package com.brizy.io.web.kiwi.tcms.dto.response.version;

import com.brizy.io.web.kiwi.tcms.dto.response.GetResponseDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@Builder(toBuilder = true)
public class VersionResponseDto extends GetResponseDto<VersionDto> {
}
