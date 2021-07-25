package com.practice.application.springbootapp.rest;

import com.practice.application.springbootapp.domain.Person;
import com.practice.application.springbootapp.domain.PersonDto;
import com.practice.application.springbootapp.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin()
@Tag(name = "spring", description = "the spring API")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService employeeService){
        this.personService = employeeService;
    }


    @Operation(summary = "Find available employee", description = "Returns all employees.", tags = { "spring" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Person.class)))) })
    @GetMapping("/employee")
    public ResponseEntity<Iterable<Person>> getCountries() {
      //  return ResponseEntity.ok(personService.getAllEmployee()); Implementation not required yet
        return null;
    }


    @Operation(summary = "Add user or admin", description = "Add new employee.", tags = { "spring" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation", content = @Content),
            @ApiResponse(responseCode = "400", description = "invalid data", content = @Content)
    })
    @PostMapping("/add-peson")
    public ResponseEntity<Long> createOrder(@Valid @RequestBody PersonDto employeeRequest) {

        // Create the order
        Long summary = personService.addPerson(employeeRequest);

        return ResponseEntity.ok(summary);
    }

}
