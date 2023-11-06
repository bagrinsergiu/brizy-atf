package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.video.video.tabs.player;

import com.brizy.io.web.common.dto.element.properties.video.video.player.Player;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.FileUploader;
import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.video.tabs.player.PlayerTabLocators;
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
public class PlayerTab extends AbstractTabItem {

    Supplier<FileUploader> coverImage;
    Supplier<Slider> controls;
    Supplier<Slider> branding;
    Supplier<Slider> lazyLoad;
    Supplier<Slider> privacyMode;

    public PlayerTab(PlayerTabLocators playerTabLocators, Frame frame) {
        super(playerTabLocators.getConfigurations(), playerTabLocators.getSelf(), frame);
        this.coverImage = () -> new FileUploader(playerTabLocators.getCoverImage(), frame);
        this.controls = () -> new Slider(frame.locator(playerTabLocators.getControls()));
        this.branding = () -> new Slider(frame.locator(playerTabLocators.getBranding()));
        this.lazyLoad = () -> new Slider(frame.locator(playerTabLocators.getLazyLoad()));
        this.privacyMode = () -> new Slider(frame.locator(playerTabLocators.getPrivacyMode()));
    }

    public void applyProperties(Player player) {
        open();
        if (Objects.nonNull(player.getCoverImage()) && !player.getCoverImage().isEmpty()) {
            coverImage.get().uploadFile(Paths.get(player.getCoverImage()));
        }
        if (Objects.nonNull(player.getControls())) {
            controls.get().switchTo(player.getControls());
        }
        if (Objects.nonNull(player.getBranding())) {
            branding.get().switchTo(player.getBranding());
        }
        if (Objects.nonNull(player.getLazyLoad())) {
            lazyLoad.get().switchTo(player.getLazyLoad());
        }
        if (Objects.nonNull(player.getPrivacyMode())) {
            privacyMode.get().switchTo(player.getPrivacyMode());
        }
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name("Cover Image").element(coverImage).build(),
                Configuration.builder().name(Fields.controls).element(controls).build(),
                Configuration.builder().name(Fields.branding).element(branding).build(),
                Configuration.builder().name("Lazy Load".toLowerCase()).element(lazyLoad).build(),
                Configuration.builder().name("Privacy Mode").element(privacyMode).build()
        );
    }

    public Player getProperties() {
        open();
        return Player.builder()
                .branding(branding.get().getState())
                .controls(controls.get().getState())
                .coverImage((Try.of(() -> await().atMost(200, MILLISECONDS).until(() -> coverImage.get().getFileName(), value -> !value.isEmpty())).getOrElse(StringUtils.EMPTY)))
                .lazyLoad(lazyLoad.get().getState())
                .privacyMode(privacyMode.get().getState())
                .build();
    }

}
