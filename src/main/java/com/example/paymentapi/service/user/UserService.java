package com.example.paymentapi.service.user;

import com.example.paymentapi.dto.auth.AuthLoginDTO;
import com.example.paymentapi.dto.auth.AuthUserDTO;
import com.example.paymentapi.dto.auth.AuthRegisterDTO;
import com.example.paymentapi.dto.token.JwtTokenResponse;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/3/23 8:58 PM (Friday)
 * PaymentApi/IntelliJ IDEA
 */
public interface UserService {
    AuthUserDTO register(AuthRegisterDTO dto);

    JwtTokenResponse login(AuthLoginDTO dto);
}
