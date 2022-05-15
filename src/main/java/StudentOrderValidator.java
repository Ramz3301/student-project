import java.util.Date;

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

            if(!answerCityRegister.success) {
                break;
            }

            AnswerWedding answerWedding = checkWedding(studentOrder);
            AnswerChildren answerChildren = checkChildren(studentOrder);
            AnswerStudent answerStudent = checkStudent(studentOrder);

            sendMail(studentOrder);
        }
    }

    static void sendMail(StudentOrder studentOrder) {
        System.out.println("Mail delivered");
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
        weddingValidator.date = new Date("10.06.2018");
        AnswerWedding answerWedding = weddingValidator.checkWedding(studentOrder);
        return answerWedding;
    }

    static AnswerChildren checkChildren(StudentOrder studentOrder) {
        return CheckChildren.checkChildren(studentOrder);
    }

    static AnswerStudent checkStudent(StudentOrder studentOrder) {
        return CheckStudent.checkStudent(studentOrder);
    }
}
