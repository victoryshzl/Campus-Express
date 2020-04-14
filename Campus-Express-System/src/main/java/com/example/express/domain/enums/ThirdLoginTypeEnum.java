package com.example.express.domain.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Getter;

import java.util.Arrays;

/**
 * 三方登录类型枚举
 */
@Getter
public enum ThirdLoginTypeEnum implements IEnum<Integer> {
    NONE(0, "未绑定"),
    QQ(1, "QQ登陆");

    private int type;

    private String name;

    ThirdLoginTypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public Integer getValue() {
        return this.type;
    }

    public static ThirdLoginTypeEnum getByType(Integer type) {
        return Arrays.stream(values()).filter(e -> e.getType() == type).findFirst().orElse(null);
    }
}
