package com.imran;

/*
public class App {
    public static void main(String[] args) {
        Student student = new Student();

        student.study();
    }
}
*/


public class App {

    public static void main(String[] args) {
        Student student = new Student();
        Course course = new JavaCourse();
        student.setCourse(course);
        student.study();
        System.out.println("Student 1 is Learning Java");


        Student student1 = new Student();
        Course course1 = new DSACourse();
        student1.setCourse(course1);
        student1.study();
        System.out.println("Student 1 is Learning DSA");
    }
}