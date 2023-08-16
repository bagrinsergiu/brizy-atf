package com.brizy.io.web.common.dto.element.properties.button.button.icon.size;

import com.brizy.io.web.common.dto.element.properties.button.button.button.size.SizeTypes;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ConcreteSize implements Size {

    IconSizes size;

}
