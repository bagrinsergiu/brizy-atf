package com.brizy.io.web.interactions.locators.editor.cms.assets.posts;

import com.brizy.io.web.interactions.locators.editor.cms.assets.common.AbstractAssetsLocators;
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
public class AssetsPostsSectionLocators extends AbstractAssetsLocators {

    String opener;
    @NestedConfigurationProperty
    MainPostsLocators main;
    @NestedConfigurationProperty
    NewPostContentLocators content;

}
