package com.brizy.io.web.common.dto.element.properties.text;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.common.list.ListStyles;
import com.brizy.io.web.common.dto.element.properties.common.typography.Typography;
import com.brizy.io.web.common.dto.element.properties.text.colors.Colors;
import com.brizy.io.web.common.dto.element.properties.text.settings.Settings;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TextProperties implements Property {

    Colors colors;
    @Getter
    Typography typography;
    Alignments align;
    ListStyles list;
    boolean bold;
    boolean italic;
    boolean underline;
    boolean strike;
    boolean uppercase;
    Settings settings;

}
