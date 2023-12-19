package com.brizy.io.web.test.data_table;

import io.cucumber.java.DataTableType;
import org.apache.commons.lang3.StringUtils;

public class SpecialDataHandler {

    @DataTableType
    public String processBlankStrings(String cell) {
        if (cell.equalsIgnoreCase("[blank]")) {
            return StringUtils.EMPTY;
        }
        return cell;
    }

}