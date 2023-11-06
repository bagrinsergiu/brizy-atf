package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.video.video.tabs.video;

import com.brizy.io.web.common.dto.element.properties.video.video.video.Video;
import com.brizy.io.web.common.dto.element.properties.video.video.video.player.Players;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.FileUploader;
import com.brizy.io.web.interactions.element.composite.InputWithPopulation;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.video.tabs.video.VideoTabLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.microsoft.playwright.Frame;
import io.vavr.control.Try;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;
import org.apache.commons.lang3.StringUtils;

import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.awaitility.Awaitility.await;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class VideoTab extends AbstractTabItem {

    Supplier<ComboBox> type;
    Supplier<ComboBox> ratio;
    Supplier<InputWithPopulation> link;
    Supplier<FileUploader> file;

    public VideoTab(VideoTabLocators videoTabLocators, Frame frame) {
        super(videoTabLocators.getConfigurations(), videoTabLocators.getSelf(), frame);
        this.type = () -> new ComboBox(frame.locator(videoTabLocators.getType()));
        this.ratio = () -> new ComboBox(frame.locator(videoTabLocators.getRatio()));
        this.link = () -> new InputWithPopulation(videoTabLocators.getLink(), frame);
        this.file = () -> new FileUploader(videoTabLocators.getFile(), frame);
    }

    public void applyProperties(Video videoTabProperties) {
        open();
        if (Objects.nonNull(videoTabProperties.getType())) {
            type.get().selectItemByName(videoTabProperties.getType().getValue());
        }
        if (Objects.nonNull(videoTabProperties.getRatio())) {
            ratio.get().selectItemByName(videoTabProperties.getRatio());
        }
        if (Objects.nonNull(videoTabProperties.getLink())) {
            link.get().setValue(videoTabProperties.getLink());
        }
        if (Objects.nonNull(videoTabProperties.getFile())) {
            file.get().uploadFile(Paths.get(videoTabProperties.getFile()));
        }
    }

    public Video getProperties() {
        open();
        return Video.builder()
                .file(Try.of(() -> await().atMost(200, MILLISECONDS).until(() -> file.get().getFileName(), value -> !value.isEmpty())).getOrElse(StringUtils.EMPTY))
                .link(link.get().getValue())
                .ratio(ratio.get().getSelectedItem())
                .type(Players.valueOf(type.get().getSelectedItem().toUpperCase()))
                .build();
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.type).element(type).build(),
                Configuration.builder().name(Fields.ratio).element(ratio).build(),
                Configuration.builder().name(Fields.link).element(link).build()
        );
    }

}
