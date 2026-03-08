# Student Learning Management System (SLMS)
Please refer to the SLMS-CSEB5223-Group6-(Version2).pdf report in the /docs folder of this repository for detailed documentation.

Our project is **console-based Java application** that manages **students, courses and enrollments** using Object-Oriented Programming principles.

This project was developed for the **Software Construction & Methods (CSEB5223)** course to demonstrate **OOP concepts, array-based data storage, and system modularity**.

The system allows administrators to manage courses and students through a **menu-driven interface**.

---

#  Table of Contents

* [Introduction]
* [Project Information]
* [Group Members]
* [Features]
* [System Architecture]
* [Class Design]
* [Course Module]
* [Student Module]
* [Enrollment Module]
* [Data Storage Design]
* [Project Structure]
* [Example Output]
* [References]

---

#  Introduction

The **Student Learning Management System (SLMS)** is a Java console application designed to manage academic course and student information.

The system demonstrates important **software engineering and object-oriented design principles**, including:

* Encapsulation
* Modularity
* Reusability
* Low coupling
* High cohesion

The system allows administrators to:

* Manage course records
* Manage student records
* Assign students to courses
* Display course and student information

---

#  Project Information

| Item        | Description                              |
| ----------- | ---------------------------------------- |
| Course      | Software Construction & Methods          |
| Course Code | CSEB5223                                 |
| Semester    | Semester 2 2025/2026                     |
| Programme   | Bachelor of Software Engineering (Hons.) |
| Lecturer    | TS. DR. Loo Yim Ling                     |

---

#  Group Members

| Name                                   | Student ID  |
| -------------------------------------- | ----------- |
| Arifah Nur Iman Binti Mohd Fadzilah    | BSW01085214 |
| Reyhana Marsya Binti Ahmad Saifullizan | BSW01085069 |
| Deshini A/P Selvakumar                 | SW01083593  |
| Patvir Singh Khosa                     | BSW01085393 |

---

#  Features

## Course Management

* Add Course
* Search Course
* Edit Course
* Delete Course
* View All Courses

## Student Management

* Add Student
* Search Student
* Edit Student
* Delete Student
* View All Students

## Enrollment Management

* Assign Student to Course
* List Courses of Student
* List Students of Course

---

#  System Architecture

The system follows a **modular Object-Oriented Architecture**.

```
Main
  |
  v
SLMSManager
   |-------- Course
   |
   |-------- Student
```

### Main Components

| Class         | Responsibility             |
| ------------- | -------------------------- |
| `Course`      | Stores course information  |
| `Student`     | Stores student information |
| `SLMSManager` | Manages system operations  |
| `Main`        | Runs the program           |

---

#  Class Design

## Course Class

The **Course class** represents a course object.

### Attributes

```java
private String courseCode;
private String courseName;
private int creditHour;
private String summary;
private String teamsLink;
private String courseType;
```

### Constructor

```java
public Course(String code, String name, int credit,
              String summary, String link, String type) {

    this.courseCode = code;
    this.courseName = name;
    this.creditHour = credit;
    this.summary = summary;
    this.teamsLink = link;
    this.courseType = type;

}
```

### Display Method

```java
public void displayCourse() {

    System.out.println("==================================");
    System.out.printf("Course Code : %s%n", courseCode);
    System.out.printf("Course Name : %s%n", courseName);
    System.out.printf("Credit Hour : %d%n", creditHour);
    System.out.printf("Summary     : %s%n", summary);
    System.out.printf("Teams Link  : %s%n", teamsLink);
    System.out.printf("Type        : %s%n", courseType);
    System.out.println("==================================");

}
```

---

## Student Class

The **Student class** stores student information.

### Attributes

```java
private String studentId;
private String studentName;
private String email;
private String phone;
```

### Constructor

```java
public Student(String id, String name, String email, String phone) {

    this.studentId = id;
    this.studentName = name;
    this.email = email;
    this.phone = phone;

}
```

### Display Method

```java
public void displayStudent() {

    System.out.println("--------------------------------");
    System.out.println("Student ID   : " + studentId);
    System.out.println("Student Name : " + studentName);
    System.out.println("Email        : " + email);
    System.out.println("Phone        : " + phone);
    System.out.println("--------------------------------");

}
```

---

#  Course Module

### Add Course

```java
public void addCourse() {

    System.out.print("Enter Course Code: ");
    String code = sc.nextLine();

    System.out.print("Enter Course Name: ");
    String name = sc.nextLine();

    System.out.print("Enter Credit Hour: ");
    int credit = Integer.parseInt(sc.nextLine());

    System.out.print("Enter Summary: ");
    String summary = sc.nextLine();

    System.out.print("Enter Teams Link: ");
    String link = sc.nextLine();

    System.out.print("Enter Course Type: ");
    String type = sc.nextLine();

    courses[courseCount] =
            new Course(code, name, credit, summary, link, type);

    courseCount++;

}
```

---

### Search Course (Linear Search)

```java
public int searchCourse(String code) {

    for(int i = 0; i < courseCount; i++) {

        if(courses[i].getCourseCode().equalsIgnoreCase(code)) {
            return i;
        }

    }

    return -1;

}
```

---

### Edit Course

```java
public void editCourse() {

    System.out.print("Enter course code: ");
    String code = sc.nextLine();

    int index = searchCourse(code);

    if(index == -1) {
        System.out.println("Course not found!");
        return;
    }

    System.out.print("Enter new course name: ");
    courses[index].setCourseName(sc.nextLine());

}
```

---

### Delete Course

```java
public void deleteCourse() {

    System.out.print("Enter course code to delete: ");
    String code = sc.nextLine();

    int index = searchCourse(code);

    if(index == -1) {
        System.out.println("Course not found!");
        return;
    }

    for(int i = index; i < courseCount - 1; i++) {
        courses[i] = courses[i + 1];
    }

    courseCount--;

}
```

---

#  Student Module

Student operations include:

* Add Student
* Search Student
* Edit Student
* Delete Student
* View All Students

Example:

```java
public void viewAllStudents(){

    for(int i = 0; i < studentCount; i++){
        students[i].displayStudent();
    }

}
```

---

#  Enrollment Module

Students can be assigned to courses using a **relationship matrix**.

```java
boolean[][] relationship = new boolean[100][100];
```

Example:

```java
relationship[studentIndex][courseIndex] = true;
```

This indicates that the **student is enrolled in the course**.

---

#  Data Storage Design

The system uses **array-based storage**.

```java
Course[] courses = new Course[100];
Student[] students = new Student[100];
boolean[][] relationship = new boolean[100][100];
```

### Maximum Capacity

| Data        | Maximum   |
| ----------- | --------- |
| Courses     | 100       |
| Students    | 100       |
| Enrollments | 100 × 100 |

---

#  Project Structure

```
SLMS
│
├── tests
│   └── README.md
├── docs
│   ├── SLMS-CSEB5223-Group6.docx
│   ├── SLMS-CSEB5223-Group6-(Version2).pdf
│   └──README.md
├── src
│   ├── Course.java
│   ├── Student.java
│   ├── SLMSManager.java
│   ├── Main.java
│   └── README.md
│
├── README.md
```

---

#  Example Output

```
===== SLMS MENU =====

1. Add Course
2. Search Course
3. Edit Course
4. Delete Course
5. View All Courses
6. Add Student
7. View All Students
8. Exit

Enter option: 1

Enter Course Code: CSEB5223
Enter Course Name: Software Construction & Methods
Enter Credit Hour: 3
Enter Summary: Practice coding and build SLMS project.
Enter Teams Link: https://teams.microsoft.com/...
Enter Course Type: core

Course added successfully!
```

---

#  References

* [https://github.com/moodle/moodle](https://github.com/moodle/moodle)
* [https://moodledev.io](https://moodledev.io)
* [https://sourcemaking.com](https://sourcemaking.com)
* [https://gitbybit.com](https://gitbybit.com)
* [https://draw.io](https://draw.io)

---
