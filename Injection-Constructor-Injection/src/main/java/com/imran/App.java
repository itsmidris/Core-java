package com.imran;

public class App {
    public static void main( String[] args ) {

        Course course1 = new JavaCourse();
        Student student1 = new Student(course1);
        student1.study();

        Course course2 = new DSACourse();
        Student student2 = new Student(course2);
        student2.study();

    }
}
