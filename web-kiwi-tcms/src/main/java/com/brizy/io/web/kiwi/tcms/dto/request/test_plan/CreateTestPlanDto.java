package com.brizy.io.web.kiwi.tcms.dto.request.test_plan;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class CreateTestPlanDto {

    String name;
    Long product;
    @JsonProperty("product_version")
    Long productVersion;
    Long type;
    @JsonProperty("extra_link")
    String referenceLink;
    String text;
    @Builder.Default
    Boolean notifyAuthor = false;
    @Builder.Default
    Boolean notifyTestCaseAuthor = false;
    @Builder.Default
    Boolean notifyDefaultTester = false;
    @Builder.Default
    Boolean notifyWhenTestPlanIsUpdated = false;
    @Builder.Default
    Boolean notifyWhenTestCaseAreUpdated = false;

}
