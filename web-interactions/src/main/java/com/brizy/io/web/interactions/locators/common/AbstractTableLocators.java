package com.brizy.io.web.interactions.locators.common;

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
public class AbstractTableLocators extends AbstractLocator {

    @NestedConfigurationProperty
    AbstractTableColumnLocators columns;
    @NestedConfigurationProperty
    AbstractTableRowLocators rows;

    public AbstractTableCellLocators getCell() {
        return new AbstractTableCellLocators();
    }


}
