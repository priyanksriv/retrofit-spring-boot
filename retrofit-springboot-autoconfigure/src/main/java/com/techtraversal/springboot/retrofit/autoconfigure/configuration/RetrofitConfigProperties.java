package com.techtraversal.springboot.retrofit.autoconfigure.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("retrofit.http")
public class RetrofitConfigProperties {

    private String baseURL;

    public String baseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }
}
