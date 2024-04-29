package com.blf2.chat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 大模型配置信息
 */
@Configuration
public class BigModelConfig {

    @Value("${xunfei.bm.appId}")
    private String appId;

    @Value("${xunfei.bm.apiSecret}")
    private String apiSecret;

    @Value("${xunfei.bm.apiKey}")
    private String apiKey;

    @Value("${xunfei.bm.wssUrl:https://spark-api.xf-yun.com/v3.5/chat}")
    private String wssUrl;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getWssUrl() {
        return wssUrl;
    }

    public void setWssUrl(String wssUrl) {
        this.wssUrl = wssUrl;
    }
}
