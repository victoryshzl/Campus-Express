package com.example.express.service;

public interface OAuthService {

    /**
     * 生成并保存state入缓存
     */
    String genState();

    /**
     * 校验state
     */
    boolean checkState(String state);
}
