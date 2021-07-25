package com.practice.application.springbootapp.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class RiskAssesmentRequest {

    @NotBlank
    private Long userId;

    private List<Symptoms> symptoms;

    private boolean travelHistory;

    private boolean contactWithCovidPatient;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Symptoms> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptoms> symptoms) {
        this.symptoms = symptoms;
    }

    public boolean isTravelHistory() {
        return travelHistory;
    }

    public void setTravelHistory(boolean travelHistory) {
        this.travelHistory = travelHistory;
    }

    public boolean isContactWithCovidPatient() {
        return contactWithCovidPatient;
    }

    public void setContactWithCovidPatient(boolean contactWithCovidPatient) {
        this.contactWithCovidPatient = contactWithCovidPatient;
    }
}
