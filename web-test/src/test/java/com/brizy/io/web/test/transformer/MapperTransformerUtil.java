package com.brizy.io.web.test.transformer;

import com.brizy.io.web.interactions.dto.editor.sidebar.SidebarItemDto;
import com.brizy.io.web.interactions.enums.ComponentPositions;
import com.brizy.io.web.interactions.enums.EditorSidebarElement;
import com.brizy.io.web.test.model.page.Item;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@UtilityClass
public class MapperTransformerUtil {

    public Function<List<Item>, List<SidebarItemDto>> getSidebarItemsDtoFromPageItems = pageItems -> pageItems.stream()
            .map(pageItem -> SidebarItemDto.builder()
                    .type(EditorSidebarElement.valueOf(pageItem.getItem()))
                    .elementPosition(ComponentPositions.findForString(pageItem.getPosition()))
                    .parentName(pageItem.getParent())
                    .elementName(pageItem.getName())
                    .componentProperties(pageItem.getProperties())
                    .componentContent(pageItem.getContent())
                    .sectionName(pageItem.getSectionName())
                    .build())
            .collect(Collectors.toList());

}
