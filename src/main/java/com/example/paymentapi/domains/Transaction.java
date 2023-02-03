package com.example.paymentapi.domains;

import com.example.paymentapi.enums.TransactionStatus;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/2/23 11:19 PM (Thursday)
 * PaymentApi/IntelliJ IDEA
 */


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction")
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(generator = "transaction_uuid_generator")
    @GenericGenerator(name = "transaction_uuid_generator", strategy = "uuid2")
    private String id;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Card.class)
    @JoinColumn(name = "sender_card_id", nullable = false)
    private Card sender;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Card.class)
    @JoinColumn(name = "receiver_card_id", nullable = false)
    private Card receiver;
    @Column(nullable = false, name = "sending_amount")
    private Long sendingAmount;
    @Column(nullable = false, name = "receiving_amount")
    private Long receivingAmount;
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    private Long time;

}
