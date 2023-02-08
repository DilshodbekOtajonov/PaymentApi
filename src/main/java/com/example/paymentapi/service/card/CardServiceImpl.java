package com.example.paymentapi.service.card;

import com.example.paymentapi.domains.Card;
import com.example.paymentapi.domains.CardType;
import com.example.paymentapi.domains.User;
import com.example.paymentapi.dto.card.CardCreateDTO;
import com.example.paymentapi.dto.card.CardDTO;
import com.example.paymentapi.repository.CardRepository;
import com.example.paymentapi.repository.CardTypeRepository;
import com.example.paymentapi.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/3/23 8:59 PM (Friday)
 * PaymentApi/IntelliJ IDEA
 */

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final CardTypeRepository cardTypeRepository;
    private final UserService userService;

    @Override
    public CardDTO addCard(CardCreateDTO dto) {
        CardType cardType = getCardType(dto.cardTypeId());
        User user = userService.getUser(dto.userId());
        Card card = new Card();
        card.setCardNumber(dto.cardNumber());
        card.setUser(user);
        card.setType(cardType);
        card.setName(dto.name());
        card.setBalance(dto.balance());
        Card savedCard = cardRepository.save(card);
        return CardDTO.builder()
                .id(savedCard.getId())
                .type(savedCard.getType().getName())
                .currency(savedCard.getType().getCurrency())
                .balance(savedCard.getBalance())
                .cardNumber(savedCard.getCardNumber())
                .userId(savedCard.getUser().getId())
                .name(savedCard.getName())
                .build();
    }

    @Override
    public CardDTO getCardInfo(String cardNumber) {
        Card card = cardRepository.findByCardNumber(cardNumber)
                .orElseThrow(() -> new RuntimeException("Card not found by number: " + cardNumber));
        return CardDTO.builder()
                .id(card.getId())
                .type(card.getType().getName())
                .currency(card.getType().getCurrency())
                .balance(card.getBalance())
                .cardNumber(card.getCardNumber())
                .userId(card.getUser().getId())
                .name(card.getName())
                .build();
    }

    @Override
    public List<CardDTO> getUserCards(String userId) {
        List<Card> cards = cardRepository.findAllByUser_Id(userId);
        if (cards.isEmpty())
            return Collections.emptyList();
        else {
            List<CardDTO> response = new ArrayList<>();
            for (Card card : cards) {
                CardDTO cardDTO = CardDTO.builder()
                        .id(card.getId())
                        .type(card.getType().getName())
                        .currency(card.getType().getCurrency())
                        .balance(card.getBalance())
                        .cardNumber(card.getCardNumber())
                        .userId(card.getUser().getId())
                        .name(card.getName())
                        .build();
                response.add(cardDTO);
            }
            return response;
        }
    }

    @Override
    public Card get(Long id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found by id: " + id));
        return card;
    }


    private CardType getCardType(Long id) {
        CardType cardType = cardTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card type not found by id: " + id));
        return cardType;
    }
}
