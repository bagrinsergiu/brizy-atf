package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.video.video.tabs.playback;

import com.brizy.io.web.common.dto.element.properties.video.video.playback.Playback;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.NumericInput;
import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.video.tabs.playback.PlaybackTabLocators;
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
public class PlaybackTab extends AbstractTabItem {

    Supplier<Slider> autoplay;
    Supplier<NumericInput> end;
    Supplier<Slider> loop;
    Supplier<Slider> muted;
    Supplier<NumericInput> start;
    Supplier<ComboBox> suggestedVideos;

    public PlaybackTab(PlaybackTabLocators playbackTabLocators, Frame frame) {
        super(playbackTabLocators.getConfigurations(), playbackTabLocators.getSelf(), frame);
        this.autoplay = () -> new Slider(frame.locator(playbackTabLocators.getAutoplay()));
        this.end = () -> new NumericInput(frame.locator(playbackTabLocators.getEnd()));
        this.loop = () -> new Slider(frame.locator(playbackTabLocators.getLoop()));
        this.muted = () -> new Slider(frame.locator(playbackTabLocators.getMuted()));
        this.start = () -> new NumericInput(frame.locator(playbackTabLocators.getStart()));
        this.suggestedVideos = () -> new ComboBox(frame.locator(playbackTabLocators.getSuggestedVideos()));
    }

    public void applyProperties(Playback playback) {
        open();
        if (Objects.nonNull(playback.getAutoplay())) {
            autoplay.get().switchTo(playback.getAutoplay());
        }
        if (Objects.nonNull(playback.getEnd())) {
            end.get().fill(playback.getEnd());
        }
        if (Objects.nonNull(playback.getLoop())) {
            loop.get().switchTo(playback.getLoop());
        }
        if (Objects.nonNull(playback.getMuted())) {
            muted.get().switchTo(playback.getMuted());
        }
        if (Objects.nonNull(playback.getStart())) {
            start.get().fill(playback.getStart());
        }
        if (Objects.nonNull(playback.getSuggestedVideo())) {
            suggestedVideos.get().selectItemByName(playback.getSuggestedVideo());
        }
    }

    public Playback getProperties() {
        open();
        return Playback.builder()
                .autoplay(autoplay.get().getState())
                .end(end.get().getValue(Integer.class))
                .loop(loop.get().getState())
                .muted(muted.get().getState())
                .start(start.get().getValue(Integer.class))
                .suggestedVideo(suggestedVideos.get().getSelectedItem())
                .build();
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.autoplay).element(autoplay).build(),
                Configuration.builder().name(Fields.end).element(end).build(),
                Configuration.builder().name(Fields.loop).element(loop).build(),
                Configuration.builder().name(Fields.muted).element(muted).build(),
                Configuration.builder().name(Fields.start).element(start).build(),
                Configuration.builder().name("Suggested Videos").element(suggestedVideos).build()
        );
    }

}
