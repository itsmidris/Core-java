# Constructor Injection in Java

## What is Constructor Injection?

Constructor Injection is a type of Dependency Injection (DI) where dependencies are provided through a constructor when an object is created.

Instead of creating dependencies inside a class, they are passed from outside.

---

# Why Do We Need Constructor Injection?

Without Constructor Injection:

```java
public class Student {

    private JavaCourse course = new JavaCourse();

    public void study() {
        course.start();
    }
}
```

Problems:

* Tight Coupling
* Difficult to change dependencies
* Difficult to test
* Violates Dependency Injection principle

Student creates its own dependency.

```text
Student
   |
   +--> new JavaCourse()
```

---

# Step 1: Create Interface

## Course.java

```java
public interface Course {
    void start();
}
```

---

# Step 2: Create Implementations

## JavaCourse.java

```java
public class JavaCourse implements Course {

    @Override
    public void start() {
        System.out.println("Learning Java");
    }
}
```

## DSACourse.java

```java
public class DSACourse implements Course {

    @Override
    public void start() {
        System.out.println("Learning DSA");
    }
}
```

---

# Step 3: Constructor Injection

## Student.java

```java
public class Student {

    private Course course;

    public Student(Course course) {
        this.course = course;
    }

    public void study() {
        course.start();
    }
}
```

### Constructor

```java
public Student(Course course) {
    this.course = course;
}
```

Dependency is injected while creating the object.

---

# Step 4: Main Class

## App.java

```java
public class App {

    public static void main(String[] args) {

        Course course = new JavaCourse();

        Student student = new Student(course);

        student.study();
    }
}
```

Output:

```text
Learning Java
```

---

# Switching Dependencies

Change only one line:

```java
Course course = new DSACourse();
```

Output:

```text
Learning DSA
```

Student class remains unchanged.

---

# Object Flow

### Step 1

```java
Course course = new JavaCourse();
```

Creates JavaCourse object.

### Step 2

```java
Student student = new Student(course);
```

Passes dependency to constructor.

### Step 3

Constructor executes:

```java
this.course = course;
```

Student stores the dependency.

### Step 4

```java
student.study();
```

Calls:

```java
course.start();
```

---

# Constructor Injection vs Setter Injection

## Setter Injection

```java
Student student = new Student();

student.setCourse(course);
```

Dependency is injected after object creation.

### Problem

Developer may forget:

```java
student.setCourse(course);
```

Result:

```text
NullPointerException
```

---

## Constructor Injection

```java
Student student = new Student(course);
```

Dependency is injected during object creation.

### Advantage

Student cannot be created without Course.

This makes the object valid from the beginning.

---

# Real Life Example

## Car and Engine

### Setter Injection

```java
Car car = new Car();

car.setEngine(engine);
```

Someone may forget to set the engine.

---

### Constructor Injection

```java
Car car = new Car(engine);
```

A car cannot exist without an engine.

Therefore constructor injection is safer.

---

# Advantages of Constructor Injection

* Reduces Tight Coupling
* Makes dependencies mandatory
* Easier Unit Testing
* Prevents NullPointerException
* Promotes Immutable Design
* Most Preferred in Spring Boot

---

# Spring Boot Example

```java
@Component
public class Student {

    private final Course course;

    @Autowired
    public Student(Course course) {
        this.course = course;
    }
}
```

Spring automatically injects the dependency through the constructor.

---

# Interview Definition

Constructor Injection is a Dependency Injection technique in which dependencies are supplied through a class constructor during object creation.

Example:

```java
Student student = new Student(new JavaCourse());
```

The dependency is injected while creating the object.

---

# Memory Trick

Setter Injection:

```java
student.setCourse(course);
```

Create first → Inject later

---

Constructor Injection:

```java
Student student = new Student(course);
```

Inject while creating

---

# Key Rule

A class should focus on using dependencies, not creating dependencies.

Good Design:

```java
Student student = new Student(course);
```

Bad Design:

```java
private JavaCourse course = new JavaCourse();
```

Use dependency, don't create dependency.
