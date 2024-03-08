package org.example;

import java.io.*;
public class Task1 {
    public static void main(String[] args) {
        String fileName = "file.txt";
        createFileWithPhoneNumbers(fileName);
        printValidPhoneNumbers(fileName);
    }

    public static void createFileWithPhoneNumbers(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("987-123-4567\n");
            writer.write("123 456 7890\n");
            writer.write("12-345-678-90\n");
            writer.write("1-444-56-7760\n");
            writer.write("1284-5667-290\n");
            writer.write("(123) 456-7890\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printValidPhoneNumbers(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isValidPhoneNumber(line)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Перевірка чи номер відповідає одному з двох форматів
        return phoneNumber.matches("\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}");
    }
}
