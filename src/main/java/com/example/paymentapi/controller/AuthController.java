package com.example.paymentapi.controller;

import com.example.paymentapi.dto.auth.AuthLoginDTO;
import com.example.paymentapi.dto.auth.AuthUserDTO;
import com.example.paymentapi.dto.auth.AuthRegisterDTO;
import com.example.paymentapi.dto.token.JwtTokenResponse;
import com.example.paymentapi.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/3/23 3:37 PM (Friday)
 * PaymentApi/IntelliJ IDEA
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody AuthLoginDTO dto) {
        JwtTokenResponse response = userService.login(dto);
        return null;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<AuthUserDTO> register(@RequestBody AuthRegisterDTO dto) {
        AuthUserDTO authUserDTO = userService.register(dto);
        return new ResponseEntity(authUserDTO, HttpStatus.CREATED);
    }
}
