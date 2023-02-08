package com.example.paymentapi.repository;

import com.example.paymentapi.domains.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/8/23 6:20 PM (Wednesday)
 * PaymentApi/IntelliJ IDEA
 */
@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {

    @Query("select t from Rate t where t.fromCurrency=?1 and t.toCurrency=?2")
    Optional<Rate> findRate(String fromCurrency, String toCurrency);

}
