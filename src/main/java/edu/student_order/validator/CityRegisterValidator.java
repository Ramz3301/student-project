package edu.student_order.validator;

import edu.student_order.domain.Person;
import edu.student_order.domain.register.AnswerCityRegister;
import edu.student_order.domain.Child;
import edu.student_order.domain.register.AnswerCityRegisterItem;
import edu.student_order.domain.register.CityRegisterResponse;
import edu.student_order.domain.StudentOrder;
import edu.student_order.exception.CityRegisterException;
import edu.student_order.validator.register.CityRegisterChecker;
import edu.student_order.validator.register.RealCityRegisterChecker;

import java.util.List;

public class CityRegisterValidator {
    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new RealCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        AnswerCityRegister answerCityRegister = new AnswerCityRegister();

        answerCityRegister.addItem(checkPerson(studentOrder.getHusband()));
        answerCityRegister.addItem(checkPerson(studentOrder.getWife()));
        List<Child> children = studentOrder.getChildren();
        for (Child child : children) {
            answerCityRegister.addItem(checkPerson(child));
        }

        return answerCityRegister;
    }

    private AnswerCityRegisterItem checkPerson(Person person) {
        try {
            CityRegisterResponse childAnswer = personChecker.checkPerson(person);
        } catch (CityRegisterException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
