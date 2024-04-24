package com.brizy.io.web.interactions.locators.editor.sidebar.cms.assets.common;

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
public class AbstractAssetsLocators extends AbstractLocator {

    @NestedConfigurationProperty
    AssetsHeaderLocators header;
    @NestedConfigurationProperty
    AssetsFooterLocators footer;

}
