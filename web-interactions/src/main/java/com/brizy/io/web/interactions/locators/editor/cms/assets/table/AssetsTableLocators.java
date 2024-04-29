package com.brizy.io.web.interactions.locators.editor.cms.assets.table;

import com.brizy.io.web.interactions.locators.common.AbstractTableColumnLocators;
import com.brizy.io.web.interactions.locators.common.AbstractTableLocators;
import com.brizy.io.web.interactions.locators.common.AbstractTableRowLocators;
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
public class AssetsTableLocators extends AbstractTableLocators {

    @NestedConfigurationProperty
    AbstractTableColumnLocators columns;
    @NestedConfigurationProperty
    AbstractTableRowLocators rows;
    @NestedConfigurationProperty
    AssetsTableCellWithActionsLocators cell;

}
