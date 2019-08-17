package by.shmarlouski.java.simplenote.Utils;

public class Validation {

    public static boolean isEmailValid(String email){
       String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        return email.matches(regex);
    }

    public static boolean isPhoneNumberValid(String number){
        String regex = "375[0-9]{9}";

        return number.replaceAll("\\s+","").matches(regex);
    }
}
