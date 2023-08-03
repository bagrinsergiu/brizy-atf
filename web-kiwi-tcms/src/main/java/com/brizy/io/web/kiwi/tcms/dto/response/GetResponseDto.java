package com.brizy.io.web.kiwi.tcms.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class GetResponseDto<T> extends AbstractResponseDto {

    List<T> result;

}
