package com.example.express.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Getter
@Configuration
public class AliPayConfig {
    /*
     *支付宝网关
     */
    @Value("${project.alipay.gateway-url}")
    private String serverUrl;
    /*
     *APPID
     */
    @Value("${project.alipay.app-id}")
    private String appId;
    /*
     *商户私钥
     */
    @Value("${project.alipay.merchant-private-key}")
    private String privateKey;
    /*
     *支付宝公钥
     */
    @Value("${project.alipay.alipay-public-key}")
    private String alipayPublicKey;
    /*
     *签名方式
     */
    @Value("${project.alipay.sign-type}")
    private String signType;
    /*
     *商户UID
     */
    @Value("${project.alipay.uid}")
    private String sellerId;
    /*
     *服务器异步通知页面路径
     */
    @Value("${project.alipay.notify-url}")
    private String notifyUrl;
    /*
     *页面跳转同步通知页面路径
     */
    @Value("${project.alipay.return-url}")
    private String returnUrl;

    @Bean
    public AlipayClient alipayClient() {
        return new DefaultAlipayClient(serverUrl, appId, privateKey, "json", "utf-8", alipayPublicKey, signType);
    }
}
