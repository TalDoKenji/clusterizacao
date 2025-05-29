package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


public class Cluster {

    private final List<double[]> centroids = new ArrayList<>();

    private final List<List<Student>> clusters = new ArrayList<>();

    public Cluster(List<Student> students) {
        int sizeClusters = 2;
        for (int i = 0; i < sizeClusters; i++) {
            Student student = students.get(i);
            clusters.add(new ArrayList<>(List.of(student)));
            centroids.add(student.toVector());
        }
    }

    public void addStudent(Student newStudent) {
        double[] vectorStudent = newStudent.toVector();
        double minDistace = Double.MAX_VALUE;
        int indexCluster = -1;
         for (int i = 0; i < centroids.size(); i++) {
            double distance = calculated(vectorStudent, centroids.get(i));
            if (distance < minDistace) {
                minDistace = distance;
                indexCluster = i;
            }
        }
        clusters.get(indexCluster).add(newStudent);
        updateCentroid(indexCluster);
    }

    private void updateCentroid(int clusterIndex) {
        List<Student> students = clusters.get(clusterIndex);
        int size = students.getFirst().toVector().length;

        double[] newAvg = students.stream()
                .map(Student::toVector)
                .reduce(new double[size], (accumulator, vector) -> {
                    for (int i = 0; i < size; i++) {
                        accumulator[i] += vector[i];
                    }
                    return accumulator;
                });

        for (int i = 0; i < size; i++) {
            newAvg[i] /= students.size();
        }

        centroids.set(clusterIndex, newAvg);
    }

    public double calculated(double[] cluster, double[] newStudent) {
        double sum = 0;
        for (int i = 0; i < cluster.length; i++) {
            sum += Math.pow(cluster[i] - newStudent[i], 2);
        }
        return Math.sqrt(sum);
    }

    public void printCluster() {
        IntStream.range(0, clusters.size()).forEach(i -> {
            System.out.println("Cluster " + i + ":");

            clusters.get(i).forEach(aluno ->
                    System.out.println("  " + aluno)
            );

            System.out.println("Centróide: " + formatVector(centroids.get(i)));
            System.out.println("-------------------------");
        });
    }

    private String formatVector(double[] vetor){
        return String.format("[idade=%.1f, media=%.1f, faltas=%.1f]", vetor[0], vetor[1], vetor[2]);
    }

    @Override
    public String toString() {
        return "Cluster{" +
                "centroide=" + centroids +
                ", clusters=" + clusters +
                '}';
    }
}
