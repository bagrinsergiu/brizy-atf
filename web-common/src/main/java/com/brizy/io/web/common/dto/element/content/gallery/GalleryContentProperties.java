package com.brizy.io.web.common.dto.element.content.gallery;

import com.brizy.io.web.common.dto.element.type.Content;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true)
public class GalleryContentProperties implements Content {

    List<String> imagePaths;

}