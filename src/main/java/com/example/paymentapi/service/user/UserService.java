package com.example.paymentapi.service.user;

import com.example.paymentapi.domains.User;
import com.example.paymentapi.dto.auth.AuthDeleteDTO;
import com.example.paymentapi.dto.auth.AuthLoginDTO;
import com.example.paymentapi.dto.auth.AuthUserDTO;
import com.example.paymentapi.dto.auth.AuthRegisterDTO;
import com.example.paymentapi.dto.token.JwtTokenResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/3/23 8:58 PM (Friday)
 * PaymentApi/IntelliJ IDEA
 */
public interface UserService extends UserDetailsService {
    AuthUserDTO register(AuthRegisterDTO dto);

    JwtTokenResponse login(AuthLoginDTO dto);

    void delete(AuthDeleteDTO dto);

    User getUser(String id);

    void checkUser(String userId) throws IllegalAccessException;

}
