package edu.student_order.validator;

import edu.student_order.domain.CityRegisterCheckerResponse;
import edu.student_order.domain.Person;
import edu.student_order.exception.CityRegisterException;

public class RealCityRegisterChecker implements CityRegisterChecker {
    @Override
    public CityRegisterCheckerResponse checkPerson(Person person) throws CityRegisterException {
        return null;
    }
}
