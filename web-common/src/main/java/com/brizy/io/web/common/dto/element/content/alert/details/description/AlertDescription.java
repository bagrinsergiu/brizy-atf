package com.brizy.io.web.common.dto.element.content.alert.details.description;

import com.brizy.io.web.common.dto.element.content.alert.details.AlertCommon;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AlertDescription extends AlertCommon<Settings> {
}
