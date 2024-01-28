package com.brizy.io.web.interactions.page.editor.container.components.content.variations.gallery;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GalleryContent {

//    Supplier<List<PlayListVideoItem>> item;

    public GalleryContent(ItemLocators contentLocators, Frame frame, Locator locator) {
//        this.item = () -> getItemsFromPage(contentLocators, locator, frame);
    }

//    private List<PlayListVideoItem> getItemsFromPage(ItemLocators contentLocators, Locator locator, Frame frame) {
//        return locator.locator(contentLocators.getContent().getPlaylist().getSidebar().getItems()).all().stream()
//                .map(foundLocator -> new PlayListVideoItem(contentLocators, frame, foundLocator))
//                .toList();
//    }
//
//    private void deleteAndLeaveOnlyOneItem() {
//        item.get().stream()
//                .skip(1)
//                .forEach(PlayListVideoItem::delete);
//    }
//
//    private PlayListVideoItem getLatestItem() {
//        int size = item.get().size();
//        return item.get().get(size - 1);
//    }
//
//    public <Type extends Content> void setContent(List<Type> content) {
//        deleteAndLeaveOnlyOneItem();
//        for (Type item : content) {
//            PlayListVideoItem latestItem = getLatestItem();
//            latestItem.configure((PlaylistContentProperties) item);
//            if (content.indexOf(item) != content.size() - 1) {
//                latestItem.duplicate();
//            }
//        }
//    }
}
