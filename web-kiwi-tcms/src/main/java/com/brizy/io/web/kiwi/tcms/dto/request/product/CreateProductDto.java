package com.brizy.io.web.kiwi.tcms.dto.request.product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class CreateProductDto {

    String name;
    String description;
    Long classification;

}
