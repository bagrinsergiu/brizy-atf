package com.brizy.io.web.interactions.page;

import com.brizy.io.web.interactions.components.editor.container.EditorContainer;
import com.brizy.io.web.interactions.components.editor.container.components.Component;
import com.brizy.io.web.interactions.components.editor.sidebar.EditorSidebar;
import com.brizy.io.web.interactions.dto.editor.sidebar.SidebarItemDto;
import com.brizy.io.web.interactions.properties.editor.EditorPageProperties;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PageBuilder {

    EditorContainer container;
    EditorSidebar sidebar;

    public PageBuilder(EditorPageProperties editorPageProperties, com.microsoft.playwright.Page page) {
        this.sidebar = new EditorSidebar(editorPageProperties.getSidebar(), page);
        this.container = new EditorContainer(editorPageProperties.getFrame(), page);
    }

    public PageBuilderOperations _do() {
        return new PageBuilderOperations();
    }

    @FieldDefaults(level = AccessLevel.PRIVATE)
    public class PageBuilderOperations {

        Boolean add;
        Boolean configure;

        public PageBuilderOperations() {
            this.add = false;
            this.configure = false;
        }

        public PageBuilderOperations openPopUpMenu() {
            waitToLoad();
            container.openPopUpMenu();
            return this;
        }

        private PageBuilderOperations waitToLoad() {
            container.waitForFrameLoadState();
            return this;
        }

        public PageBuilderOperations addSection(String section) {
            container.addSection(section);
            return this;
        }

        public PageBuilderOperations add() {
            add = true;
            return this;
        }

        public PageBuilderOperations configure() {
            configure = true;
            return this;
        }

        public Component getComponent(String sectionName, String componentName) {
            return container.get(sectionName, componentName);
        }

        public PageBuilderOperations and() {
            return this;
        }

        public void items(List<SidebarItemDto> elements) {
            if (add) {
                container.addComponent(elements, elementType -> sidebar.fromAddElementsControl().getElement(elementType));
                add = false;
            }
            if (configure) {
                container.configureComponents(elements);
                configure = false;
            }
        }

    }

}