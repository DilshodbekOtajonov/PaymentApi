package com.example.paymentapi.service.user;

import com.example.paymentapi.domains.User;
import com.example.paymentapi.dto.auth.AuthDeleteDTO;
import com.example.paymentapi.dto.auth.AuthLoginDTO;
import com.example.paymentapi.dto.auth.AuthUserDTO;
import com.example.paymentapi.dto.auth.AuthRegisterDTO;
import com.example.paymentapi.dto.token.JwtTokenResponse;
import com.example.paymentapi.enums.UserStatus;
import com.example.paymentapi.repository.UserRepository;
import com.example.paymentapi.utils.jwt.JwtUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/3/23 8:59 PM (Friday)
 * PaymentApi/IntelliJ IDEA
 */

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           @Lazy AuthenticationManager authenticationManager,
                           @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthUserDTO register(AuthRegisterDTO dto) {
        User user = User.builder()
                .phone(dto.phone())
                .password(passwordEncoder.encode(dto.password()))
                .status(UserStatus.ACTIVE)
                .build();
        User savedUser = userRepository.save(user);
        AuthUserDTO response = new AuthUserDTO(savedUser.getId(),
                savedUser.getPhone(),
                savedUser.getStatus().name()
        );
        return response;
    }

    @Override
    public JwtTokenResponse login(AuthLoginDTO dto) {
        Authentication authenticate = authenticateUser(dto.phone(), dto.password());
        com.example.paymentapi.configs.security.UserDetails userDetails = (com.example.paymentapi.configs.security.UserDetails) authenticate.getPrincipal();
        String accessToken = JwtUtils.accessTokenService.generateToken(userDetails);
        return new JwtTokenResponse(accessToken, "Bearer");
    }

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        User user = userRepository.findUserByPhone(phone)
                .orElseThrow(() -> new RuntimeException("user not found by phone " + phone));
        return new com.example.paymentapi.configs.security.UserDetails(user);
    }

    @Override
    public void delete(AuthDeleteDTO dto) {
        Authentication authenticate = authenticateUser(dto.phone(), dto.password());
        com.example.paymentapi.configs.security.UserDetails userDetails = (com.example.paymentapi.configs.security.UserDetails) authenticate.getPrincipal();
        User currentUser = userDetails.authUser();
        currentUser.setStatus(UserStatus.DELETED);
        userRepository.save(currentUser);
    }

    private Authentication authenticateUser(String phone, String password) {
        Authentication authenticate;
        try {
            authenticate = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(phone,
                            password));
        } catch (AuthenticationException e) {
            throw new RuntimeException("invalid credentials");
        }
        return authenticate;
    }
}
