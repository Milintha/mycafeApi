package com.mycafe.mycafe_api.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
public class SecurityConstants {
    public static final Long EXPIRATION_TIME = 864000000L ;
    public static final Long PASSWORD_RESET_EXPIRATION_TIME = 3600000L ;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL_CUSTOMER = "/api/auth/signup/customer";
    public static final String SIGN_UP_URL_OWNER = "/api/auth/signup/owner";
    public static final String VERIFICATION_EMAIL_URL = "/verify-email";
    public static final String PASSWORD_RESET_REQUEST_URL = "/api/auth/password-reset-request";
    public static final String PASSWORD_RESET_URL = "/api/auth/password-reset";


    //@Value("${tokenSecret}")
     private static String tokenSecret = "ab123";

    /*public static String getTokenSecret(){
        AppProperties appProperties = (AppPropeties) SpringApplicationContext.getBean("AppProperties");
        appProperties.getTokenSecret();
    }*/

    public static String getTokenSecret() {
        return tokenSecret;
    }

    public static void setTokenSecret(String tokenSecret) {
        SecurityConstants.tokenSecret = tokenSecret;
    }
}
