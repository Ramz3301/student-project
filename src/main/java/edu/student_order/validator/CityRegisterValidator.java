package edu.student_order.validator;

import edu.student_order.domain.AnswerCityRegister;
import edu.student_order.domain.CityRegisterCheckerResponse;
import edu.student_order.domain.StudentOrder;
import edu.student_order.exception.CityRegisterException;

public class CityRegisterValidator {
    public String hostName;
    protected int port;
    public String login;
    String password;
    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new RealCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        try {
            CityRegisterCheckerResponse husbandAnswer = personChecker.checkPerson(studentOrder.getHusband());
            CityRegisterCheckerResponse wifeAnswer = personChecker.checkPerson(studentOrder.getWife());
            CityRegisterCheckerResponse childAnswer = personChecker.checkPerson(studentOrder.getChild());
        } catch (CityRegisterException ex) {
            ex.printStackTrace();
        }

        AnswerCityRegister answerCityRegister = new AnswerCityRegister();
        return answerCityRegister;
    }
}
