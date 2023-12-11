package com.brizy.io.web.common.dto.element.type;

import com.brizy.io.web.common.dto.element.properties.lottie.LottieProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Lottie extends AbstractPropertyType<LottieProperties> implements ItemType {

    @Getter
    LottieProperties properties;

}
