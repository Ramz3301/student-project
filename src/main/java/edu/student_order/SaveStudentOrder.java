package edu.student_order;

import edu.student_order.domain.*;

import java.time.LocalDate;

public class SaveStudentOrder {
    public static void main(String[] args) {
//        StudentOrder sO = new StudentOrder();;
//        buildStudentOrder();

//        long answer = saveStudentOrder(sO);
//        System.out.println(answer);
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

        Address address =
                new Address("195000", "Izhorskaya street", "12", "", "142");

        Adult husband =
                new Adult("Ivanov", "Ivan", "Ivanovich", LocalDate.of(1996, 5, 17));
        husband.setPassportSerial("" + (1000 + id));
        husband.setPassportNumber("" + (10000 + id));
        husband.setIssueDate(LocalDate.of(2016, 6, 15));
        husband.setIssueDepartment("ГУ МВД № " + id);
        husband.setStudentId("" + (100000 + id));
        husband.setAddress(address);

        Adult wife =
                new Adult("Ivanova", "Elena", "Petrovna", LocalDate.of(1998, 6, 17));
        wife.setPassportSerial("" + (2000 + id));
        wife.setPassportNumber("" + (20000 + id));
        wife.setIssueDate(LocalDate.of(2018, 7, 15));
        wife.setIssueDepartment("ГУ МВД № " + id);
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);

        Child child =
                new Child("Ivanova", "Anna", "Ivanovna", LocalDate.of(2020, 5, 8));
        child.setCertificateNumber("" + (30000 + id));
        child.setIssueDate(LocalDate.of(2021, 6, 18));
        child.setIssueDepartment("Отдел ЗАГС № " + id);
        child.setAddress(address);
        return studentOrder;
    }
}
