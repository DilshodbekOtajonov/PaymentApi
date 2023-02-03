package com.example.paymentapi.controller;

import com.example.paymentapi.service.card.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/3/23 3:37 PM (Friday)
 * PaymentApi/IntelliJ IDEA
 */
@RestController
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
}
