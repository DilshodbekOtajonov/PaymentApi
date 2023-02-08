package com.example.paymentapi.controller;

import com.example.paymentapi.dto.card.CardCreateDTO;
import com.example.paymentapi.dto.card.CardDTO;
import com.example.paymentapi.service.card.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/3/23 3:37 PM (Friday)
 * PaymentApi/IntelliJ IDEA
 */
@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping("/add")
    public ResponseEntity<CardDTO> add(@RequestBody CardCreateDTO dto) {
        CardDTO response = cardService.addCard(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/myCards")
    public ResponseEntity<List<CardDTO>> getCards(@RequestParam String userId) {
        List<CardDTO> response = cardService.getUserCards(userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/cardInfo")
    public ResponseEntity<CardDTO> getCardInfo(@RequestParam String cardNumber) {
        CardDTO response = cardService.getCardInfo(cardNumber);
        return ResponseEntity.ok(response);
    }

}
