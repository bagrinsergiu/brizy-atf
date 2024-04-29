package com.brizy.io.web.interactions.page.editor.container.cms.assets.pages.content;

import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.abstracts.NewContentDto;
import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.pages.NewPageContentDto;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.locators.editor.cms.assets.pages.NewPageContentLocators;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.common.content.AbstractContent;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NewPageContent extends AbstractContent {

    TextInput title;
    TextInput slug;
    TextInput description;

    public NewPageContent(NewPageContentLocators content, Frame frame) {
        super(content, frame);
        var main = content.getMain();
        this.title = new TextInput(frame.locator(main.getTitle()));
        this.slug = new TextInput(frame.locator(main.getSlug()));
        this.description = new TextInput(frame.locator(main.getDescription()));
    }

    void fill(NewPageContentDto newPageContentDto) {
        if (Objects.nonNull(newPageContentDto.getPageTitle())) {
            title.fill(newPageContentDto.getPageTitle());
        }
        if (Objects.nonNull(newPageContentDto.getSlug())) {
            slug.fill(newPageContentDto.getSlug());
        }
        if (Objects.nonNull(newPageContentDto.getDescription())) {
            description.fill(newPageContentDto.getDescription().getText());
        }
    }

    @Override
    public <T extends NewContentDto> void fill(T content) {
        fill(((NewPageContentDto) content));
    }

}