package com.example.paymentapi.repository;

import com.example.paymentapi.domains.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/3/23 8:57 PM (Friday)
 * PaymentApi/IntelliJ IDEA
 */

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
