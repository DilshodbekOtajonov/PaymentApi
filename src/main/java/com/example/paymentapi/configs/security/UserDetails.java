package com.example.paymentapi.configs.security;

import com.example.paymentapi.domains.User;
import com.example.paymentapi.enums.UserStatus;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 10:02 AM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */

@Builder
public record UserDetails(User authUser) implements org.springframework.security.core.userdetails.UserDetails {


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return authUser.getPassword();
    }

    @Override
    public String getUsername() {
        return authUser.getPhone();
    }

    @Override
    public boolean isAccountNonExpired() {
        return isEnabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        return isEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return authUser.getStatus().equals(UserStatus.ACTIVE);
    }


}
