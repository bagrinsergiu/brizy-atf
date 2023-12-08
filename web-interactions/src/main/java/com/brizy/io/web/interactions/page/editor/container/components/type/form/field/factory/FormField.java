package com.brizy.io.web.interactions.page.editor.container.components.type.form.field.factory;

public interface FormField<T> {

    void setToolbarProperties(T properties);

    default void configureFormField(T properties) {
    }

    void duplicate();

    void delete();

}
