package com.brizy.io.web.kiwi.tcms.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class CreateResponseDto<T> extends AbstractResponseDto {

    T result;

}
