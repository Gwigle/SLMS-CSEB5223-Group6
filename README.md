# Student Learning Management System (SLMS)

Please refer to the SLMS-CSEB5223-Group6-(Version4).pdf report in the /docs folder of this repository for detailed documentation.

The **Student Learning Management System (SLMS)** is a console-based Java application developed for the *Software Construction & Methods (CSEB5223)* course. It allows administrators to efficiently manage students, courses and their relationships using a structured menu-driven interface.

---

## Introduction

The SLMS system provides functionality to manage:

- Students  
- Courses  
- Student–Course enrollments
- Cache API

It supports operations such as input, search, edit, delete and display in a modular and organized structure.

---

## Project Information

| Item | Description |
|------|-------------|
| Course | Software Construction & Methods |
| Course Code | CSEB5223 |
| Semester | Semester 2 2025/2026 |
| Programme | Bachelor of Software Engineering (Hons.) |
| Lecturer | TS. DR. Loo Yim Ling |

---

## Group Members

| Name | Student ID |
|------|------------|
| Arifah Nur Iman Binti Mohd Fadzilah | BSW01085214 |
| Reyhana Marsya Binti Ahmad Saifullizan | BSW01085069 |
| Deshini A/P Selvakumar | SW01083593 |
| Patvir Singh Khosa | BSW01085393 |

---

## Features

### Course Management
- Add Course  
- Search Course  
- Edit Course  
- Delete Course  
- View All Courses  

### Student Management
- Add Student  
- Search Student  
- Edit Student  
- Delete Student  
- View All Students  

### Enrollment Management
- Assign Student to Course  
- List Courses of a Student  
- List Students of a Course  

---

## System Architecture

The system follows a modular Object-Oriented Architecture:


Main
│
└── SLMSManager (refactored into managers)
├── CourseManager
├── StudentManager
├── RelationshipManager
└── SearchCacheManager (API Middleware)


---

## Main Components

| Class | Responsibility |
|------|----------------|
| Course | Stores course information |
| Student | Stores student information |
| CourseManager | Handles course operations |
| StudentManager | Handles student operations |
| RelationshipManager | Handles enrollment logic |
| CacheAPI | Handles caching & auto-suggestions |
| Main | Runs the program |

---

## Course Class

### Attributes
- courseCode  
- courseName  
- creditHour  
- summary  
- teamsLink  
- courseType

---

### Display Method

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

---

## Student Class

### Attributes

- studentId
- studentName
- email
- phone

### Display Method

public void displayStudent() {
    System.out.println("--------------------------------");
    System.out.println("Student ID   : " + studentId);
    System.out.println("Student Name : " + studentName);
    System.out.println("Email        : " + email);
    System.out.println("Phone        : " + phone);
    System.out.println("--------------------------------");
}

---

## Enrollment Module

### Relationship Storage

boolean[][] relationship = new boolean[100][100];
Example
relationship[studentIndex][courseIndex] = true;

---

## Data Storage Design


Course[] courses = new Course[100];
Student[] students = new Student[100];
boolean[][] relationship = new boolean[100][100];

### Maximum Capacity

| Data | Limit |
|------|----------------|
| Courses |	100 |
| Students |	100 |
| Enrollments	| 100 × 100 |

---

## Naming Conventions


| Element |	Format |	Example |
|------|----------------|----------------|
| Class |	PascalCase |	Course |
| Method | camelCase |	addCourse() |
| Variable| camelCase	| studentName |
| Constant |	UPPER_CASE |	MAX_SIZE |

---

## Project Structure


SLMS
│
├── test
├── docs
│   ├── SLMS-CSEB5223-Group6.docx
│   ├── SLMS-CSEB5223-Group6-(Version2).pdf
│   ├── SLMS-CSEB5223-Group6-(Version3).pdf
│   ├── SLMS-CSEB5223-Group6-(Version4).pdf
│   ├── README.md
│
├── src
│   ├── Course.java
│   ├── Student.java
│   ├── CourseManager.java
│   ├── StudentManager.java
│   ├── RelationshipManager.java
│   ├── CacheAPI.java
│   ├── Main.java
│   ├── README.md
│
├── README.md


---

## Modularity Benefits

- Maintainability
- Reusability
- Readability
- Scalability
- Team collaboration

---

## References

- https://github.com/moodle/moodle
- https://moodledev.io
- https://sourcemaking.com
- https://draw.io
- https://gitbybit.com
