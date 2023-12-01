package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.playlist.tabs;

import com.brizy.io.web.common.dto.element.properties.playlist.playlist.playlist.Playlist;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.composite.InputWithUnits;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.playlist.tabs.playlist.PlaylistTabLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PlaylistTab extends AbstractTabItem {

    Supplier<ComboBox> position;
    Supplier<ComboBox> thumbs;
    Supplier<InputWithUnits> columns;

    public PlaylistTab(PlaylistTabLocators playlistLocators, Frame frame) {
        super(playlistLocators.getConfigurations(), playlistLocators.getSelf(), frame);
        this.position = () -> new ComboBox(frame.locator(playlistLocators.getPosition()));
        this.thumbs = () -> new ComboBox(frame.locator(playlistLocators.getThumbs()));
        this.columns = () -> new InputWithUnits(playlistLocators.getColumns(), frame);
    }

    public void applyProperties(Playlist playlist) {
        open();
        if (Objects.nonNull(playlist.getPosition())) {
            position.get().selectItemByName(playlist.getPosition());
        }
        if (Objects.nonNull(playlist.getThumbs())) {
            thumbs.get().selectItemByName(playlist.getThumbs());
        }
        if (Objects.nonNull(playlist.getColumns())) {
            columns.get().setValue(playlist.getColumns());
        }
    }

    public Playlist getProperties() {
        open();
        return Playlist.builder()
                .columns(columns.get().getValue())
                .position(position.get().getSelectedItem())
                .thumbs(thumbs.get().getSelectedItem())
                .build();
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.position).element(position).build(),
                Configuration.builder().name(Fields.thumbs).element(thumbs).build(),
                Configuration.builder().name(Fields.columns).element(columns).build()
        );
    }

}
