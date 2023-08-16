package com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.link.tabs.url;

import com.brizy.io.web.interactions.properties.AbstractProperty;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.common.InputWithPopulationLocators;
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
public class UrlTabLocators extends AbstractProperty {

    @NestedConfigurationProperty
    InputWithPopulationLocators linkTo;
    String openInNewTab;
    String makeItNoFollow;

}
