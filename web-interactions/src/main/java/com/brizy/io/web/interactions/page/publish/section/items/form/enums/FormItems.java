package com.brizy.io.web.interactions.page.publish.section.items.form.enums;

import com.brizy.io.web.interactions.page.publish.section.items.form.item.Number;
import com.brizy.io.web.interactions.page.publish.section.items.form.item.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public enum FormItems {

    SELECT(Select.class),
    RADIO(Radio.class),
    CHECKBOX(CheckBox.class),
    TEXT(Text.class),
    EMAIL(Email.class),
    NUMBER(Number.class),
    DATE(Date.class);
//    URL(com.brizy.io.web.interactions.page.publish.section.items.form.item.Url.class),
//    TIME(com.brizy.io.web.interactions.page.publish.section.items.form.item.Time.class),
//    FILE_UPLOAD(com.brizy.io.web.interactions.page.publish.section.items.form.item.FileUpload.class),
//    TEL(com.brizy.io.web.interactions.page.publish.section.items.form.item.Phone.class),
//    PASSWORD(com.brizy.io.web.interactions.page.publish.section.items.form.item.Password.class),
//    PARAGRAPH(com.brizy.io.web.interactions.page.publish.section.items.form.item.Paragraph.class);


    Class<?> clazz;

}
