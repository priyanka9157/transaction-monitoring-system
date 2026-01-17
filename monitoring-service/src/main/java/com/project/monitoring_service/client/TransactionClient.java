package com.project.monitoring_service.client;

import com.project.monitoring_service.dto.TransactionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "transaction-service"
//        , url = "http://localhost:8081"
)
public interface TransactionClient {
    @GetMapping("/api/transactions/user/{userId}")
    List<TransactionDTO> getTransactions(@PathVariable Long userId);
}
