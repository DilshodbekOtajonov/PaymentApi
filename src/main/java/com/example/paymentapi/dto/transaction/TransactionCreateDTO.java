package com.example.paymentapi.dto.transaction;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/8/23 3:13 PM (Wednesday)
 * PaymentApi/IntelliJ IDEA
 */

public record TransactionCreateDTO(Long senderId,
                                   Long receiverId,
                                   Long amount) {

}
