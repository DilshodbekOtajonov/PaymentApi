package com.example.paymentapi.dto.transaction;

import lombok.Builder;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/8/23 3:13 PM (Wednesday)
 * PaymentApi/IntelliJ IDEA
 */
@Builder
public record TransactionDTO(String id,
                             Long senderId,
                             Long receiverId,
                             Long sendingAmount,
                             Long receivingAmount,
                             String status) {
}
