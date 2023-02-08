package com.example.paymentapi.controller;

import com.example.paymentapi.dto.transaction.TransactionCreateDTO;
import com.example.paymentapi.dto.transaction.TransactionDTO;
import com.example.paymentapi.service.transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/3/23 3:37 PM (Friday)
 * PaymentApi/IntelliJ IDEA
 */
@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/hold")
    public ResponseEntity<String> hold(@RequestBody TransactionCreateDTO dto) {
        String id = transactionService.create(dto);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @PatchMapping("/confirm")
    public ResponseEntity<TransactionDTO> confirm(@RequestParam String id) {
        TransactionDTO dto = transactionService.confirm(id);
        return ResponseEntity.ok(dto);
    }
}
