package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;

import java.util.List;

public interface IsTab {
    /**
     * Used to get from the ui all the configurations within a tab
     */
    List<String> getWebConfigurations();

    /**
     * Used to get all the elements available in a class that is extending this interface
     */
    List<Configuration> getConfigurations();

}
