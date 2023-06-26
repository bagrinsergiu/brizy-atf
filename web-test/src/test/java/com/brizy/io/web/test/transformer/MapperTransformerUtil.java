package com.brizy.io.web.test.transformer;

import com.brizy.io.web.interactions.dto.editor.sidebar.SidebarItemDto;
import com.brizy.io.web.interactions.enums.EditorSidebarElement;
import com.brizy.io.web.interactions.enums.ElementPositions;
import com.brizy.io.web.test.model.page.Item;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@UtilityClass
public class MapperTransformerUtil {

    public Function<List<Item>, List<SidebarItemDto>> getSidebarItemsDtoFromPageItems = pageItems -> pageItems.stream()
            .map(el -> SidebarItemDto.builder()
                    .type(EditorSidebarElement.valueOf(el.getItem()))
                    .elementPosition(ElementPositions.findForString(el.getPosition()))
                    .parentName(el.getParent())
                    .elementName(el.getName())
                    .build())
            .collect(Collectors.toList());

}
