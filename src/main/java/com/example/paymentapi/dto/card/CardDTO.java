package com.example.paymentapi.dto.card;

import lombok.Builder;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/5/23 10:53 PM (Sunday)
 * PaymentApi/IntelliJ IDEA
 */
@Builder
public record CardDTO(Long id,
                      String userId,
                      String type,
                      String currency,
                      Long balance,
                      String cardNumber,
                      String name) {
}
