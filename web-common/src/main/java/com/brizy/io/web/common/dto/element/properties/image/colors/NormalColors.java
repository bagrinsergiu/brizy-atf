package com.brizy.io.web.common.dto.element.properties.image.colors;

import com.brizy.io.web.common.dto.element.properties.common.Colors;
import com.brizy.io.web.common.dto.element.properties.common.colors.border.Border;
import com.brizy.io.web.common.dto.element.properties.image.colors.overlay.Overlay;
import com.brizy.io.web.common.dto.element.properties.image.image.shadow.CanHaveShadow;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NormalColors extends AbstractColors {
}
