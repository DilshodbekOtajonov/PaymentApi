package com.example.paymentapi.service.token;

import com.example.paymentapi.configs.security.UserDetails;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 11:13 AM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */
@Service
public class AccessTokenService extends AbstractTokenService {

    @Value("${jwt.access.token.secret}")
    private String accessTokenSecret;
    @Value("${jwt.access.token.expiry.adding.amount}")
    private Integer amountToAdd;

    private TemporalUnit unit = ChronoUnit.MINUTES;


    @Override
    public String generateToken(UserDetails userDetails) {
        return jwt(userDetails.getUsername());
    }

    @Override
    public Boolean isValid(String token) {
        return super.isTokenValid(token, this.accessTokenSecret);
    }

    public String getSubject(String token) {
        return super.getSubject(token, accessTokenSecret);
    }


    public String jwt(@NonNull String subject) {
        return super.jwt(subject, this.accessTokenSecret, this.amountToAdd, this.unit);
    }
}
