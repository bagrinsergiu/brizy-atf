package com.brizy.io.web.common.dto.element.type;

public interface ItemTypeWithContent extends ItemType {

    <T extends Content> T[] getContent();

}
