package com.brizy.io.web.common.dto.element.properties.video.video.playback;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Playback {

    Boolean autoplay;
    Boolean muted;
    Boolean loop;
    String suggestedVideo;
    Integer start;
    Integer end;

}
