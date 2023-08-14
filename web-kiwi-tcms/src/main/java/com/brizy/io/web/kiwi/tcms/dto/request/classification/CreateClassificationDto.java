package com.brizy.io.web.kiwi.tcms.dto.request.classification;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class CreateClassificationDto {

    String name;

}
