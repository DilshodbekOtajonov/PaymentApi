package com.example.paymentapi.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/2/23 11:16 PM (Thursday)
 * PaymentApi/IntelliJ IDEA
 */

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long balance;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true, length = 16)
    private String cardNumber;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CardType.class)
    @JoinColumn(name = "card_type_id", nullable = false)
    private CardType type;
    private String currency;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
