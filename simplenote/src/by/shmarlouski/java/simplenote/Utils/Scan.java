package by.shmarlouski.java.simplenote.Utils;

import java.util.Scanner;

import static by.shmarlouski.java.simplenote.view.Printer.print;

public class Scan {

    private static Scanner scanner = new Scanner(System.in);

    public static String scanText(){
        return scanner.nextLine();
    }

    public static int scanNumber() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                print("Incorrect number input! Try again!\n");
            }
        }
    }

}
