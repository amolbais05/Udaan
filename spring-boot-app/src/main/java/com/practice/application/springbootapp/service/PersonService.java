package com.practice.application.springbootapp.service;

import com.practice.application.springbootapp.domain.Person;
import com.practice.application.springbootapp.domain.PersonDto;
import com.practice.application.springbootapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;


    public Long addPerson(PersonDto employeeRequest) {
        Person employee = buildPerson(employeeRequest);
        employee =  personRepository.save(employee);
        return employee.getId();
    }

    private Person buildPerson(PersonDto personRequst) {

        Person person = new Person();

        person.setFirstName(personRequst.getFirstName());
        person.setLastName(personRequst.getLastName());
        person.setGender(personRequst.getGender());
        person.setUserType(personRequst.getUserType()); // this will be user or admin
        person.setPinCode(personRequst.getPinCode());
        person.setPhoneNumber(personRequst.getPhoneNumber());

        return person;

    }
}
