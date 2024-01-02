package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.content;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.content.alert.AlertContentLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.content.playlist.PlaylistContentLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.content.progress_bar.ProgressBarContentLocators;
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
public class ItemContentLocators {

    @NestedConfigurationProperty
    PlaylistContentLocators playlist;
    @NestedConfigurationProperty
    AlertContentLocators alert;
    @NestedConfigurationProperty
    ProgressBarContentLocators progress;

}
