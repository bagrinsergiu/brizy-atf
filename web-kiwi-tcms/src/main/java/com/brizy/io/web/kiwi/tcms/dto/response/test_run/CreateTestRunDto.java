package com.brizy.io.web.kiwi.tcms.dto.response.test_run;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateTestRunDto {

    Long id;
    Long parent;
    String name;
    String text;
    @JsonProperty("is_active")
    Boolean isActive;
    @JsonProperty("extra_link")
    String extraLink;
    @JsonProperty("product_version")
    Long productVersion;
    Long author;
    Long product;
    Long type;
    @JsonProperty("create_date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    String createDate;

}
