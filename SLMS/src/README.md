## src Folder Structure 
Thi src folder contains all the Java source code files for the Student Learning Management System (SLMS) project.

src/
│── Course.java
│── Student.java
│── SLMSManager.java
│── Main.java


### File Descriptions

- **Course.java**  
  Represents a course with course details such as course code, name, credit hour, summary, Teams link and type.

- **Student.java**  
  Represents a student with student ID, name, email and phone number.

- **SLMSManager.java**  
  Handles all business logic including:
  - Course management
  - Student management
  - Student-course relationship handling

- **Main.java**  
  Entry point of the application.  
  Displays the menu and handles user interaction.

---

##  Features

### Course Management
- Add Course
- View All Courses
- Search Course
- Edit Course
- Delete Course

### Student Management
- Add Student
- View All Students
- Search Student
- Edit Student
- Delete Student

### Enrollment Management
- Assign Student to Course
- List Courses of a Student
- List Students of a Course

---

##  Technologies Used

- Java (JDK 8 or higher)
- NetBeans IDE (Recommended)
- Command Line / Terminal

---

##  System Design

- Uses Object-Oriented Programming principles
- Each class is stored in a separate `.java` file
- Fixed-size arrays (maximum 100 students and 100 courses)
- Uses a 2D boolean matrix to manage many-to-many relationships
- In-memory storage (no database)
- Sample data preloaded in constructor

---

##  How to Run

Using NetBeans (Recommended)

1. Open NetBeans IDE  
2. Click **File → Open Project**  
3. Download the SLMS src folder first, select and open the file in NetBeans IDE
4. Right-click `Main.java`  
5. Click **Run File**

---

## 📅 Version
1.0
