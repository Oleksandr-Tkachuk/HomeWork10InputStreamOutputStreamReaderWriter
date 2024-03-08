package task2;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFile = "file2.txt";
        String outputFile = "user.json";

        List<User> userList = readUsersFromFile(inputFile);
        writeUsersToJsonFile(userList, outputFile);
    }

    public static List<User> readUsersFromFile(String fileName) {
        List<User> userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            String[] headers = reader.readLine().split("\\s+");
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\s+");

                User user = new User(data[0], Integer.parseInt(data[1]));
                userList.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static void writeUsersToJsonFile(List<User> userList, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Gson gson = new Gson();

            writer.write(gson.toJson(userList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}