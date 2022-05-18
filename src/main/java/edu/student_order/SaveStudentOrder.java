package edu.student_order;

import edu.student_order.dao.DictionaryDaoImpl;
import edu.student_order.domain.*;
import edu.student_order.exception.DaoException;

import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder {
    public static void main(String[] args) throws DaoException {
//        List<Street> dictionary = new DictionaryDaoImpl().findStreets("a");
//        for (Street street : dictionary) {
//            System.out.println(street.getStreetName());
//        }

//        List<PassportOffice> passportOfficeList = new DictionaryDaoImpl().findPassportOffice("010020000");
//        for (PassportOffice passportOffice1 : passportOfficeList) {
//            System.out.println(passportOffice1.getOfficeName());
//        }
//
//        List<RegisterOffice> registerOfficeList = new DictionaryDaoImpl().findRegisterOffice("010010000000");
//        for (RegisterOffice registerOffice : registerOfficeList) {
//            System.out.println(registerOffice.getOfficeName());
//        }
        List<CountryArea> countryAreaList1 = new DictionaryDaoImpl().findAreas("");
        for (CountryArea countryArea : countryAreaList1) {
            System.out.println(countryArea.getAreaId() + " : " + countryArea.getAreaName());
        }
        System.out.println("=================");

        List<CountryArea> countryAreaList2 = new DictionaryDaoImpl().findAreas("020000000000");
        for (CountryArea countryArea : countryAreaList2) {
            System.out.println(countryArea.getAreaId() + " : " + countryArea.getAreaName());
        }
        System.out.println("=================");

        List<CountryArea> countryAreaList3 = new DictionaryDaoImpl().findAreas("020010000000");
        for (CountryArea countryArea : countryAreaList3) {
            System.out.println(countryArea.getAreaId() + " : " + countryArea.getAreaName());
        }
        System.out.println("=================");

        List<CountryArea> countryAreaList4 = new DictionaryDaoImpl().findAreas("020010010000");
        for (CountryArea countryArea : countryAreaList4) {
            System.out.println(countryArea.getAreaId() + " : " + countryArea.getAreaName());
        }
    }

    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 100;
        System.out.println("save student order: ");
        return answer;
    }

    public static StudentOrder buildStudentOrder(long id) {
        StudentOrder studentOrder = new StudentOrder();
        studentOrder.setStudentOrderId(id);
        studentOrder.setMarriageCertificateId("" + (123456000 + id));
        studentOrder.setMarriageDate(LocalDate.of(2022, 5, 18));
        RegisterOffice registerOffice1 = new RegisterOffice(1L, "", "");
        studentOrder.setMarriageOffice(registerOffice1);

        Street street = new Street(1L, "Panina");
        Address address =
                new Address(street, "Izhorskaya street", "12", "", "142");

        Adult husband =
                new Adult("Ivanov", "Ivan", "Ivanovich", LocalDate.of(1996, 5, 17));
        husband.setPassportSerial("" + (1000 + id));
        husband.setPassportNumber("" + (10000 + id));
        husband.setIssueDate(LocalDate.of(2016, 6, 15));
        PassportOffice passportOffice1 = new PassportOffice(1L, "", "");
        husband.setIssueDepartment(passportOffice1);
        husband.setStudentId("" + (100000 + id));
        husband.setAddress(address);

        Adult wife =
                new Adult("Ivanova", "Elena", "Petrovna", LocalDate.of(1998, 6, 17));
        wife.setPassportSerial("" + (2000 + id));
        wife.setPassportNumber("" + (20000 + id));
        wife.setIssueDate(LocalDate.of(2018, 7, 15));
        PassportOffice passportOffice2 = new PassportOffice(2L, "", "");
        wife.setIssueDepartment(passportOffice2);
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);

        Child child1 =
                new Child("Ivanova", "Anna", "Ivanovna", LocalDate.of(2020, 5, 8));
        child1.setCertificateNumber("" + (30000 + id));
        child1.setIssueDate(LocalDate.of(2021, 6, 18));
        RegisterOffice registerOffice2 = new RegisterOffice(2L, "", "");
        child1.setIssueDepartment(registerOffice2);
        child1.setAddress(address);

        Child child2 =
                new Child("Ivanova", "Mariya", "Ivanovna", LocalDate.of(2020, 5, 8));
        child2.setCertificateNumber("" + (40000 + id));
        child2.setIssueDate(LocalDate.of(2021, 6, 18));
        child2.setIssueDepartment(registerOffice2);
        child2.setAddress(address);

        studentOrder.setHusband(husband);
        studentOrder.setWife(wife);
        studentOrder.addChild(child1);
        studentOrder.addChild(child2);

        return studentOrder;
    }
}
