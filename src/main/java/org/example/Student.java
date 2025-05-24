package org.example;

public class Student {

    private String name;
    private Integer age;
    private float average;
    private float absence;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", average=" + average +
                ", absence=" + absence +
                '}';
    }

    public Student(String name, Integer age, float average, float absence) {
        this.name = name;
        this.age = age;
        this.average = average;
        this.absence = absence;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public float getAverage() {
        return average;
    }

    public float getAbsence() {
        return absence;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public void setAbsence(float absence) {
        this.absence = absence;
    }
}

