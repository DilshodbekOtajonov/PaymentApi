package com.example.paymentapi.configs.exceptions;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/10/23 12:43 PM (Friday)
 * PaymentApi/IntelliJ IDEA
 */

public class ValidationException extends RuntimeException{

    public ValidationException(String message) {
        super(message);
    }

}
