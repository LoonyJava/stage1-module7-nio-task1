package com.epam.mjc.nio;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = "";
        Integer age = 0;
        String email = "";
        long phone = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath())))) {
            String[] nameLine = bufferedReader.readLine().split("Name: ");
            name = nameLine[1].trim();
            String[] ageLine = bufferedReader.readLine().split("Age: ");
            age = Integer.parseInt(ageLine[1].trim());
            String[] emailLine = bufferedReader.readLine().split("Email: ");
            email = emailLine[1].trim();
            String[] phoneLine = bufferedReader.readLine().split("Phone: ");
            phone = Long.parseLong(phoneLine[1].trim());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Profile(name, age, email, phone);
    }
}
