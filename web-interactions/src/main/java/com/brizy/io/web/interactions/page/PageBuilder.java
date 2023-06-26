package com.brizy.io.web.interactions.page;

import com.brizy.io.web.interactions.components.editor.container.EditorContainer;
import com.brizy.io.web.interactions.components.editor.container.Page;
import com.brizy.io.web.interactions.components.editor.container.PageElement;
import com.brizy.io.web.interactions.components.editor.sidebar.EditorSidebar;
import com.brizy.io.web.interactions.dto.editor.sidebar.SidebarItemDto;
import com.brizy.io.web.interactions.element.Div;
import io.vavr.control.Try;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PageBuilder {

    EditorContainer container;
    EditorSidebar sidebar;
    @Getter
    Page page;

    public PageBuilder(EditorContainer container, EditorSidebar sidebar) {
        this.container = container;
        this.sidebar = sidebar;
        this.page = new Page();
    }

    public void add(List<SidebarItemDto> elements) {
        elements.forEach(element -> {
            PageElement parentElement = getParentPageElement(element.getParentName());
            Div foundElement = sidebar.fromAddElementsControl().getElement(element.getType());
            PageElement pageElement = container.addElement(foundElement, parentElement, element.getElementPosition());
            page.addElement(element.getElementName(), pageElement);
        });
    }

    private PageElement getParentPageElement(String parentName) {
        return Try.of(() -> page.getElement(parentName))
                .getOrElse(() -> null);
    }

}
