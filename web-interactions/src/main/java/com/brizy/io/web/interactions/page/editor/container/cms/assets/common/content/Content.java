package com.brizy.io.web.interactions.page.editor.container.cms.assets.common.content;

import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.abstracts.NewContentDto;

public interface Content {

    <T extends NewContentDto> void fill(T content);

}