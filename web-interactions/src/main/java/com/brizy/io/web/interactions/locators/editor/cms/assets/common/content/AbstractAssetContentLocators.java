package com.brizy.io.web.interactions.locators.editor.cms.assets.common.content;

import com.brizy.io.web.interactions.locators.AbstractLocator;
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
public abstract class AbstractAssetContentLocators extends AbstractLocator {

    @NestedConfigurationProperty
    AssetsContentFooterLocators footer;
    @NestedConfigurationProperty
    AssetsContentHeaderLocators header;

}
