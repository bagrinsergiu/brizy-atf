package com.brizy.io.web.interactions.locators;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public abstract class AbstractLocator {
    /**
     * Locator that will help to detect the item on page
     */
    String self;

}
