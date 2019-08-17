package by.shmarlouski.java.simplenote.controller;

import by.shmarlouski.java.simplenote.utils.SimpleNoteUtils;
import by.shmarlouski.java.simplenote.model.Role;
import by.shmarlouski.java.simplenote.model.SimpleNote;
import by.shmarlouski.java.simplenote.model.User;

import static by.shmarlouski.java.simplenote.utils.Scan.scanNumber;
import static by.shmarlouski.java.simplenote.utils.Scan.scanText;
import static by.shmarlouski.java.simplenote.utils.Validation.isEmailValid;
import static by.shmarlouski.java.simplenote.utils.Validation.isPhoneNumberValid;
import static by.shmarlouski.java.simplenote.view.Printer.print;

public class SimpleNoteController implements SimpleNoteUtils {

    private SimpleNote simpleNote = SimpleNote.getInstance();
    private final int MAXPHONENUMBERS = 3;

    private boolean isEmpty() {
        return simpleNote.getArrayList().isEmpty();
    }

    @Override
    public void createUser() {
        User user = new User();

        print("Input User's name...");
        user.setName(scanText());

        print("Input User's second name...");
        user.setSecondName(scanText());

        user.setEmail(addEmail());

        print("Choose Role...");
        user.setRole(roleChange());

        user.setPhoneNumber(inputPhoneNumber());

        simpleNote.getArrayList().add(user);

        print("User was created:");

        print(user.toString());
    }

    @Override
    public void changeUser() {

        if (isEmpty()) {
            print("There is no Users in Simple note!");
            return;
        }

        print("Input User's index... ");

        int index = Integer.parseInt(scanText()) - 1;

        if (!(index >= simpleNote.getArrayList().size() || index < 0 || Double.isNaN(index))) {

            User changedUser = simpleNote.getArrayList().get(index);

            print("Choose the parameter:");
            print("1 - Name");
            print("2 - Second name");
            print("3 - Email");
            print("4 - Role");
            print("5 - Add additional Phone number");
            print("6 - Delete phone number");

            switch (Integer.parseInt(scanText())) {
                case 1:
                    print("Input new name...");
                    changedUser.setName(scanText());
                    break;
                case 2:
                    print("Input new second name...");
                    changedUser.setSecondName(scanText());
                    break;
                case 3:
                    changedUser.setEmail(addEmail());
                    break;
                case 4:
                    print("Choose new Role...");
                    changedUser.setRole(roleChange());
                    break;
                case 5:
                    addPhoneNumber(changedUser);
                    break;
                case 6:
                    print("Input index of phone number which should be deleted ...");
                    deletePHoneNumber(changedUser);
                    break;
                default:
                    print("There is no such action!");
                    break;
            }
            print(changedUser.toString());
        } else {
            print("There is no such User with such index!\n" + "Check User's index  " +
                    "via \"Check list of all Users\" at the Main menu.");
        }
    }

    private void addPhoneNumber(User user) {

        if (user.getPhoneNumbers().size() < MAXPHONENUMBERS) {
            user.setPhoneNumber(inputPhoneNumber());
        } else {
            print("User already got max amount of phone numbers," +
                    " try to delete excess phone numbers!");
        }
    }

    private String inputPhoneNumber() {

        String phoneNumber = "";
        while (!isPhoneNumberValid(phoneNumber)) {
            print("Input phone number in '375.. .......' format.\n" +
                    "You can use only numbers, without spaces...");
            phoneNumber = scanText().replaceAll("\\s+", "");
            if (!isPhoneNumberValid(phoneNumber)) {
                print("Incorrect phone number input! Try again!");
            }
        }
        return phoneNumber;
    }

    private void deletePHoneNumber(User user) {

        if (user.getPhoneNumbers().isEmpty()) {
            print("This User got no phone numbers!");
            return;
        }
        int index1 = 1;
        for (String number : user.getPhoneNumbers()) {
            print(index1 + ". " + number);
            index1++;
        }
        try {
            user.getPhoneNumbers().remove(scanNumber() - 1);
        } catch (Exception e) {
            print("Incorrect input! Try again!\n");
        }
    }

    private String addEmail() {

        String email = "";
        while (!isEmailValid(email)) {
            print("Input email in 'anything@yourmail.any' format...");
            email = scanText();
            if (!isEmailValid(email)) {
                print("Incorrect input! Try again!");
            }
        }

        return email;
    }

    private Role roleChange() {

        print("1 - USER");
        print("2 - ADMIN");
        print("3 - MODER");

        Role role = Role.USER;

        switch (scanNumber()) {
            case 1:
                break;
            case 2:
                role = Role.ADMIN;
                break;
            case 3:
                role = Role.MODER;
                break;
            default:
                print("Wrong input! Try again!\n");
                roleChange();
                break;
        }

        return role;
    }

    @Override
    public void deleteUser() {

        if (isEmpty()) {
            print("There is no Users in Simple note!");
            return;
        }
        print("Input User's index... ");
        //for better reading
        int index = scanNumber() - 1;

        if (!(index >= simpleNote.getArrayList().size() || index < 0 || Double.isNaN(index))) {

            simpleNote.getArrayList().remove(index);

            print("User was deleted.");
        } else {
            print("Wrong input, check User's index  " +
                    "via \"Check list of all Users\" at the Main menu.");
        }
    }

    @Override
    public void displaySimpleNote() {

        int index = 1;
        if (!isEmpty()) {
            for (User user : simpleNote.getArrayList()) {
                print(index++ + ". " + user);
            }
        } else {
            print("There are no Users in Simple Note!");
        }
    }

    @Override
    public void displayUser() {

        if (isEmpty()) {
            print("There is no Users in Simple note!");
            return;
        }

        print("Input User's index... ");
        //for better reading
        int index = Integer.parseInt(scanText()) - 1;

        if (Double.isNaN(index) || index >= simpleNote.getArrayList().size() || index < 0) {
            System.out.println("Wrong input, check User's index  " +
                    "via \"Check list of all Users\" at the Main menu.");
        } else {
            simpleNote.getArrayList().get(index);
        }
    }
}
