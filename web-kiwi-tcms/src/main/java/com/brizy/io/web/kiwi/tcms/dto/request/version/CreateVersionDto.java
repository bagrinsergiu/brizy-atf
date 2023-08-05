package com.brizy.io.web.kiwi.tcms.dto.request.version;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class CreateVersionDto {

    String value;
    Long product;

}
