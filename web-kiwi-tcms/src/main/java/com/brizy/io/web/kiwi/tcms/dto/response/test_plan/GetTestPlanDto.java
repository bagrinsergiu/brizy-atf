package com.brizy.io.web.kiwi.tcms.dto.response.test_plan;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class GetTestPlanDto {

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
    Date createDate;
    @JsonProperty("product_version__value")
    String productVersionValue;
    @JsonProperty("product__name")
    String productName;
    @JsonProperty("author__username")
    String authorUsername;
    @JsonProperty("type__name")
    String typeName;
    @JsonProperty("children__count")
    Long childrenCount;

}
