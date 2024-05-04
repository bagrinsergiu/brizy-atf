package com.brizy.io.web.interactions.locators.editor.cms.assets.pages;

import com.brizy.io.web.interactions.locators.editor.cms.assets.common.content.AbstractAssetContentLocators;
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
public class NewPageContentLocators extends AbstractAssetContentLocators {

    @NestedConfigurationProperty
    MainPageContentLocators main;

}
