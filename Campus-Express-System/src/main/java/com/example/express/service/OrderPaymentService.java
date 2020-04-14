package com.example.express.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.express.domain.ResponseResult;
import com.example.express.domain.bean.OrderPayment;
import com.example.express.domain.enums.PaymentStatusEnum;

import java.util.Map;

public interface OrderPaymentService extends IService<OrderPayment> {
    /**
     * 创建支付宝订单
     */
    boolean createAliPayment(String orderId, double money, String sellerId);

    boolean validAlipay(Map<String, String> params) throws Exception;

    /**
     * 改变订单状态
     * @param tradeNo 第三方交易号【仅在TRADE_SUCCESS时有效】
     */
    boolean updateStatus(String orderId, PaymentStatusEnum status, String... tradeNo);

    /**
     * 请求支付宝服务器,同步支付状态
     */
    ResponseResult syncPaymentInfo(String orderId);
}
