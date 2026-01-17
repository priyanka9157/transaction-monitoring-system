package com.project.monitoring_service.service;

import com.project.monitoring_service.client.AlertClient;
import com.project.monitoring_service.client.TransactionClient;
import com.project.monitoring_service.dto.AlertRequest;
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
    private AlertClient alertClient;

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

    public void analyzeTransaction(TransactionDTO transactionDTO){
        int riskScore = calculateRisk(transactionDTO);

        if(riskScore > 30)
        {
            AlertRequest alertRequest = new AlertRequest();
            alertRequest.setTransactionId(transactionDTO.getId());
            alertRequest.setRiskScore(riskScore);
            alertRequest.setAlertType("HIGH_RISK");
            alertClient.createAlert(alertRequest);
        }
    }

    private int calculateRisk(TransactionDTO transactionDTO) {
        BigDecimal highAmount = new BigDecimal("50000");
        if(transactionDTO.getAmount().compareTo(highAmount) > 0) 
        {
            return 85;
        }
        return 30;
    }
}

