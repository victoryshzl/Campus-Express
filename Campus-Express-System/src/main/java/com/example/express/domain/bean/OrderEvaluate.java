package com.example.express.domain.bean;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单评价表
 */
@Data
public class OrderEvaluate {
    /**
     * 订单ID
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 评论是否开启（1：开启；0：关闭）
     */
    private Boolean hasOpen;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户评分
     */
    private BigDecimal userScore;
    /**
     * 用户评价
     */
    private String userEvaluate;
    /**
     * 用户评价时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime userDate;
    /**
     * 用户ID
     */
    private String courierId;
    /**
     * 用户评分
     */
    private BigDecimal courierScore;
    /**a1
     * 用户评价
     */
    private String courierEvaluate;
    /**
     * 用户评价时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime courierDate;

    @Version
    @TableField(fill = FieldFill.UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateDate;
}
