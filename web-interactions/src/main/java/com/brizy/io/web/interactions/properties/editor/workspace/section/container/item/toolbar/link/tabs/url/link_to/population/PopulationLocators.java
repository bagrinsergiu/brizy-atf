package com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.link.tabs.url.link_to.population;

import com.brizy.io.web.interactions.properties.AbstractProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class PopulationLocators extends AbstractProperty {

    String items;

}
