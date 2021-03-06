package edu.student_order.validator.register;

import edu.student_order.domain.Adult;
import edu.student_order.domain.Child;
import edu.student_order.domain.register.CityRegisterResponse;
import edu.student_order.domain.Person;
import edu.student_order.exception.CityRegisterException;
import edu.student_order.exception.TransportException;

public class RealCityRegisterChecker implements CityRegisterChecker {
    public static final String GOOD_1 = "1000";
    public static final String GOOD_2 = "2000";
    public static final String BAD_1 = "1001";
    public static final String BAD_2 = "2001";
    public static final String ERROR_1 = "1002";
    public static final String ERROR_2 = "2002";
    public static final String ERROR_T_1 = "1003";
    public static final String ERROR_T_2 = "2003";

    @Override
    public CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException, TransportException {
        CityRegisterResponse response = new CityRegisterResponse();

        if (person instanceof Adult) {
            Adult adult = (Adult) person;
            String passportSerial = adult.getPassportSeries();

            if (passportSerial.equals(GOOD_1) || passportSerial.equals(GOOD_2)) {
                response.setExisting(true);
                response.setTemporal(false);
            }

            if (passportSerial.equals(BAD_1) || passportSerial.equals(BAD_2)) {
                response.setExisting(false);
            }

            if (passportSerial.equals(ERROR_1) || passportSerial.equals(ERROR_2)) {
                CityRegisterException exception = new CityRegisterException("1", "Fake ERROR");
                throw exception;
            }

            if (passportSerial.equals(ERROR_T_1) || passportSerial.equals(ERROR_T_2)) {
                TransportException exception = new TransportException("Transport ERROR");
                throw exception;
            }
        }

        if (person instanceof Child) {
//            Child child = (Child) person;
            response.setExisting(true);
            response.setTemporal(false);
        }

        System.out.println(response);

        return response;
    }
}
