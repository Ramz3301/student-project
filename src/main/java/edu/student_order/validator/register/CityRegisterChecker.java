package edu.student_order.validator.register;

import edu.student_order.domain.register.CityRegisterResponse;
import edu.student_order.domain.Person;
import edu.student_order.exception.CityRegisterException;

public interface CityRegisterChecker {
    CityRegisterResponse checkPerson(Person person) throws CityRegisterException;
}
