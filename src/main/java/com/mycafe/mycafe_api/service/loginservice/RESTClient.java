package com.mycafe.mycafe_api.service.loginservice;

import org.springframework.util.MultiValueMap;

public interface RESTClient {
    Object post(String resourceUrl, MultiValueMap<String, String> request, String username, String password);
}
