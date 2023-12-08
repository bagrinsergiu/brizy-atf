package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.playlist.video.tabs;

import com.brizy.io.web.common.dto.element.content.playlist.video.video.PlaylistVideoTabProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.video.VideoLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.playlist.video.tabs.advanced.AdvancedTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.playlist.video.tabs.cover.CoverTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.playlist.video.tabs.video.VideoTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.$;
import static io.vavr.API.Case;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PlaylistVideo extends AbstractToolbarItem {

    Supplier<VideoTab> video;
    Supplier<AdvancedTab> advanced;
    Supplier<CoverTab> cover;

    public PlaylistVideo(VideoLocators videoLocators, Frame frame) {
        super(videoLocators.getSelf(), videoLocators.getTabs().getSelf(), frame);
        this.video = () -> new VideoTab(videoLocators.getTabs().getVideo(), frame);
        this.advanced = () -> new AdvancedTab(videoLocators.getTabs().getAdvanced(), frame);
        this.cover = () -> new CoverTab(videoLocators.getTabs().getCover(), frame);
    }

    public void applyProperties(PlaylistVideoTabProperties videoProperties) {
        open();
        if (Objects.nonNull(videoProperties.getVideo())) {
            video.get().applyProperties(videoProperties.getVideo());
        }
        if (Objects.nonNull(videoProperties.getAdvanced())) {
            advanced.get().applyProperties(videoProperties.getAdvanced());
        }
        if (Objects.nonNull(videoProperties.getCover())) {
            cover.get().applyProperties(videoProperties.getCover());
        }
    }

    @Override
    public IsPopUpTab openTab(String tab) {
        open();
        return io.vavr.API.Match(tab.toLowerCase()).of(
                Case($(Fields.video), video),
                Case($(Fields.advanced), advanced),
                Case($(), cover)
        );
    }

    public PlaylistVideoTabProperties getProperties() {
        open();
        return PlaylistVideoTabProperties.builder()
                .video(video.get().getProperties())
                .cover(cover.get().getProperties())
                .advanced(advanced.get().getProperties())
                .build();
    }

}
