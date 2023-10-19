package com.brizy.io.web.interactions.locators.publish.section.container.item.form;

import com.brizy.io.web.interactions.locators.AbstractProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class FormFieldLocators extends AbstractProperty {

    String text;
    String email;
    String number;
    String paragraph;
    String select;
    String radio;
    String checkBox;
    String date;
    String url;
    String time;
    String file;
    String tel;
    String password;

}
