package com.brizy.io.web.interactions.locators.editor.cms;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.editor.cms.assets.CmsAssetsMenuLocators;
import com.brizy.io.web.interactions.locators.editor.cms.assets.posts.AssetsPostsSectionLocators;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class EditorCmsPopUpLocators extends AbstractLocator {

    String assets;
    String menu;
    @NestedConfigurationProperty
    CmsAssetsMenuLocators assetsMenu;
    @NestedConfigurationProperty
    AssetsPostsSectionLocators postsSection;

}
