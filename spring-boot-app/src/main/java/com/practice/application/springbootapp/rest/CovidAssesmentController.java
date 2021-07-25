package com.practice.application.springbootapp.rest;

import com.practice.application.springbootapp.domain.PersonDto;
import com.practice.application.springbootapp.domain.RiskAssesmentRequest;
import com.practice.application.springbootapp.service.CovidAssesmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin()
@Tag(name = "covid", description = "the covid assessment API")
public class CovidAssesmentController {

    private CovidAssesmentService covidAssesmentService;

    @Autowired
    public CovidAssesmentController(CovidAssesmentService covidAssesmentService){
        this.covidAssesmentService = covidAssesmentService;
    }

    @Operation(summary = "calculate covid risk", description = "Service to calculate and assess person on the basis of symbtons", tags = { "covid" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation", content = @Content),
            @ApiResponse(responseCode = "400", description = "invalid data", content = @Content)
    })
    @PostMapping("/risk-assement")
    public ResponseEntity<Long> checkRisk(@Valid @RequestBody RiskAssesmentRequest riskAssesmentRequest) {

        // Create the order
        Long summary = covidAssesmentService.calculateRisk(riskAssesmentRequest);

        return ResponseEntity.ok(summary);
    }

    @Operation(summary = "calculate covid risk", description = "Service to calculate and assess person on the basis of symbtons", tags = { "covid" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation", content = @Content),
            @ApiResponse(responseCode = "400", description = "invalid data", content = @Content)
    })
    @PostMapping("/update-covid-result/{userId}/{adminId}/{result}")
    public ResponseEntity<Boolean> updateCovidResult(@RequestParam String userId,
                                                     @RequestParam String adminId,
                                                     @RequestParam String result) {

        Boolean covidResult = covidAssesmentService.updateCovidResult(userId,adminId,result);

        return ResponseEntity.ok(covidResult);
    }




}
