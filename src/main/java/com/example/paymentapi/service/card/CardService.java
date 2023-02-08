package com.example.paymentapi.service.card;

import com.example.paymentapi.dto.card.CardCreateDTO;
import com.example.paymentapi.dto.card.CardDTO;

import java.util.List;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/3/23 8:59 PM (Friday)
 * PaymentApi/IntelliJ IDEA
 */
public interface CardService {
    CardDTO addCard(CardCreateDTO dto);

    CardDTO getCardInfo(String cardNumber);

    List<CardDTO> getUserCards(String userId);
}
