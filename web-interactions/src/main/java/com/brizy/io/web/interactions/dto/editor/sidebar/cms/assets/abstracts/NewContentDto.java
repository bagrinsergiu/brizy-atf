package com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.abstracts;

import com.brizy.io.web.interactions.enums.PublishedItems;

/**
 * Need this interface only to limit the inputs type of the fill method inside Content interface
 */
public interface NewContentDto {

    String getTitle();

    PublishedItems getPublished();

}
