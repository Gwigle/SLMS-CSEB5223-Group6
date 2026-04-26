# Student Learning Management System (SLMS)

## src Folder Structure
This src folder contains all Java source code files for the Student Learning Management System (SLMS) project.


src/
│── Course.java
│── Student.java
│── CourseManager.java
│── StudentManager.java
│── RelationshipManager.java
│── CacheAPI.java
│── Main.java


---

## File Descriptions

### Course.java
Represents a course with attributes:
- Course code  
- Course name  
- Credit hour  
- Summary  
- Microsoft Teams link  
- Course type (core / elective /university)

---

### Student.java
Represents a student with attributes:
- Student ID  
- Student name  
- Email  
- Phone number  

---

### CourseManager.java
Handles all **course-related operations**:
- Add course  
- View all courses  
- Search course  
- Edit course  
- Delete course  

Includes validation such as:
- Prevent duplicate course codes  
- Ensure valid credit hours  
- Validate course type  

---

### StudentManager.java
Handles all **student-related operations**:
- Add student  
- View all students  
- Search student  
- Edit student  
- Delete student  

Includes validation such as:
- Prevent duplicate student IDs  

---

### RelationshipManager.java
Manages **course–student relationships** using a 2D boolean array.

Functions include:
- Assign student to course  
- List courses of a student  
- List students of a course  

Includes error handling:
- Student or course not found  
- Duplicate assignment prevention  
- No course assigned / no student enrolled  

---

### SearchCacheManager.java (Middleware API)
Simulates a simple **middleware API** to improve usability.

Features:
- Cache recent inputs (student ID, course code)  
- Provide auto-suggestions  
- Reduce repeated typing  

---

### Main.java
Entry point of the application.

Responsibilities:
- Display menu  
- Handle user input  
- Integrate all manager classes  
- Connect system with CacheAPI  

---

## Features

### Course Management
- Add Course  
- View All Courses  
- Search Course  
- Edit Course  
- Delete Course  

---

### Student Management
- Add Student  
- View All Students  
- Search Student  
- Edit Student  
- Delete Student  

---

### Enrollment Management 
- Assign Student to Course  
- List Courses of a Student  
- List Students of a Course  

---

### Middleware API 
- Cache user input  
- Auto-suggestion for:
  - Student ID  
  - Course Code  
- Improves user experience and efficiency  

---

## System Design

- Object-Oriented Programming (OOP)
- Separation of concerns using:
  - CourseManager  
  - StudentManager  
  - RelationshipManager  
- Encapsulation using private attributes and getters/setters  
- Fixed-size arrays (max 100 students & 100 courses)  
- 2D boolean matrix for many-to-many relationships  
- Simple API simulation using CacheAPI  
- In-memory storage (no database)  
- Preloaded sample data for testing  
