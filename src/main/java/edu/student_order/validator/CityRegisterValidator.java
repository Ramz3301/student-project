package edu.student_order.validator;

import edu.student_order.domain.AnswerCityRegister;
import edu.student_order.domain.StudentOrder;

public class CityRegisterValidator {
    public String hostName;
    protected int port;
    public String login;
    String password;

    public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        System.out.println("CitiRegister is running: " + hostName + ", " + login + ", " + password);
        AnswerCityRegister answerCityRegister = new AnswerCityRegister();
        answerCityRegister.success = false;
        return answerCityRegister;
    }
}
