public class SaveStudentOrder {
    public static void main(String[] args) {
        StudentOrder sO;
        sO = new StudentOrder();
        sO.hFirstName = "Ivan";
        sO.hLastName = "Ivanov";
        sO.wFirstName = "Marina";
        sO.wLastName = "Ivanova";

        long answer = saveStudentOrder(sO);
        System.out.println(answer);
    }

    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 100;
        System.out.println("save student order");
        return answer;
    }
}
