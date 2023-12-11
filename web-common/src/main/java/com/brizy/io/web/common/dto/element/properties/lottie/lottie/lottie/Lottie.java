package com.brizy.io.web.common.dto.element.properties.lottie.lottie.lottie;

import com.brizy.io.web.common.dto.element.properties.common.InputWithUnitsProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Lottie {

    String lottieLink;
    String lottieFile;
    String renderer;
    Boolean autoplay;
    Boolean reverse;
    Boolean loop;
    InputWithUnitsProperties speed;

}
