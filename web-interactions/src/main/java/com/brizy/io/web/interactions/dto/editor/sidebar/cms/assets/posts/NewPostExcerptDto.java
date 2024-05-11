package com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.posts;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NewPostExcerptDto {

    Boolean isBold;
    Boolean isItalic;
    Boolean isUnderline;
    String text;

}
