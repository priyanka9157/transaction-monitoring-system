package com.project.alert_service.controller;

import com.project.alert_service.model.Alert;
import com.project.alert_service.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/api/alerts")
public class AlertController {
    @Autowired
    private AlertService alertService;

    @PostMapping
    public Alert createAlert(@RequestBody Alert alert){
        return alertService.createAlert(alert);
    }

    @GetMapping
    public List<Alert> getAlerts(){
        return alertService.getAllAlert();
    }
}
