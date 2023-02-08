package com.example.paymentapi.repository;

import com.example.paymentapi.domains.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/3/23 8:57 PM (Friday)
 * PaymentApi/IntelliJ IDEA
 */
@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findByCardNumber(String cardNumber);

    List<Card> findAllByUser_Id(String userid);
}
