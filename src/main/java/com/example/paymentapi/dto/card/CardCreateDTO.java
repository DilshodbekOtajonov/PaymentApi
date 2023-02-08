package com.example.paymentapi.dto.card;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/5/23 10:52 PM (Sunday)
 * PaymentApi/IntelliJ IDEA
 */
public record CardCreateDTO(Long balance,
                            String name,
                            String cardNumber,
                            Long cardTypeId,
                            String userId
) {
}
