package com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.posts;

import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.abstracts.NewContentDto;
import com.brizy.io.web.interactions.enums.PublishedItems;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.nio.file.Path;

@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NewPostContentDto implements NewContentDto {

    String title;
    String slug;
    NewPostExcerptDto excerpt;
    Path featuredImage;
    PublishedItems published;

}
