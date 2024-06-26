package com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.pages;

import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.abstracts.NewContentDto;
import com.brizy.io.web.interactions.enums.PublishedItems;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NewPageContentDto implements NewContentDto {

    String title;
    String slug;
    NewPageDescriptionDto description;
    PublishedItems published;

}
