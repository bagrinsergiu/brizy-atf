package com.brizy.io.web.common.dto.element.content.playlist.video.video.advanced;

import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AdvancedVideoContentProperties {

    Boolean controls;
    Boolean branding;
    Boolean loop;
    Boolean intro;
    Integer start;
    Integer end;

}
