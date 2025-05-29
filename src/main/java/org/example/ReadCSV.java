package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {

    public static List<Student> readCSV(String path) {
        List<Student> students = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            boolean isFirstLine = true;
            for (String line : lines) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] values = line.split(",");
                String name = values[0].trim();
                Integer age = Integer.parseInt(values[1].trim());
                double average = Float.parseFloat(values[2].trim());
                double absence = Float.parseFloat(values[3].trim());
                Student student = new Student(name, age, average, absence);
                students.add(student);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public String toString() {
        return "ReadCSV{}";
    }
}
