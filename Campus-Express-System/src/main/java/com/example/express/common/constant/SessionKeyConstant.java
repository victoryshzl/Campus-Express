package com.example.express.common.constant;

/**
 * Session key 相关常量
 */
public class SessionKeyConstant {
    /**
     * 发送短信验证码的手机号
     */
    public static String SMS_TEL = "SMS_TEL";
    /**
     * 短信验证码
     */
    public static String SMS_CODE = "SMS_CODE";
    /**
     * 发送短信验证码的时间
     */
    public static String SMS_TIMESTAMP = "SMS_TIMESTAMP";
    /**
     * 最新订单数据
     */
    public static String SESSION_LATEST_EXPRESS = "SESSION_LATEST_EXPRESS";
    /**
     * 最新支付数据
     */
    public static String SESSION_LATEST_PAYMENT = "SESSION_LATEST_PAYMENT";
    /**
     * 人脸注册校验通过后暂存的face_token
     */
    public static String REGISTER_FACE_TOKEN = "REGISTER_FACE_TOKEN";
}
