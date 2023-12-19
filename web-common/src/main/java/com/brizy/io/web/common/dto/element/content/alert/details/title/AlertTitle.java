package com.brizy.io.web.common.dto.element.content.alert.details.title;

import com.brizy.io.web.common.dto.element.content.alert.details.AlertCommon;
import com.brizy.io.web.common.dto.element.content.alert.details.properties.AlertContentProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AlertTitle extends AlertCommon<AlertContentProperties> {
}
