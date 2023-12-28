package com.brizy.io.web.common.dto.element.content.alert.details.properties;

import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.common.typography.Typography;
import com.brizy.io.web.common.dto.element.properties.text.TextProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true)
public class AlertContentProperties extends TextProperties {

    Typography typography;
    Alignments align;

}
