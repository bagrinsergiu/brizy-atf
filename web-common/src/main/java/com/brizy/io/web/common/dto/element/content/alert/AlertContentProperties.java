package com.brizy.io.web.common.dto.element.content.alert;

import com.brizy.io.web.common.dto.element.content.alert.details.description.AlertDescription;
import com.brizy.io.web.common.dto.element.content.alert.details.title.AlertTitle;
import com.brizy.io.web.common.dto.element.type.Content;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AlertTitle.class, name = "title"),
        @JsonSubTypes.Type(value = AlertDescription.class, name = "description")
})
public interface AlertContentProperties extends Content {
}
