package edu.student_order.domain;

import java.time.LocalDate;

public class Person {
    protected String surname;
    protected String firstName;
    private String patronymic;
    private LocalDate dateOfBirth;
    private Address address;


    public Person() {
        System.out.println("Person is created");
    }
    public Person(String surname, String firstName) {
        this.surname = surname;
        this.firstName = firstName;
    }

    public String getPersonString() {
        return surname + " " + firstName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}