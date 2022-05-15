public class StudentOrderValidator {
    public static void main(String[] args) {
        checkAll();
    }

    static void checkAll() {
        StudentOrder studentOrder = readStudentOrder();

        AnswerCityRegister answerCityRegister = checkCityRegister(studentOrder);
        AnswerWedding answerWedding = checkWedding(studentOrder);
        AnswerChildren answerChildren = checkChildren(studentOrder);
        AnswerStudent answerStudent = checkStudent(studentOrder);

        sendMail(studentOrder);
    }

    static void sendMail(StudentOrder studentOrder) {

    }

    static StudentOrder readStudentOrder() {
        return new StudentOrder();
    }

    static AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        System.out.println("CitiRegister is running");
        AnswerCityRegister answerCityRegister = new AnswerCityRegister();
        return answerCityRegister;
    }

    static AnswerWedding checkWedding(StudentOrder studentOrder) {
        System.out.println("Wedding checking");
        AnswerWedding answerWedding = new AnswerWedding();
        return answerWedding;
    }

    static AnswerChildren checkChildren(StudentOrder studentOrder) {
        System.out.println("Children check is running");
        AnswerChildren answerChildren = new AnswerChildren();
        return answerChildren;
    }

    static AnswerStudent checkStudent(StudentOrder studentOrder) {
        System.out.println("Student checking");
        AnswerStudent answerStudent = new AnswerStudent();
        return answerStudent;
    }
}
