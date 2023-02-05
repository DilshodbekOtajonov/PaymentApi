package com.example.paymentapi.configs.other;

import com.example.paymentapi.service.token.AccessTokenService;
import com.example.paymentapi.utils.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author "Otajonov Dilshodbek
 * @since 11/6/22 6:50 PM (Sunday)
 * PDP_Message_Service/IntelliJ IDEA
 */
@Component
@RequiredArgsConstructor
public class StaticInitializer {

    private final AccessTokenService accessTokenService;


    @PostConstruct
    public void init() {
        JwtUtils.setAccessTokenService(accessTokenService);
    }

}
