package com.example.paymentapi.repository;

import com.example.paymentapi.domains.CardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/7/23 10:19 PM (Tuesday)
 * PaymentApi/IntelliJ IDEA
 */

@Repository
public interface CardTypeRepository extends JpaRepository<CardType, Long> {
}
