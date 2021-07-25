package com.practice.application.springbootapp.domain;

import javax.persistence.*;

@Entity
@Table(name = "risk_assessment")
public class RiskAssessment {

    @Id
    @Column(name = "user_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "pin_code", nullable = false)
    private Integer pinCode;

    @Column(name = "risk_percentage", nullable = false)
    private Integer riskPercentage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public Integer getRiskPercentage() {
        return riskPercentage;
    }

    public void setRiskPercentage(Integer riskPercentage) {
        this.riskPercentage = riskPercentage;
    }
}
