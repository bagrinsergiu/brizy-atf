package com.brizy.io.web.kiwi.tcms.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
public class GetResponseDto<T> extends AbstractResponseDto {

    List<T> result;

}
