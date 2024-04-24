package com.brizy.io.web.interactions.locators.editor.sidebar.cms.assets;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.editor.sidebar.cms.assets.pages.AssetsPagesSectionLocators;
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
public class CmsAssetsMenuLocators extends AbstractLocator {

    String pages;
    String posts;
    @NestedConfigurationProperty
    AssetsPagesSectionLocators pagesSection;

}
