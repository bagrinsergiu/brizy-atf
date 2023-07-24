package com.brizy.io.web.kiwi.tcms.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class CreateResponseDto<T> extends AbstractResponseDto {

    T result;

}
