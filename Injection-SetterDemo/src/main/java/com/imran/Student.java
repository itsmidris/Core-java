package com.imran;

/*
public class Student {
    private JavaCourse course = new JavaCourse();

    public void study(){
        course.start();
    }
}
*/

/*public class Student {
    private Course course = new JavaCourse();
    public void study(){
        course.start();
    }
}*/

/*
Now Student depends on:

Course

instead of:

JavaCourse

This is better.

But still not Dependency Injection.

        Why?

Because Student is still creating object.

        new JavaCourse()*/
    /*------------------------------------

    Dependency Injection

    Remove object creation from Student.*/

public class Student {

    private Course course;

    public void setCourse(Course course) {
        this.course = course;
    }

    public void study(){
        course.start();
    }
}

/*
Notice:

        new JavaCourse()

is gone.*/
