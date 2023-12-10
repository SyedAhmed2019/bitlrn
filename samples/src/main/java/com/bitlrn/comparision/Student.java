package com.bitlrn.comparision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This example shows how comparable interface can be implemented in Java
 * that helps in sorting in different order than the natural order.
 */

public class Student implements Comparable<Student> {
    private final int rank;
    private final int id;

    Student(int id, int rank) {
        this.id = id;
        this.rank = rank;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, 10));
        students.add(new Student(10, 2));
        students.add(new Student(2, 6));
        students.add(new Student(3, 4));
        students.add(new Student(5, 3));
        Collections.sort(students);
        students.forEach(System.out::println);
        System.out.println("reverse order");
        Collections.sort(students, Collections.reverseOrder());
        students.forEach(System.out::println);
    }

    @Override
    public int compareTo(Student o) {
        if (this.rank < o.rank) {
            return -1;
        } else if (this.rank > o.rank) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rank=" + rank +
                ", id=" + id +
                '}';
    }

    public int getRank() {
        return rank;
    }

    public int getId() {
        return id;
    }
}
