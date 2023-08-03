package com.brizy.io.web.kiwi.tcms.dto.request.build;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class CreateBuildDto {

    String name;
    Long product;
    Long version;

}
