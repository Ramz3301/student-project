package edu.student_order;

import edu.student_order.domain.Adult;
import edu.student_order.domain.Child;
import edu.student_order.domain.StudentOrder;

public class SaveStudentOrder {
    public static void main(String[] args) {
        StudentOrder sO = new StudentOrder();;

        long answer = saveStudentOrder(sO);
        System.out.println(answer);
    }

    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 100;
        System.out.println("save student order: ");
        return answer;
    }

    static StudentOrder buildStudentOrder() {
        StudentOrder studentOrder = new StudentOrder();
        Adult husband = new Adult();
        studentOrder.setHusband(husband);
        Adult wife = new Adult();
        studentOrder.setWife(wife);
        Child child = new Child();
        studentOrder.setChild(child);
        return studentOrder;
    }
}
