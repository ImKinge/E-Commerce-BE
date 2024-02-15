package com.ecommerce.dto;


import java.time.LocalDate;

public class UserDto {

    private String fiscalCode;

    private String name;

    private String surname;

    private LocalDate dateOfBirth;

    private String email;

    private Long infoPhone;

    private String address;

    private String username;

    private String password;


    public UserDto () {

    }

    public UserDto(String fiscalCode, String name, String surname, LocalDate dateOfBirth, String email, Long infoPhone, String address, String username, String password) {
        this.fiscalCode = fiscalCode;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.infoPhone = infoPhone;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getInfoPhone() {
        return infoPhone;
    }

    public void setInfoPhone(Long infoPhone) {
        this.infoPhone = infoPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
