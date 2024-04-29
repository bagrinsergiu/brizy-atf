package com.brizy.io.web.interactions.page.editor.container.cms.assets.posts.content;

import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.abstracts.NewContentDto;
import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.posts.NewPostContentDto;
import com.brizy.io.web.interactions.element.FileUploader;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.element.composite.PopUpDropdown;
import com.brizy.io.web.interactions.locators.editor.cms.assets.posts.NewPostContentLocators;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.common.content.AbstractContent;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NewPostContent extends AbstractContent {

    TextInput title;
    TextInput slug;
    TextInput excerpt;
    FileUploader fileUploader;
    PopUpDropdown published;

    public NewPostContent(NewPostContentLocators content, Frame frame) {
        super(content, frame);
        var main = content.getMain();
        this.title = new TextInput(frame.locator(main.getTitle()));
        this.slug = new TextInput(frame.locator(main.getSlug()));
        this.excerpt = new TextInput(frame.locator(main.getExcerpt()));
        this.fileUploader = new FileUploader(main.getFeaturedImage(), frame);
        this.published = new PopUpDropdown(main.getPublished(), frame);
    }

    void fill(NewPostContentDto newPostContentDto) {
        if (Objects.nonNull(newPostContentDto.getTitle())) {
            title.fill(newPostContentDto.getTitle());
        }
        if (Objects.nonNull(newPostContentDto.getSlug())) {
            slug.fill(newPostContentDto.getSlug());
        }
        if (Objects.nonNull(newPostContentDto.getExcerpt())) {
            excerpt.fill(newPostContentDto.getExcerpt().getText());
        }
//        if (Objects.nonNull(newPostContentDto.getFeaturedImage())) {
//            fileUploader.uploadFile(newPostContentDto.getFeaturedImage());
//        }
        if (Objects.nonNull(newPostContentDto.getPublished())) {
            published.selectItem(newPostContentDto.getPublished().getName());
        }
    }

    @Override
    public <T extends NewContentDto> void fill(T content) {
        fill(((NewPostContentDto) content));
    }

}