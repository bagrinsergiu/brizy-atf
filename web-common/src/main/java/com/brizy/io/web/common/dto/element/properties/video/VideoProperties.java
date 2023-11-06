package com.brizy.io.web.common.dto.element.properties.video;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.text.colors.Colors;
import com.brizy.io.web.common.dto.element.properties.video.video.Video;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class VideoProperties implements Property {

    Colors colors;
    Alignments align;
    Video video;


}
