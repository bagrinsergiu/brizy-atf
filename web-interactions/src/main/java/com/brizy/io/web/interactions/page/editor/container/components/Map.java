package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.properties.map.MapProperties;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.MapToolbar;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemProperties;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Map extends Component<MapProperties> {

    @Getter
    MapToolbar toolbar;

    public Map(ItemProperties itemProperties, Frame frame, Locator locator) {
        super(frame, locator, itemProperties);
        this.toolbar = new MapToolbar(itemProperties.getToolbar(), frame);
    }

    @Override
    public MapProperties getEditorProperties() {
//        TODO implement
        return null;
    }
}
