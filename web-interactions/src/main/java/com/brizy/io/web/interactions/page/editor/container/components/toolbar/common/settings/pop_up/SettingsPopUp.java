package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up;

import com.brizy.io.web.common.dto.element.properties.common.settings.HasSettings;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;

public interface SettingsPopUp<T extends HasSettings> extends IsPopUpTab, IsToolbarItem {

    T getProperties();

    void setProperties(T properties);

}
