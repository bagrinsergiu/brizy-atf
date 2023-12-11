package com.brizy.io.web.common.dto.element.properties.lottie.lottie;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Lottie {

    com.brizy.io.web.common.dto.element.properties.lottie.lottie.lottie.Lottie lottie;

}
