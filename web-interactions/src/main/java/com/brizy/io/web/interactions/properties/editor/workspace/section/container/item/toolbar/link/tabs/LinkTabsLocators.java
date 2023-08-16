package com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.link.tabs;

import com.brizy.io.web.interactions.properties.AbstractProperty;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.link.tabs.block.BlockTabLocators;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.link.tabs.file.FileTabLocators;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.link.tabs.pop_up.PopupTabLocators;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.link.tabs.url.UrlTabLocators;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@EqualsAndHashCode(callSuper = false)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class LinkTabsLocators extends AbstractProperty {

    @NestedConfigurationProperty
    UrlTabLocators url;
    @NestedConfigurationProperty
    BlockTabLocators block;
    @NestedConfigurationProperty
    PopupTabLocators popup;
    @NestedConfigurationProperty
    FileTabLocators file;

}
