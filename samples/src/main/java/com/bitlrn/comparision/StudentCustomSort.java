package com.bitlrn.comparision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentCustomSort {

    public static void main(String[] args) {
        StudentIdComparator idComparator = new StudentIdComparator();
        StudentRankComparator rankComparator = new StudentRankComparator();
        List<Student> studentCustomSortList = new ArrayList<>();
        studentCustomSortList.add(new Student(1, 100));
        studentCustomSortList.add(new Student(2, 1));
        studentCustomSortList.add(new Student(3, 5));
        studentCustomSortList.add(new Student(10, 2));
        studentCustomSortList.add(new Student(7, 25));
        System.out.println("Before sorting ");
        studentCustomSortList.forEach(System.out::println);
        System.out.println("After sorting using natural order based on comparable interface");
        Collections.sort(studentCustomSortList);
        studentCustomSortList.forEach(System.out::println);
        System.out.println("After sorting using  id  - based on comparator usage");
        studentCustomSortList.sort(new StudentIdComparator());
        studentCustomSortList.forEach(System.out::println);
        System.out.println("After sorting using rank -  based on comparator usage");
        studentCustomSortList.sort(new StudentRankComparator());
        studentCustomSortList.forEach(System.out::println);

        // java 8 approach
        System.out.println("After sorting using rank reversed - using lambda comparator");
        Comparator<Student> rankLambdaComparator = Student::compareTo;
        studentCustomSortList.sort(rankLambdaComparator.reversed());
        studentCustomSortList.forEach(System.out::println);

    }

    static class StudentRankComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.compareTo(o2);
        }
    }

    static class StudentIdComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if (o1.getId() < o2.getId()) {
                return -1;
            } else if (o1.getId() > o2.getId()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
