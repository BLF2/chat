package com.blf2.chat.dto;

/**
 * 星火大模型返回信息
 */
public class SparkRes {

    //web socket链接地址
    private String wssUrl;

    //星火大模型 appId
    private String appId;

    public String getWssUrl() {
        return wssUrl;
    }

    public void setWssUrl(String wssUrl) {
        this.wssUrl = wssUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
