package com.imran;

public class Student {

    /*private JavaCourse course = new JavaCourse();

    public void study(){
        course.start();
    }*/
    /*com.imran.Student creates the dependency himself.

            com.imran.Student
            |
           +--> new JavaCourse()

    This is tight coupling.*/

    private Course course;

    public Student(Course course) {
        this.course = course;
    }

    public void study(){
        course.start();
    }
}
