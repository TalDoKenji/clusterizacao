package org.example;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadCSV {
    @Override
    public String toString() {
        return "ReadCSV{}";
    }

    public static List<Student> readCSV(String path){
        List<Student> students = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            boolean isFirstLine = true;
            for(String line : lines){
                if(isFirstLine){
                    isFirstLine = false;
                    continue;
                }
                String[] values = line.split(",");
                String name = values[0].trim();
                Integer age = Integer.parseInt(values[1].trim());
                float average = Float.parseFloat(values[2].trim());
                float absence = Float.parseFloat(values[3].trim());
                students.add(new Student(name, age, average, absence));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}
