package com.project.monitoring_service.repository;

import com.project.monitoring_service.model.RiskTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiskTransactionRepository extends JpaRepository<RiskTransaction,Long> {
}
