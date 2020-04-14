package com.example.express.domain.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 快递公司数据
 */
@Data
@Builder
public class DataCompany implements Serializable {
    @TableId(type = IdType.INPUT)
    private Integer id;

    private String name;

    private String code;
}
