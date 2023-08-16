package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.Button;

import java.util.List;
import java.util.function.Supplier;

public interface IsTab {
    /**
     * Used to get from the ui all the configurations within a tab
     */
    List<String> getWebConfigurations();

    /**
     * Used to get all the elements available in a class that is extending this interface
     */
    List<Configuration> getConfigurations();

    Supplier<Button> getTabButton();

    default void open() {
        getTabButton().get().click();
    }

//    TODO add is active method to check this

}
