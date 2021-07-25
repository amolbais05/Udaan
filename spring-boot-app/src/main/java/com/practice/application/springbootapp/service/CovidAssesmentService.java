package com.practice.application.springbootapp.service;


import com.practice.application.springbootapp.domain.Person;
import com.practice.application.springbootapp.domain.RiskAssesmentRequest;
import com.practice.application.springbootapp.domain.RiskAssessment;
import com.practice.application.springbootapp.repository.PersonRepository;
import com.practice.application.springbootapp.repository.RiskAssessmentRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class CovidAssesmentService {

    private PersonRepository personRepository;
    private RiskAssessmentRepository riskAssessmentRepository;

    public CovidAssesmentService(PersonRepository personRepository, RiskAssessmentRepository riskAssessmentRepository){
        this.personRepository = personRepository;
        this.riskAssessmentRepository = riskAssessmentRepository;
    }


    public Long calculateRisk(@Valid RiskAssesmentRequest riskAssesmentRequest){
        Long userId = riskAssesmentRequest.getUserId();

        Optional<Person> personOptional = personRepository.findById(userId);

        if(null==personOptional.get().getId()){
            // No Such user exists
            throw new IllegalArgumentException("No Such User exists!!");
        }

        Long percentRisk = 5l;

        int  totalSymptons = riskAssesmentRequest.getSymptoms().size();

        if(totalSymptons==1 && otherTests(riskAssesmentRequest)){
            percentRisk =  50l;
        }else if(totalSymptons==2 && otherTests(riskAssesmentRequest)){
            percentRisk = 75l;
        }else if(totalSymptons > 2 && otherTests(riskAssesmentRequest)){
            percentRisk = 75l;
        }

        // Before returning update it in risk assessment
        updateCurrentResult(userId,percentRisk,personOptional.get().getPinCode());

        return percentRisk;
    }

    private boolean otherTests(RiskAssesmentRequest riskAssesmentRequest){
        return riskAssesmentRequest.isContactWithCovidPatient() || riskAssesmentRequest.isTravelHistory();
    }

    private void updateCurrentResult(Long userId, Long percentRisk, Integer pinCode){
        RiskAssessment riskAssessment = new RiskAssessment();

        riskAssessment.setId(userId);
        riskAssessment.setRiskPercentage(Math.toIntExact(percentRisk));
        riskAssessment.setPinCode(pinCode);

        riskAssessmentRepository.saveAndFlush(riskAssessment); // trying  to keep latest assement for user

    }

    public Boolean updateCovidResult(String userId, String adminId, String result) {

        /*Optional<Person> personOptional = personRepository.findById((Long)userId);

        if(null==personOptional.get().getId()){
            // No Such user exists
            throw new IllegalArgumentException("No Such User exists!!");
        }*/


    return false;


    }
}
