package com.example.paymentapi.domains;

import javax.persistence.*;

import com.example.paymentapi.enums.UserStatus;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author "Otajonov Dilshodbek
 * @since 2/1/23 12:56 PM (Wednesday)
 * PaymentApi/IntelliJ IDEA
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(generator = "uuid_generator")
    @GenericGenerator(name = "uuid_generator", strategy = "uuid2")
    private String id;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
}
