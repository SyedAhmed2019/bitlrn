package com.bitlrn.hacker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HrPriorityQueue {

    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    /*
     * Create the Student and Priorities classes here.
     */
    static class Student implements Comparable<Student>{
        private final int id;
        private final String name;
        private final double cgpa;

        Student(int id,String name, double cgpa){
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        public int compareTo(Student other){
            if (this.getCGPA() == other.getCGPA()){
                if (this.name.compareTo(other.getName())==0){
                    if( this.id > other.id){
                        return -1;
                    }else if (this.id <= other.id){
                        return 1;
                    }else{
                        return 0;
                    }
                }else{
                    if(this.name.compareTo(other.getName()) > 0){
                        return -1;
                    }else{
                        return 1;
                    }
                }
            }else if(this.getCGPA()>other.getCGPA()){
                return - 1;
            }else{
                return 1;
            }
        }

        public int getID(){
            return this.id;
        }

        public String getName(){
            return this.name;
        }

        public double getCGPA(){
            return this.cgpa;
        }

    }

    static class Priorities{
        private static final String ENTER = "ENTER";
        private static final String SERVED = "SERVED";
        public List<Student> getStudents(List<String> events){
            List<Student> results = new ArrayList<>();
            for (String event:events){
                String[] studentDetails = event.trim().split(" ");
                String eventName = studentDetails[0].trim();

                if (eventName.equalsIgnoreCase(ENTER)){
                    String studentName = studentDetails[1].trim();
                    String studentCgpa = studentDetails[2].trim();
                    String studentId = studentDetails[3].trim();
                    Student student = new Student(Integer.parseInt(studentId),studentName,Double.valueOf(studentCgpa));
                    if(!results.isEmpty()){
                        boolean add = false;
                        for (int i=0; i < results.size(); ++i){
                            if (results.get(i).compareTo(student)==1){
                                continue;
                            }
                            results.add(i,student);
                            add = true;
                            break;
                        }
                        if (!add){
                            results.add(student);
                        }
                    }else{
                        results.add(student);
                    }
                }else if (eventName.equalsIgnoreCase(SERVED)){
                    if (!results.isEmpty()){
                        results.remove(0);
                    }
                }
            }
            return results;
        }
    }

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
