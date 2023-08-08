package com.brizy.io.web.common.dto.element.properties.common.colors;

import com.brizy.io.web.common.dto.element.properties.common.colors.border.Border;
import com.brizy.io.web.common.dto.element.properties.common.colors.border.CanHaveBorders;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Colors implements CanHaveBorders {

    Border border;

}
