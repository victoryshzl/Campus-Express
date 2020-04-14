package com.example.express.domain.vo.user;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息VO
 */
@Data
@Builder
public class UserInfoVO implements Serializable {
    private String username;

    private String sex;

    private String tel;
    /**
     * 学校名
     */
    private String school;

    private String studentIdCard;

    private String role;

    private String roleName;

    private String star;

    private String idCard;

    private String realName;
    /**
     * 能否切换角色（普通用户 --> 配送员）
     * 1：可以；0：不可以
     */
    private String canChangeRole;
    /**
     * 能否人脸登录
     * 1：可以；0：不可以
     */
    private String canFace;
}
