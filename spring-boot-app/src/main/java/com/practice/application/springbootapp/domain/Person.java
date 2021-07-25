package com.practice.application.springbootapp.domain;

import javax.persistence.*;

@Entity
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
    @SequenceGenerator(name="employee_generator", sequenceName = "seq_emp_id", allocationSize=1)
    @Column(name = "emp_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "covid_result", nullable = false)
    private boolean covidResult;;

    @Column(name = "user_type", nullable = false)
    private String userType;;

    @Column(name = "pin_code", nullable = false)
    private Integer pinCode;

    @Column(name = "phone_number", nullable = false)
    private Integer phoneNumber;

    @Column(name = "admin_id", nullable = true)
    private String adminId;



    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isCovidResult() {
        return covidResult;
    }

    public void setCovidResult(boolean covidResult) {
        this.covidResult = covidResult;
    }
}
