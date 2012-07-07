package com.yourpackagename.yourwebproject.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;

/**
 * Key constants to be used in the code
 *
 * @author: Y Kamesh Rao
 * @created: 3/23/12 9:00 AM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
@ImportResource("classpath:config/spring/applicationContext-properties.xml")
public class Key {
    public static final String redirect = "redirect:";
    public static final String response = "response";
    public static final String user = "user";
    public static final String role = "role";
    public static final String address = "address";
    public static final String isLogin = "ls";
    public static final String isRegister = "rs";
    public static final String isEmailConfirmed = "ecs";

    public static final String regUserForm = "registerUserForm";
    public static final String loginUserForm = "loginUserForm";
    public static final String token = "token";

    public static final String userInSession = "com.yourpackagename.user";
    public static final String formEncoded = "application/x-www-form-urlencoded";

    public @Value("#{amProps['unf.msg']}") String unfMsg;

    public @Value("#{amProps['ise.code']}") int iseCode;
    public @Value("#{amProps['vdn.code']}") int vdnCode;
    public @Value("#{amProps['unf.code']}") int unfCode;
}
