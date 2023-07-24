package com.brizy.io.web.kiwi.tcms.service;


import com.brizy.io.web.kiwi.tcms.dto.response.AbstractResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public abstract class AbstractService {

    RestTemplate restTemplate;

    protected <T extends AbstractResponseDto> T postAndGetEntity(Object body, Class<T> clazz) {
        return Optional.of(restTemplate.postForEntity(((RootUriTemplateHandler) restTemplate.getUriTemplateHandler()).getRootUri(), body, clazz).getBody())
                .orElse((T) new AbstractResponseDto());
    }

    protected String postAndGetRaw(Object body) {
        return Optional.of(restTemplate.postForEntity(((RootUriTemplateHandler) restTemplate.getUriTemplateHandler()).getRootUri(), body, String.class).getBody())
                .orElse(StringUtils.EMPTY);
    }

}
