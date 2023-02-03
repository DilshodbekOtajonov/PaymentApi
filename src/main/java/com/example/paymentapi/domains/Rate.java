package com.example.paymentapi.domains;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/1/23 12:57 PM (Wednesday)
 * PaymentApi/IntelliJ IDEA
 */

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 10)
    private String fromCurrency;
    @Column(nullable = false, length = 10)
    private String toCurrency;
    private Long rate;
}
