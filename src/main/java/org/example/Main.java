package org.example;
import java.util.List;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Student> students = ReadCSV.readCSV("C:/Users/vinic/IdeaProjects/clusterizacao/src/main/java/org/example/fileStudents.csv");

        Cluster cluster = new Cluster(students);
        Student novoStudent = new Student("Fernanda", 20, 7.0f, 0);
        Student novoStudent2 = new Student("Jean", 17, 8.0f, 0.1f);
        cluster.addStudent(novoStudent);
        cluster.addStudent(novoStudent2);
        cluster.printCluster();

    }
}