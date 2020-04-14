package com.example.express.domain.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 派送员绩效统计
 */
@Data
@Builder
public class VUserPayment {
    /**
     * 用户证件
     */
    private String idCard;
    private String realName;
    private BigDecimal payment;
}
