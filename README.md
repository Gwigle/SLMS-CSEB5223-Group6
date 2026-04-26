# Student Learning Management System (SLMS)

## Project Overview

The **Student Learning Management System (SLMS)** is a console-based Java application developed for the **Software Construction & Methods (CSEB5223)** course.

This system provides a centralized platform for administrators to manage:
- Courses  
- Students  
- Student–Course Enrollments  

The system is built using **Object-Oriented Programming (OOP)** principles, emphasizing:
- Modularity
- Maintainability
- Reusability
- Data integrity

Full Documentation:  
`/docs/SLMS-CSEB5223-Group6-(Final Report).docx`

---

## Objectives

- Design and implement a **modular system architecture**
- Apply **OOP principles** (Encapsulation, Abstraction)
- Implement **full CRUD operations**
- Model **many-to-many relationships**
- Develop a **middleware API (Search Cache)**
- Apply **defensive programming & validation**
- Perform **system testing and integration**
- Follow **coding standards and CI practices**

---

## Project Information

| Item | Description |
|------|-------------|
| Course | Software Construction & Methods |
| Course Code | CSEB5223 |
| Semester | Semester 2 2025/2026 |
| Programme | Bachelor of Software Engineering (Hons.) |
| Lecturer | Ts. Dr. Loo Yim Ling |

---

## Group Members

| Name | Student ID |
|------|------------|
| Arifah Nur Iman Binti Mohd Fadzilah | BSW01085214 |
| Reyhana Marsya Binti Ahmad Saifullizan | BSW01085069 |
| Deshini A/P Selvakumar | SW01083593 |
| Patvir Singh Khosa | BSW01085393 |

---

## System Architecture

```text
Main
│
├── CourseManager
├── StudentManager
├── RelationshipManager
└── SearchCacheManager (Middleware API)
```

### Architectural Justification

- **Separation of Concerns**
  - Each manager handles a specific responsibility

- **Low Coupling**
  - Classes interact through controlled interfaces

- **High Cohesion**
  - Each class focuses on one well-defined task

- **Scalability**
  - Easy to extend with new modules (e.g., GUI, database)

---

## System Modules

### 1. Course Management
- Add Course
- Search Course (Linear Search)
- Edit Course (excluding courseCode)
- Delete Course (with confirmation)
- View All Courses

### 2. Student Management
- Add Student
- Search Student
- Edit Student (excluding studentID)
- Delete Student
- View All Students

### 3. Relationship Management
- Assign Student to Course
- List Courses of a Student
- List Students of a Course

### 4. Middleware API (SearchCacheManager)
- Cache recent searches
- Suggest matching inputs
- Case-insensitive search

---

## Data Structure Design

```java
Course[] courses = new Course[100];
Student[] students = new Student[100];
boolean[][] relationship = new boolean[100][100];
```

### Design Justification

- **Array-based storage**
  - Simple and efficient for fixed-size systems

- **2D Boolean Matrix**
  - Represents many-to-many relationships

- **Validation mechanisms**
  - Prevent overflow
  - Avoid duplicate entries
  - Ensure valid indexing

---

## Relationship Design

- Each row → Student  
- Each column → Course  
- `true` → enrolled  
- `false` → not enrolled  

### Advantages
- Fast lookup
- Easy relationship tracking
- Prevents duplicate assignments

---

## Middleware API Design

### SearchCacheManager

| Feature | Description |
|--------|------------|
| cacheCourseSearch() | Stores course searches |
| cacheStudentSearch() | Stores student searches |
| suggestCourses() | Suggests course codes |
| suggestStudents() | Suggests student IDs |

### Benefits
- Reduces repetitive input
- Improves user efficiency
- Simulates real-world API behavior

---

## Implementation Details

### Input Validation
- Duplicate checking (course & student)
- Credit hour validation (positive integers only)
- Course type validation (core/elective/university)
- Case-insensitive input handling

### Defensive Programming
- Try-catch for invalid inputs
- Boundary checking for arrays
- Null checks for search results

### Reusability
- `displayCourse()` reused across modules
- `displayStudent()` reused across modules
- Search methods reused in edit/delete

---

## Testing Strategy

### Unit Testing
- Each method tested independently

### Integration Testing
- Verified interaction between:
  - CourseManager
  - StudentManager
  - RelationshipManager
  - SearchCacheManager

### Scenario-Based Testing

| Scenario | Description |
|----------|------------|
| Course Flow | Add → Edit → Delete |
| Student Flow | Add → Search → Update |
| Relationship | Assign and retrieve |
| API | Cache and suggestion |
| Error Cases | Invalid input handling |

### Testing Outcomes
- Correct functionality for all modules
- Stable under invalid inputs
- Proper error messages displayed

---

## How to Run the System

### Requirements
- Java JDK 8 or above
- Command Prompt / Terminal

### ▶️ Steps

1. Clone repository:
```bash
git clone https://github.com/Gwigle/SLMS-CSEB5223-Group6.git
```

2. Navigate to source folder:
```bash
cd SLMS/src
```

3. Compile:
```bash
javac *.java
```

4. Run:
```bash
java Main
```

---

## Sample Output

```text
===== SLMS MENU =====
1. Add Course
2. View Courses
3. Search Course
4. Add Student
5. View Students
6. Assign Student to Course
0. Exit
```

---

## Continuous Integration (CI)

### Practices
- Feature-based branching
- Pull Request workflow
- Code review before merge

### Commit Format
```text
[Module] Description
```

Example:
```text
[Course] Add validation for credit hour
```

### Benefits
- Improves code quality
- Detects errors early
- Enhances team collaboration

---

## Coding Standards

| Element | Convention |
|--------|------------|
| Class | PascalCase |
| Method | camelCase |
| Variable | camelCase |
| Constant | UPPER_CASE |

---

## Project Structure

```text
SLMS
│
├── docs
│   ├── SLMS-CSEB5223-Group6.docx
│   ├── SLMS-CSEB5223-Group6-(Version2).pdf
│   ├── SLMS-CSEB5223-Group6-(Version3).pdf
│   ├── SLMS-CSEB5223-Group6-(Version4).pdf
│   ├── SLMS-CSEB5223-Group6-(Final Report).pdf
│   └── README.md
│
├── src
│   ├── Course.java
│   ├── Student.java
│   ├── CourseManager.java
│   ├── StudentManager.java
│   ├── RelationshipManager.java
│   ├── SearchCacheManager.java
│   ├── Main.java
│   └── README.md
│
└── README.md
```

---

## Key Strengths

- Strong OOP design
- Modular architecture
- Complete CRUD implementation
- Efficient relationship handling
- Middleware API integration
- Robust validation & error handling
- Comprehensive testing strategy
- CI and coding standards applied

---

## Challenges & Solutions

| Challenge | Solution |
|----------|--------|
| Requirement changes | Modular design |
| Data consistency | Validation & matrix updates |
| Array shifting after deletion | Controlled shifting logic |
| Invalid inputs | Try-catch + validation loops |

---

## Future Improvements

- GUI implementation (JavaFX / Web)
- Database integration (MySQL)
- User authentication system
- Role-based access control
- REST API integration

---

## Conclusion

The SLMS project successfully demonstrates:

- Application of **software construction principles**
- Implementation of **modular and scalable design**
- Integration of **validation, testing, and middleware API**

The system is:
- Reliable  
- Maintainable  
- Scalable  

and ready for future enhancement into a full-scale system.

---

## References

- https://github.com/moodle/moodle  
- https://moodledev.io  
- https://sourcemaking.com  
- https://draw.io  
- https://gitbybit.com  
