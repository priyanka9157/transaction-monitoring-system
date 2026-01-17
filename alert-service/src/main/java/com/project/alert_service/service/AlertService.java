package com.project.alert_service.service;

import com.project.alert_service.model.Alert;
import com.project.alert_service.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertService {
    @Autowired
    private AlertRepository alertRepository;

    public Alert createAlert(Alert alert){
        alert.setStatus("OPEN");
        alert.setCreatedAt(LocalDateTime.now());
        return alertRepository.save(alert);
    }

    public List<Alert> getAllAlert(){
        return alertRepository.findAll();
    }
}
