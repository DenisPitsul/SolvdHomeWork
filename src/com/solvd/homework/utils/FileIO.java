package com.solvd.homework.utils;

import java.io.*;

public class FileIO {

    public static void writeToFile(String path, String value) {
        File file = new File(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(value);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(String path) {
        File file = new File(path);
        try {
            if (file.createNewFile())
                System.out.println(path + " has created!");
            else
                System.out.println(path + " already exists.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void clearFile(String path) {
        File file = new File(path);
        try ( PrintWriter writer = new PrintWriter(file);) {
            writer.print("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
