package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;

import java.util.List;

/**
 * This interface should be implemented by each tab of a popup, for example: button, image, color
 * The popup parent should be a toolbar item
 */
public interface IsPopUpTab {
    /**
     * Used to get from the ui all the configurations within a tab
     */
    List<String> getWebConfigurations();

    /**
     * Used to get all the elements available in a class that is extending this interface
     */
    List<Configuration> getConfigurations();

    void open();

//    TODO add is active method to check this

}
