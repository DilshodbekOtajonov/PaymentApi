package com.example.paymentapi.utils.jwt;

import com.example.paymentapi.service.token.AccessTokenService;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 11:10 AM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */


public class JwtUtils {

    private JwtUtils() {
        throw new RuntimeException("Utility class can't instantiate object of itself");
    }

    public static AccessTokenService accessTokenService;

    public static void setAccessTokenService(AccessTokenService accessTokenService) {
        JwtUtils.accessTokenService = accessTokenService;
    }


}
