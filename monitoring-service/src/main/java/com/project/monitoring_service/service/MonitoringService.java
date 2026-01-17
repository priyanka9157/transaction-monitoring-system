package com.project.monitoring_service.service;

import com.project.monitoring_service.client.TransactionClient;
import com.project.monitoring_service.dto.TransactionDTO;
import com.project.monitoring_service.model.RiskTransaction;
import com.project.monitoring_service.repository.RiskTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MonitoringService {
    @Autowired
    private TransactionClient transactionClient;

    @Autowired
    private RiskTransactionRepository riskTransactionRepository;

    public void monitor(TransactionDTO transactionDTO){
        if(transactionDTO.getAmount().compareTo(new BigDecimal("50000")) >0){
            saveRisk(transactionDTO.getId(),"HIGH_AMOUNT","CRITICAL");
        }
    }

    private void saveRisk(Long txtId, String type, String level) {
        RiskTransaction riskTransaction = new RiskTransaction();
        riskTransaction.setTransactionId(txtId);
        riskTransaction.setRiskType(type);
        riskTransaction.setRiskLevel(level);
        riskTransactionRepository.save(riskTransaction);
    }
}

