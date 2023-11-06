package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.video.video;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.video.VideoLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.video.video.tabs.playback.PlaybackTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.video.video.tabs.player.PlayerTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.video.video.tabs.video.VideoTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

import static com.brizy.io.web.common.dto.element.properties.video.video.Video.builder;
import static io.vavr.API.$;
import static io.vavr.API.Case;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Video extends AbstractToolbarItem {

    Supplier<VideoTab> video;
    Supplier<PlaybackTab> playback;
    Supplier<PlayerTab> player;

    public Video(VideoLocators videoLocators, Frame frame) {
        super(videoLocators.getSelf(), videoLocators.getTabs().getSelf(), frame);
        this.video = () -> new VideoTab(videoLocators.getTabs().getVideo(), frame);
        this.playback = () -> new PlaybackTab(videoLocators.getTabs().getPlayback(), frame);
        this.player = () -> new PlayerTab(videoLocators.getTabs().getPlayer(), frame);
    }

    public void applyProperties(com.brizy.io.web.common.dto.element.properties.video.video.Video videoProperties) {
        open();
        if (Objects.nonNull(videoProperties.getVideo())) {
            video.get().applyProperties(videoProperties.getVideo());
        }
        if (Objects.nonNull(videoProperties.getPlayback())) {
            playback.get().applyProperties(videoProperties.getPlayback());
        }
        if (Objects.nonNull(videoProperties.getPlayer())) {
            player.get().applyProperties(videoProperties.getPlayer());
        }
    }

    @Override
    public IsPopUpTab openTab(String tab) {
        open();
        return io.vavr.API.Match(tab.toLowerCase()).of(
                Case($(Fields.video), video),
                Case($(Fields.playback), playback),
                Case($(), player)
        );
    }

    public com.brizy.io.web.common.dto.element.properties.video.video.Video getProperties() {
        open();
        return builder()
                .video(video.get().getProperties())
                .player(player.get().getProperties())
                .playback(playback.get().getProperties())
                .build();
    }

}
