package com.brizy.io.web.kiwi.tcms.dto.response.product;

import com.brizy.io.web.kiwi.tcms.dto.response.CreateResponseDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@Builder(toBuilder = true)
public class CreateProductResponseDto extends CreateResponseDto<ProductDto> {
}
