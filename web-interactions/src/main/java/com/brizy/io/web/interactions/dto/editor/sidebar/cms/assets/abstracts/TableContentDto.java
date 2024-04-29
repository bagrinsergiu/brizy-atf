package com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.abstracts;

import java.util.List;

/**
 * Need this interface only to limit the inputs type of the getData method inside Table interface
 */
public interface TableContentDto {

    List<List<String>> getContent();

}
