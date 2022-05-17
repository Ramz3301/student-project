package edu.student_order.validator.register;

import edu.student_order.domain.Person;
import edu.student_order.domain.register.CityRegisterResponse;
import edu.student_order.exception.CityRegisterException;
import edu.student_order.exception.TransportException;

public class FakeCityRegisterException implements CityRegisterChecker {
    @Override
    public CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException, TransportException {
        return null;
    }
}
