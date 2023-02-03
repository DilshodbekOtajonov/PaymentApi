package com.example.paymentapi.repository;

import com.example.paymentapi.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/3/23 8:55 PM (Friday)
 * PaymentApi/IntelliJ IDEA
 */


@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
