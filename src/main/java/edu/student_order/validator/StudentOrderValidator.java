package edu.student_order.validator;

import edu.student_order.SaveStudentOrder;
import edu.student_order.domain.*;
import edu.student_order.mail.MailSender;

public class StudentOrderValidator {
    private CityRegisterValidator cityRegisterValidator;
    private WeddingValidator weddingValidator;
    private ChildrenValidator childrenValidator;
    private StudentValidator studentValidator;
    private MailSender mailSender;

    public StudentOrderValidator() {
        cityRegisterValidator = new CityRegisterValidator();
        weddingValidator = new WeddingValidator();
        childrenValidator = new ChildrenValidator();
        studentValidator = new StudentValidator();
        mailSender = new MailSender();
    }

    public static void main(String[] args) {
        StudentOrderValidator studentOrderValidator = new StudentOrderValidator();
        studentOrderValidator.checkAll();
    }

    public void checkAll() {
        StudentOrder[] studentOrders = readStudentOrders();

        for (StudentOrder studentOrder : studentOrders) {
            checkOneOrder(studentOrder);
        }
    }

    public StudentOrder[] readStudentOrders() {
        StudentOrder[] studentOrdersArray = new StudentOrder[3];

        for (int i = 0; i < studentOrdersArray.length; i++) {
            studentOrdersArray[i] = SaveStudentOrder.buildStudentOrder(i);
        }

        return studentOrdersArray;
    }

    public void checkOneOrder(StudentOrder studentOrder) {
        AnswerCityRegister answerCityRegister = checkCityRegister(studentOrder);
//        AnswerWedding answerWedding = checkWedding(studentOrder);
//        AnswerChildren answerChildren = checkChildren(studentOrder);
//        AnswerStudent answerStudent = checkStudent(studentOrder);
//        sendMail(studentOrder);
    }

    public void sendMail(StudentOrder studentOrder) {
        mailSender.sendMail(studentOrder);
    }

    public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        return cityRegisterValidator.checkCityRegister(studentOrder);
    }

    public AnswerWedding checkWedding(StudentOrder studentOrder) {
        return weddingValidator.checkWedding(studentOrder);
    }

    public AnswerChildren checkChildren(StudentOrder studentOrder) {
        return childrenValidator.checkChildren(studentOrder);
    }

    public AnswerStudent checkStudent(StudentOrder studentOrder) {
        return studentValidator.checkStudent(studentOrder);
    }
}
