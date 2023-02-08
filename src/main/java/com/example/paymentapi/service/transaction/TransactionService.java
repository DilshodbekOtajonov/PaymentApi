package com.example.paymentapi.service.transaction;

import com.example.paymentapi.dto.transaction.TransactionCreateDTO;
import com.example.paymentapi.dto.transaction.TransactionDTO;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/3/23 8:59 PM (Friday)
 * PaymentApi/IntelliJ IDEA
 */

public interface TransactionService {
    String create(TransactionCreateDTO dto) throws IllegalAccessException;

    TransactionDTO confirm(String id) throws IllegalAccessException;
}
