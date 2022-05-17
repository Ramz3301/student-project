package edu.student_order.validator;

import edu.student_order.domain.AnswerCityRegister;
import edu.student_order.domain.Child;
import edu.student_order.domain.CityRegisterCheckerResponse;
import edu.student_order.domain.StudentOrder;
import edu.student_order.exception.CityRegisterException;

import java.util.List;

public class CityRegisterValidator {
    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new RealCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        try {
            CityRegisterCheckerResponse husbandAnswer = personChecker.checkPerson(studentOrder.getHusband());
            CityRegisterCheckerResponse wifeAnswer = personChecker.checkPerson(studentOrder.getWife());
            List<Child> children = studentOrder.getChildren();

            for (Child child : children) {
                CityRegisterCheckerResponse childAnswer = personChecker.checkPerson(child);
            }
        } catch (CityRegisterException ex) {
            ex.printStackTrace();
        }

        AnswerCityRegister answerCityRegister = new AnswerCityRegister();
        return answerCityRegister;
    }
}
