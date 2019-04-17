package com.pigteam.airconditioning.config.shiro.config;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken inputUserInfo = (UsernamePasswordToken) token;
        String inLoginName = new String(inputUserInfo.getUsername());
        String inPassword = new String(inputUserInfo.getPassword());
        String dbPassword = (String) info.getCredentials();
        String convertPassword = null;
        //PasswordUtil.convertToDbPassword(inPassword, inLoginName);
        return this.equals(convertPassword, dbPassword);
    }

}