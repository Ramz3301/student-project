public class SaveStudentOrder {
    public static void main(String[] args) {
        StudentOrder sO = new StudentOrder();
        sO.hFirstName = "Ivan";
        sO.hLastName = "Ivanov";
        sO.wFirstName = "Marina";
        sO.wLastName = "Ivanova";
        StudentOrder s1 = new StudentOrder();
        s1.hFirstName = "Ivan";
        s1.hLastName = "Petrov";
        s1.wFirstName = "Marina";
        s1.wLastName = "Petrova";

        long answer = saveStudentOrder(sO);
        System.out.println(answer);
    }

    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 100;
        System.out.println("save student order");
        return answer;
    }
}
