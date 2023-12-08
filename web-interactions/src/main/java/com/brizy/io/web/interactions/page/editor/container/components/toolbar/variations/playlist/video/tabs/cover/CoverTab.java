package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.playlist.video.tabs.cover;

import com.brizy.io.web.common.dto.element.content.playlist.video.video.cover.CoverVideoContentProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.FileUploader;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.video.tabs.cover.CoverTabLocators;
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
public class CoverTab extends AbstractTabItem {

    Supplier<FileUploader> coverImage;

    public CoverTab(CoverTabLocators playerTabLocators, Frame frame) {
        super(playerTabLocators.getConfigurations(), playerTabLocators.getSelf(), frame);
        this.coverImage = () -> new FileUploader(playerTabLocators.getCoverImage(), frame);
    }

    public void applyProperties(CoverVideoContentProperties coverVideoContentProperties) {
        open();
        if (Objects.nonNull(coverVideoContentProperties.getCover()) && !coverVideoContentProperties.getCover().isEmpty()) {
            coverImage.get().uploadFile(Paths.get(coverVideoContentProperties.getCover()));
        }
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name("Cover Image").element(coverImage).build()
        );
    }

    public CoverVideoContentProperties getProperties() {
        open();
        return CoverVideoContentProperties.builder()
                .cover((Try.of(() -> await().atMost(200, MILLISECONDS).until(() -> coverImage.get().getFileName(), value -> !value.isEmpty())).getOrElse(StringUtils.EMPTY)))
                .build();
    }

}
