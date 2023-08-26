package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs;

import java.util.List;

/*
 * Each toolbar item should implement this interface
 * */
public interface IsToolbarItem {

    void open();

    List<String> getTabs();

    IsPopUpTab openTab(String tab);

}
