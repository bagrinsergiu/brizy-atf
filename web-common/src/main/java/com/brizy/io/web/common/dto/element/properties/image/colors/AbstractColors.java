package com.brizy.io.web.common.dto.element.properties.image.colors;

import com.brizy.io.web.common.dto.element.properties.common.colors.border.Border;
import com.brizy.io.web.common.dto.element.properties.image.colors.overlay.Overlay;
import com.brizy.io.web.common.dto.element.properties.image.image.shadow.CanHaveShadow;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class AbstractColors implements ImageColors {

    Border border;
    Overlay overlay;
    CanHaveShadow shadow;

}
