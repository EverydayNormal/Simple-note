package by.shmarlouski.java.simplenote.utils;


import by.shmarlouski.java.simplenote.model.Role;
import by.shmarlouski.java.simplenote.model.SimpleNote;
import by.shmarlouski.java.simplenote.model.User;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static by.shmarlouski.java.simplenote.view.Printer.print;

public class FileWorker {

    private static SimpleNote simpleNote = SimpleNote.getInstance();

    private static File file = new File("files\\file.txt");

    private static User convertUserFromData(String[] data) {

        User user = new User();

        user.setName(data[0]);
        user.setSecondName(data[1]);
        user.setEmail(data[2]);
        user.setRole(Role.valueOf(data[3].trim()));

        for (int i = 4; i < data.length; i++) {
            user.setPhoneNumber(data[i]);
        }

        return user;
    }

    public static void writeIntoTheFile() throws IOException {

        String data = simpleNote.toString();

        FileWriter writer = new FileWriter(file);

        writer.write(data);

        writer.close();
    }

    public static void readFromFile() throws IOException {

        ArrayList<User> listFromFile = new ArrayList<>();

        if (!file.exists()) {
            print("File not found.");
        } else {

            FileReader reader = new FileReader(file);

            Scanner scanner = new Scanner(reader);
            try {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] userData = line.split(",");
                    User user = convertUserFromData(userData);
                    listFromFile.add(user);
                }
                simpleNote.getArrayList().addAll(listFromFile);
            }catch (Exception e){
                print("File is empty or has wrong format!");
                print("If it holds something precious to You" +
                        " move it \nto another package before exit this app!");
            }
        }
    }
}
