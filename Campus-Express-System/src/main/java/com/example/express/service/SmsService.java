package com.example.express.service;

import com.example.express.domain.enums.ResponseErrorCodeEnum;

import javax.servlet.http.HttpSession;

/**
 * 短信服务
 */
public interface SmsService {
    /**
     * 发送短信
     * @param tel 手机号码
     * @param code 验证码
     */
    ResponseErrorCodeEnum send(HttpSession session, String tel, String code);

    /**
     * 校验短信
     */
    ResponseErrorCodeEnum check(HttpSession session, String tel, String code);
}
