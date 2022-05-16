package edu.student_order.validator;

import edu.student_order.domain.*;
import edu.student_order.mail.MailSender;

public class StudentOrderValidator {
    public static void main(String[] args) {
        checkAll();
    }

    static void checkAll() {

        while (true) {
            StudentOrder studentOrder = readStudentOrder();

            if (studentOrder == null) {
                break;
            }

            AnswerCityRegister answerCityRegister = checkCityRegister(studentOrder);

            if (!answerCityRegister.success) {
                break;
            }

            AnswerWedding answerWedding = checkWedding(studentOrder);
            AnswerChildren answerChildren = checkChildren(studentOrder);
            AnswerStudent answerStudent = checkStudent(studentOrder);

            sendMail(studentOrder);
        }
    }

    static void sendMail(StudentOrder studentOrder) {
        new MailSender().sendMail(studentOrder);
    }

    static StudentOrder readStudentOrder() {
        StudentOrder studentOrder = new StudentOrder();
        return studentOrder;
    }

    static AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        CityRegisterValidator cityRegisterValidator1 = new CityRegisterValidator();
        cityRegisterValidator1.hostName = "Host1";
        cityRegisterValidator1.login = "Login1";
        cityRegisterValidator1.password = "Pswrd1";
        AnswerCityRegister answerCityRegister1 = cityRegisterValidator1.checkCityRegister(studentOrder);
        return answerCityRegister1;
    }

    static AnswerWedding checkWedding(StudentOrder studentOrder) {
        WeddingValidator weddingValidator = new WeddingValidator();
        AnswerWedding answerWedding = weddingValidator.checkWedding(studentOrder);
        return answerWedding;
    }

    static AnswerChildren checkChildren(StudentOrder studentOrder) {
        ChildrenValidator childrenValidator = new ChildrenValidator();
        AnswerChildren answerChildren = childrenValidator.checkChildren(studentOrder);
        return answerChildren;
    }

    static AnswerStudent checkStudent(StudentOrder studentOrder) {
        StudentValidator studentValidator = new StudentValidator();
        AnswerStudent answerStudent = studentValidator.checkStudent(studentOrder);
        return answerStudent;
    }
}
