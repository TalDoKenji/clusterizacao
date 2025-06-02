package org.example;

import java.util.Comparator;
import java.util.List;

public class Student {

    private Integer age;

    private double average;

    private double abscense;

    public Student(Integer age, double average, double abscense) {
        this.age = age;
        this.average = average;
        this.abscense = abscense;
    }

    public void distanceEuclidienne(Student student, List<Cluster> clusters) {
        Cluster cluster = clusters.stream()
                .min(Comparator.comparingDouble(c -> c.calculatedDistance(student, c.getCentroid())))
                .orElseThrow();

        System.out.println("cluster mais proximo: " + cluster);
        cluster.addStudent(student);
    }

    public Integer getAge() {
        return age;
    }

    public double getAverage() {
        return average;
    }

    public double getAbscense() {
        return abscense;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", average=" + average +
                ", abscense=" + abscense +
                '}';
    }
}
