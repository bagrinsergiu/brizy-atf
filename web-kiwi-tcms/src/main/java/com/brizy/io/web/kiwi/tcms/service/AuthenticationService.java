package com.brizy.io.web.kiwi.tcms.service;

import com.brizy.io.web.kiwi.tcms.client.interceptor.CookiesValues;
import com.brizy.io.web.kiwi.tcms.dto.request.LoginDto;
import com.brizy.io.web.kiwi.tcms.dto.request.LoginRequestDto;
import com.brizy.io.web.kiwi.tcms.properties.base.KiwiTcmsBaseProperties;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class AuthenticationService {

    KiwiTcmsBaseProperties baseProperties;
    RestTemplate restTemplate;

    public void login() {
        LoginDto loginDetails = LoginDto.builder()
                .username(baseProperties.getCredentials().getUsername())
                .password(baseProperties.getCredentials().getPassword())
                .build();
        LoginRequestDto body = LoginRequestDto.builder()
                .method("Auth.login")
                .params(loginDetails)
                .build();
        ResponseEntity<String> response = restTemplate.postForEntity(((RootUriTemplateHandler) restTemplate.getUriTemplateHandler()).getRootUri(), body, String.class);
        List<String> strings = response.getHeaders().get(HttpHeaders.SET_COOKIE);
        if (Objects.nonNull(strings) && !strings.isEmpty()) {
            CookiesValues.genericCookies.addAll(strings);
        }
    }

}
