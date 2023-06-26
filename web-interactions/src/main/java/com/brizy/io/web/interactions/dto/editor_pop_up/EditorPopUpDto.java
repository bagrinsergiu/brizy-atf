package com.brizy.io.web.interactions.dto.editor_pop_up;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Builder
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorPopUpDto {

    List<BlockDto> blocks;
    Map<StyleDto, Integer> styles;
    Map<CategoryDto, Integer> categories;
    Map<TabDto, Sample> content;

}
