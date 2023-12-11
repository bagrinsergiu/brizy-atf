package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.lottie.tabs;

import com.brizy.io.web.common.dto.element.properties.lottie.lottie.lottie.Lottie;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.FileUploader;
import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.element.composite.InputWithUnits;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.lottie.tabs.lottie.LottieTabLocators;
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
public class LottieTab extends AbstractTabItem {

    Supplier<TextInput> lottieLink;
    Supplier<FileUploader> lottieFile;
    Supplier<ComboBox> renderer;
    Supplier<Slider> autoplay;
    Supplier<Slider> reverse;
    Supplier<Slider> loop;
    Supplier<InputWithUnits> speed;

    public LottieTab(LottieTabLocators lottieTabLocators, Frame frame) {
        super(lottieTabLocators.getConfigurations(), lottieTabLocators.getSelf(), frame);
        this.lottieLink = () -> new TextInput(frame.locator(lottieTabLocators.getLottieLink()));
        this.lottieFile = () -> new FileUploader(lottieTabLocators.getLottieFile(), frame);
        this.renderer = () -> new ComboBox(frame.locator(lottieTabLocators.getRenderer()));
        this.autoplay = () -> new Slider(frame.locator(lottieTabLocators.getAutoplay()));
        this.reverse = () -> new Slider(frame.locator(lottieTabLocators.getReverse()));
        this.loop = () -> new Slider(frame.locator(lottieTabLocators.getLoop()));
        this.speed = () -> new InputWithUnits(lottieTabLocators.getSpeed(), frame);
    }

    public void applyProperties(Lottie lottie) {
        open();
        if (Objects.nonNull(lottie.getLottieLink()) && !lottie.getLottieLink().isEmpty()) {
            lottieLink.get().fill(lottie.getLottieLink());
        }
        if (Objects.nonNull(lottie.getLottieFile()) && !lottie.getLottieFile().isEmpty()) {
            lottieFile.get().uploadFile(Paths.get(lottie.getLottieFile()));
        }
        if (Objects.nonNull(lottie.getAutoplay())) {
            autoplay.get().switchTo(lottie.getAutoplay());
        }
        if (Objects.nonNull(lottie.getReverse())) {
            reverse.get().switchTo(lottie.getReverse());
        }
        if (Objects.nonNull(lottie.getRenderer())) {
            renderer.get().selectItemByName(lottie.getRenderer());
        }
        if (Objects.nonNull(lottie.getLoop())) {
            loop.get().switchTo(lottie.getLoop());
        }
        if (Objects.nonNull(lottie.getSpeed())) {
            speed.get().setValue(lottie.getSpeed());
        }
    }

    public Lottie getProperties() {
        open();
        return Lottie.builder()
                .autoplay(autoplay.get().getState())
                .loop(loop.get().getState())
                .lottieFile(Try.of(() -> await().atMost(200, MILLISECONDS).until(() -> lottieFile.get().getFileName(), value -> !value.isEmpty())).getOrElse(StringUtils.EMPTY))
                .lottieLink(lottieLink.get().getRawValue())
                .renderer(renderer.get().getSelectedItem())
                .reverse(reverse.get().getState())
                .speed(speed.get().getValue())
                .build();
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.autoplay).element(autoplay).build(),
                Configuration.builder().name(Fields.loop).element(loop).build(),
                Configuration.builder().name("lottie file").element(lottieFile).build(),
                Configuration.builder().name("lottie link").element(lottieLink).build(),
                Configuration.builder().name(Fields.renderer).element(renderer).build(),
                Configuration.builder().name(Fields.reverse).element(reverse).build(),
                Configuration.builder().name(Fields.speed).element(speed).build()
        );
    }

}
