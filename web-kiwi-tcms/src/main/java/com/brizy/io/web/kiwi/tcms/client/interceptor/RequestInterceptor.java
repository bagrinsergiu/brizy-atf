package com.brizy.io.web.kiwi.tcms.client.interceptor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public class RequestInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        if (Objects.nonNull(CookiesValues.genericCookies)) {
            request.getHeaders().addAll(HttpHeaders.SET_COOKIE, CookiesValues.genericCookies);
        }
        return execution.execute(request, body);
    }

}
