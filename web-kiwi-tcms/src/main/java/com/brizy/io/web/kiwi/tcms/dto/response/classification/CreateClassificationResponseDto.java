package com.brizy.io.web.kiwi.tcms.dto.response.classification;

import com.brizy.io.web.kiwi.tcms.dto.response.CreateResponseDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class CreateClassificationResponseDto extends CreateResponseDto<ClassificationDto> {
}
