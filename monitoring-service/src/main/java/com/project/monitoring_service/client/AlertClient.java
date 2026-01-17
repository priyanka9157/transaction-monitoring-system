package com.project.monitoring_service.client;

import com.project.monitoring_service.dto.AlertRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "alert-service"
//        , url = "http://localhost:8083"
)
public interface AlertClient {

    @PostMapping("/api/alerts")
    void createAlert(@RequestBody AlertRequest alertRequest);
}
