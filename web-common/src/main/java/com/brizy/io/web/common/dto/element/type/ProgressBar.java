package com.brizy.io.web.common.dto.element.type;

import com.brizy.io.web.common.dto.element.content.progress_bar.ProgressBarContentProperties;
import com.brizy.io.web.common.dto.element.properties.progress_bar.ProgressBarProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class ProgressBar extends AbstractPropertyType<ProgressBarProperties> implements ItemTypeWithContent {

    ProgressBarProperties properties;

    ProgressBarContentProperties[] content;

}
