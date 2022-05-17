package edu.student_order.domain.register;

import edu.student_order.domain.Person;

public class AnswerCityRegisterItem {

    public enum CityStatus {
        YES, NO, ERROR;
    }

    public static class CityError {
        private String code;
        private String text;

        public CityError(String code, String text) {
            this.code = code;
            this.text = text;
        }

        public String getCode() {
            return code;
        }

        public String getText() {
            return text;
        }
    }

    private CityStatus cityStatus;
    private Person person;
    private CityError cityError;

    public AnswerCityRegisterItem(CityStatus cityStatus, Person person) {
        this.cityStatus = cityStatus;
        this.person = person;
    }

    public AnswerCityRegisterItem(CityStatus cityStatus, Person person, CityError cityError) {
        this.cityStatus = cityStatus;
        this.person = person;
        this.cityError = cityError;
    }

    public CityStatus getCityStatus() {
        return cityStatus;
    }

    public Person getPerson() {
        return person;
    }

    public CityError getCityError() {
        return cityError;
    }
}
