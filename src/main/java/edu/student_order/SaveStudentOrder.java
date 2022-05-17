package edu.student_order;

import edu.student_order.domain.Adult;
import edu.student_order.domain.Child;
import edu.student_order.domain.Person;
import edu.student_order.domain.StudentOrder;

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

        Adult husband = new Adult("Ivanov", "Ivan", "Ivanovich", null);

        return studentOrder;
    }
}
