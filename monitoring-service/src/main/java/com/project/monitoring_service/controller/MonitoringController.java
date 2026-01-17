package com.project.monitoring_service.controller;

import com.project.monitoring_service.dto.TransactionDTO;
import com.project.monitoring_service.service.MonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/monitor")
public class MonitoringController {
    @Autowired
    private MonitoringService monitoringService;

    @PostMapping
    public String monitor(@RequestBody TransactionDTO transactionDTO){
        monitoringService.monitor(transactionDTO);
        return "Monitoring completed";
    }

    @PostMapping("/analyze")
    public String analyze(@RequestBody TransactionDTO transaction) {
        monitoringService.analyzeTransaction(transaction);
        return "Transaction analyzed";
    }

}
