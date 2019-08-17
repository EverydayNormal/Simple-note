package by.shmarlouski.java.simplenote.controller;
import java.io.IOException;

import static by.shmarlouski.java.simplenote.utils.FileWorker.writeIntoTheFile;
import static by.shmarlouski.java.simplenote.utils.FileWorker.readFromFile;

public class Main {
    public static void main(String[] args) {
    Application app = new Application();
        try {
            readFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (app.isWorking) {
            app.start();
        }
        try {
            writeIntoTheFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
