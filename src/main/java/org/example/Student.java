package org.example;

public class Student {

    private String name;
    private Integer age;
    private double average;
    private double absence;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", average=" + average +
                ", absence=" + absence +
                '}';
    }

    public Student(String name, Integer age, double average, double absence) {
        this.name = name;
        this.age = age;
        this.average = average;
        this.absence = absence;
    }

    public double[] toVector() {
        return new double[] {
                age,
                average,
                absence
        };
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public double getAverage() {
        return average;
    }

    public double getAbsence() {
        return absence;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public void setAbsence(double absence) {
        this.absence = absence;
    }


}

