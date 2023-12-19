package com.brizy.io.web.interactions.page.editor.container.components.content.variations.playlist;

import com.brizy.io.web.common.dto.element.content.playlist.PlaylistContentProperties;
import com.brizy.io.web.common.dto.element.type.Content;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.content.variations.playlist.item.PlayListVideoItem;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PlaylistContent {

    Supplier<List<PlayListVideoItem>> item;

    public PlaylistContent(ItemLocators contentLocators, Frame frame, Locator locator) {
        this.item = () -> getItemsFromPage(contentLocators, locator, frame);
    }

    private List<PlayListVideoItem> getItemsFromPage(ItemLocators contentLocators, Locator locator, Frame frame) {
        return locator.locator(contentLocators.getContent().getPlaylist().getSidebar().getItems()).all().stream()
                .map(foundLocator -> new PlayListVideoItem(contentLocators, frame, foundLocator))
                .toList();
    }

    private void deleteAndLeaveOnlyOneItem() {
        item.get().stream()
                .skip(1)
                .forEach(PlayListVideoItem::delete);
    }

    private PlayListVideoItem getLatestItem() {
        int size = item.get().size();
        return item.get().get(size - 1);
    }

    public <Type extends Content> void setContent(List<Type> content) {
        deleteAndLeaveOnlyOneItem();
        for (Type item : content) {
            PlayListVideoItem latestItem = getLatestItem();
            latestItem.configure((PlaylistContentProperties) item);
            if (content.indexOf(item) != content.size() - 1) {
                latestItem.duplicate();
            }
        }
    }
}
