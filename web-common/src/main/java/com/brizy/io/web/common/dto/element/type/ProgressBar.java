package com.brizy.io.web.common.dto.element.type;

import com.brizy.io.web.common.dto.element.properties.lottie.LottieProperties;
import com.brizy.io.web.common.dto.element.properties.progress_bar.ProgressBarProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProgressBar extends AbstractPropertyType<LottieProperties> implements ItemType {

    @Getter
    ProgressBarProperties properties;

}
