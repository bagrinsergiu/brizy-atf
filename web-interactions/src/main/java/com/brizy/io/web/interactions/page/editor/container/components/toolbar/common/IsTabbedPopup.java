package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common;

import java.util.List;

public interface IsTabbedPopup {

    List<String> getTabs();

    IsTab openTab(String tab);

}
