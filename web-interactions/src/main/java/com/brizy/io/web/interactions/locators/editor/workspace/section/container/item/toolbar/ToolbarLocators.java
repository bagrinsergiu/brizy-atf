package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.alert.AlertLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.audio.AudioLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.button.ButtonLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.calendly.CalendlyLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.colors.ColorsLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.countdown.CountdownLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.counter.CounterLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.FieldLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.icon.IconLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.image.ImageLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.link.LinkLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.lottie.LottieLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.mover.MoverLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.playlist.PlaylistLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.progress.ProgressLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.rating.RatingLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.SettingsLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.typography.TypographyProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.video.VideoLocators;
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
public class ToolbarLocators {

    String italic;
    String underline;
    String strike;
    String uppercase;
    String bold;
    String list;
    String item;
    String align;
    String delete;
    String duplicate;
    @NestedConfigurationProperty
    MoverLocators mover;
    @NestedConfigurationProperty
    FieldLocators field;
    @NestedConfigurationProperty
    TypographyProperties typography;
    @NestedConfigurationProperty
    ColorsLocators colors;
    @NestedConfigurationProperty
    CounterLocators counter;
    @NestedConfigurationProperty
    ButtonLocators button;
    @NestedConfigurationProperty
    IconLocators icon;
    @NestedConfigurationProperty
    SettingsLocators settings;
    @NestedConfigurationProperty
    ImageLocators image;
    @NestedConfigurationProperty
    VideoLocators video;
    @NestedConfigurationProperty
    AudioLocators audio;
    @NestedConfigurationProperty
    PlaylistLocators playlist;
    @NestedConfigurationProperty
    RatingLocators rating;
    @NestedConfigurationProperty
    AlertLocators alert;
    @NestedConfigurationProperty
    LottieLocators lottie;
    @NestedConfigurationProperty
    ProgressLocators progress;
    @NestedConfigurationProperty
    CalendlyLocators calendly;
    @NestedConfigurationProperty
    CountdownLocators countdown;
    @NestedConfigurationProperty
    LinkLocators link;

}
