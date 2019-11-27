package com.example.demo.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection){
        String username=(String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        Set<String> stringSet=new HashSet<>();
        stringSet.add("user:show");
        stringSet.add("user:admin");
        info.setStringPermissions(stringSet);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException{
        System.out.println("-----身份认证-----");
        String userName=(String) authenticationToken.getPrincipal();
        String userPwd=new String((char[]) authenticationToken.getCredentials());
        String password="2415b95d3203ac901e287b76fcef640b";
        if (userName==null){
            throw new AccountException("用户名不正确");
        }else if (!userPwd.equals(userPwd)){
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(userName,password,ByteSource.Util.bytes(userName+"salt"),getName());
    }
//    public static String MD5Pwd(String username,String pwd){
//        String md5Pwd=new SimpleHash("MD5",pwd, ByteSource.Util.bytes(username+"salt"),2).toHex();
//        return md5Pwd;
//    }
}
