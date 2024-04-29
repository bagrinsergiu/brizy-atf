package com.brizy.io.web.interactions.page.editor.container.cms.assets.posts;

import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.abstracts.TableContentDto;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.locators.editor.cms.assets.posts.AssetsPostsSectionLocators;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.abstracts.MenuItem;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.common.AbstractAsset;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.common.content.Content;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.enums.AssetsMenuItems;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.posts.content.NewPostContent;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.posts.table.PostsTable;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AssetsPosts extends AbstractAsset implements MenuItem {

    Button opener;
    PostsTable table;
    Supplier<NewPostContent> newPost;

    public AssetsPosts(AssetsPostsSectionLocators postsSectionLocators, Frame frame) {
        super(postsSectionLocators, frame);
        this.opener = new Button(frame.locator(postsSectionLocators.getOpener()));
        this.table = new PostsTable(postsSectionLocators.getMain().getTable(), frame);
        this.newPost = () -> new NewPostContent(postsSectionLocators.getContent(), frame);
    }

    @Override
    public TableContentDto getTableData() {
        return table.getData();
    }

    @Override
    public void open() {
        opener.click();
    }

    @Override
    public AssetsMenuItems getName() {
        return AssetsMenuItems.POSTS;
    }

    @Override
    public Content addNew() {
        super.onFooter().addNew();
        return newPost.get();
    }

}
