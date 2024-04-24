package com.brizy.io.web.interactions.locators.publish.section.container.item;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.publish.section.container.item.form.PublishedFormLocators;
import com.brizy.io.web.interactions.locators.publish.section.container.item.gallery.PublishedGalleryLocators;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@EqualsAndHashCode(callSuper = false)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class PublishedItemLocators extends AbstractLocator {

    @NestedConfigurationProperty
    PublishedFormLocators form;
    @NestedConfigurationProperty
    PublishedGalleryLocators gallery;

}