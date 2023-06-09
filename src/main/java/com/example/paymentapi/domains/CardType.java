package com.example.paymentapi.domains;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/3/23 12:27 PM (Friday)
 * PaymentApi/IntelliJ IDEA
 */

@Entity
@Getter
@Setter
public class CardType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 10)
    private String name;
    @Column(nullable = false, unique = true, length = 4)
    private String prefix;
    @Column(nullable = false, unique = true, length = 10)
    private String currency;

}
