package com.example.paymentapi.controller;

import com.example.paymentapi.dto.auth.AuthDeleteDTO;
import com.example.paymentapi.dto.auth.AuthLoginDTO;
import com.example.paymentapi.dto.auth.AuthUserDTO;
import com.example.paymentapi.dto.auth.AuthRegisterDTO;
import com.example.paymentapi.dto.token.JwtTokenResponse;
import com.example.paymentapi.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<JwtTokenResponse> login(@RequestBody AuthLoginDTO dto) {
        JwtTokenResponse response = userService.login(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<AuthUserDTO> register(@RequestBody AuthRegisterDTO dto) {
        AuthUserDTO authUserDTO = userService.register(dto);
        return new ResponseEntity(authUserDTO, HttpStatus.CREATED);
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestBody AuthDeleteDTO dto) {
        userService.delete(dto);
        return ResponseEntity.ok("success");
    }

}
