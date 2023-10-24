package com.brizy.io.web.test.parameter_type;

import com.brizy.io.web.interactions.page.publish.section.items.form.enums.FormItems;
import io.cucumber.java.ParameterType;

public class FormItemParameterType {

    @ParameterType(name = "formItem", value = "SELECT|Select|select|RADIO|Radio|radio|CHECKBOX|Checkbox|checkbox|TEXT|Text|text|EMAIL|Email|email|NUMBER|Number|number|DATE|Date|date|URL|Url|url|TIME|Time|time|FILE UPLOAD|File Upload|fileUpload|TEL|Phone|phone|PASSWORD|Password|password|PARAGRAPH|Paragraph|paragraph")
    public Class<?> formItem(String rawValue) {
        return FormItems.valueOf(rawValue.toUpperCase()).getClazz();
    }

}
