package com.project.alert_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "alerts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long transactionId;
    private Integer riskScore;
    private String alertType;
    private String status;
    private LocalDateTime createdAt;
}
