public class CityRegisterValidator {

    String hostName;
    String login;
    String password;

    AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        System.out.println("CitiRegister is running: " + hostName + ", " + login + ", " + password);
        AnswerCityRegister answerCityRegister = new AnswerCityRegister();
        answerCityRegister.success = false;
        return answerCityRegister;
    }
}
