package com.project.transaction_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = " user_id")
    private Long userId;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "transaction_type")
    private String transactionType;
    @Column(name = "status")
    private String status;
    @Column(name = "location")
    private String location;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
