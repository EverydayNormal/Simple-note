package by.shmarlouski.java.simplenote.controller;

import static by.shmarlouski.java.simplenote.Utils.Scan.scanNumber;
import static by.shmarlouski.java.simplenote.view.Printer.print;


public class Application {

    public boolean isWorking = true;

    private SimpleNoteController controller = new SimpleNoteController();

    public void start() {
        print("---------- Main menu ----------");
        print("Choose action:");
        print("1 - Create new User.");
        print("2 - Change User's data");
        print("3 - Delete User.");
        print("4 - Check list of all Users.");
        print("5 - Check User's data.");
        print("6 - Exit.");

        switch (scanNumber()) {
            case 1:
                controller.createUser();
                break;
            case 2:
                controller.changeUser();
                break;
            case 3:
                controller.deleteUser();
                break;
            case 4:
                controller.displaySimpleNote();
                break;
            case 5:
                controller.displayUser();
                break;
            case 6:
                isWorking = false;
                break;
            default:
                print("There is no such action!\n");
                break;
        }
    }
}
