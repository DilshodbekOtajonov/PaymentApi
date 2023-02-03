package com.example.paymentapi.service.user;

import com.example.paymentapi.dto.auth.AuthLoginDTO;
import com.example.paymentapi.dto.auth.AuthUserDTO;
import com.example.paymentapi.dto.auth.AuthRegisterDTO;
import com.example.paymentapi.dto.token.JwtTokenResponse;
import org.springframework.stereotype.Service;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/3/23 8:59 PM (Friday)
 * PaymentApi/IntelliJ IDEA
 */

@Service
public class UserServiceImpl implements UserService {
    @Override
    public AuthUserDTO register(AuthRegisterDTO dto) {
        return null;
    }

    @Override
    public JwtTokenResponse login(AuthLoginDTO dto) {
        return null;
    }
}
