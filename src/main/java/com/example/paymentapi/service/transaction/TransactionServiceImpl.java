package com.example.paymentapi.service.transaction;

import com.example.paymentapi.configs.security.UserDetails;
import com.example.paymentapi.domains.Card;
import com.example.paymentapi.domains.Rate;
import com.example.paymentapi.domains.Transaction;
import com.example.paymentapi.dto.transaction.TransactionCreateDTO;
import com.example.paymentapi.dto.transaction.TransactionDTO;
import com.example.paymentapi.enums.TransactionStatus;
import com.example.paymentapi.repository.RateRepository;
import com.example.paymentapi.repository.TransactionRepository;
import com.example.paymentapi.service.card.CardService;
import com.example.paymentapi.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/3/23 9:00 PM (Friday)
 * PaymentApi/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final RateRepository rateRepository;
    private final CardService cardService;

    @Override
    public String create(TransactionCreateDTO dto) throws IllegalAccessException {
        Card senderCard = cardService.get(dto.senderId());
        Card receiverCard = cardService.get(dto.receiverId());

// checking whether sender and currently active user is same
        String senderId = senderCard.getUser().getId();
        checkUser(senderId);

        Long sendingAmount = dto.amount();
        Long receivingAmount;
//        checking balance of sender card against sending amount
        checkBalance(senderCard, sendingAmount);

        String senderCurrency = senderCard.getType().getCurrency();
        String receiverCurrency = receiverCard.getType().getCurrency();

        if (!senderCurrency.equals(receiverCurrency)) {

            Rate rate = rateRepository.findRate(senderCurrency, receiverCurrency)
                    .orElseThrow(() -> new RuntimeException("Rate conversion not found"));
            Long rateAmount = rate.getRate();
            if (rateAmount > 0) {
                receivingAmount = sendingAmount * rateAmount;
            } else {
                rateAmount = Math.abs(rateAmount);
                receivingAmount = sendingAmount / rateAmount;
                sendingAmount = receivingAmount * rateAmount;
            }

        } else {
            receivingAmount = sendingAmount;
        }

        Transaction transaction = new Transaction();
        transaction.setStatus(TransactionStatus.NEW);
        transaction.setSender(senderCard);
        transaction.setReceiver(receiverCard);
        transaction.setSendingAmount(sendingAmount);
        transaction.setReceivingAmount(receivingAmount);
        transaction.setTime(System.currentTimeMillis());
        Transaction savedTransaction = transactionRepository.save(transaction);
        return savedTransaction.getId();
    }

    @Transactional
    @Override
    public TransactionDTO confirm(String id) throws IllegalAccessException {
        synchronized (cardService) {
            Transaction transaction = transactionRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("transaction not found by id: " + id));
            if (!transaction.getStatus().equals(TransactionStatus.NEW))
                throw new RuntimeException("Transaction already occurred");

            Card senderCard = transaction.getSender();
            Card receiverCard = transaction.getReceiver();

//        checking balance of sender card against sending amount
            String senderId = senderCard.getUser().getId();
            checkUser(senderId);

            try {
                Long sendingAmount = transaction.getSendingAmount();
                Long receivingAmount = transaction.getReceivingAmount();
                checkBalance(senderCard, sendingAmount);
                senderCard.setBalance(senderCard.getBalance() - sendingAmount);
                receiverCard.setBalance(receiverCard.getBalance() + receivingAmount);
                transaction.setStatus(TransactionStatus.SUCCESS);
                Transaction savedTransaction = transactionRepository.save(transaction);

                return TransactionDTO.builder()
                        .id(savedTransaction.getId())
                        .status("Success")
                        .senderId(senderCard.getId())
                        .receiverId(receiverCard.getId())
                        .sendingAmount(sendingAmount)
                        .receivingAmount(receivingAmount)
                        .build();

            } catch (Exception e) {
                transaction.setStatus(TransactionStatus.ERROR);
                transactionRepository.save(transaction);
                throw new RuntimeException("Transaction failed");
            }
        }
    }

    private void checkBalance(Card card, Long amount) {
        boolean isSenderBalanceSufficient = card.getBalance() > amount;
        if (!isSenderBalanceSufficient)
            throw new RuntimeException("Insufficient balance on card id: " + card.getId());
    }

    private void checkUser(String userId) throws IllegalAccessException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        if (!userDetails.authUser().getId().equals(userId))
            throw new IllegalAccessException("Access denied");
    }

}
