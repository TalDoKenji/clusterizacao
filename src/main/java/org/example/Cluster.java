package org.example;

import java.util.List;

public class Cluster {

    private Student centroid;

    private final List<Student> students;

    public Cluster(Student centroid, List<Student> students) {
        this.centroid = centroid;
        this.students = students;
    }

    public void recalcuteCentroid(List<Student> students) {
        int size = students.size();
        Student sum = students.stream()
                .reduce(
                        new Student(0, 0.0, 0.0),
                        (acc, current) -> new Student(
                                acc.getAge() + current.getAge(),
                                acc.getAverage() + current.getAverage(),
                                acc.getAbscense() + current.getAbscense()
                        )
                );
        this.centroid = new Student(
                sum.getAge()/size,
                sum.getAverage()/size,
                sum.getAbscense()/size
        );
    }

    public void addStudent(Student newStudent) {
        this.students.add(newStudent);
        recalcuteCentroid(students);
    }

    public double calculatedDistance(Student student, Student centroid) {
        double sum = 0;
        sum += Math.pow(student.getAge() - centroid.getAge(), 2);
        sum += Math.pow(student.getAverage() - centroid.getAverage(), 2);
        sum += Math.pow(student.getAbscense() - centroid.getAbscense(), 2);

        return Math.sqrt(sum);
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getCentroid() {
        return centroid;
    }

    @Override
    public String toString() {
        return "Cluster{" +
                "centroid=" + centroid +
                ", students=" + students +
                '}';
    }
}
