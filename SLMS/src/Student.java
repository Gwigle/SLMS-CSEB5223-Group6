/*
File: 
Student.java

Author:
1. ARIFAH NUR IMAN BINTI MOHD FADZILAH     
2. REYHANA MARSYA BINTI AHMAD SAIFULLIZAN   
3. DESHINI A/P SELVAKUMAR                
4. PATVIR SINGH KHOSA 

Description: 
Represents a student in the SLMS system with attributes, getters, setters, and display functionality.
*/

public class Student {

    // Variables to store student details
    private String studentID;   // Unique ID
    private String studentName; // Name of student
    private String email;       // Student email
    private String phone;       // Student phone number

    // Constructor to create new student
    public Student(String studentID, String studentName, String email, String phone) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.email = email;
        this.phone = phone;
    }

    // ------------------------- GETTERS -------------------------
    public String getStudentID() { return studentID; }
    public String getStudentName() { return studentName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    // ------------------------- SETTERS -------------------------
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }

    // Display student information in readable format
    public void displayStudent() {
        System.out.println("==================================");
        System.out.printf("Student ID   : %s%n", studentID);
        System.out.printf("Student Name : %s%n", studentName);
        System.out.printf("Email        : %s%n", email);
        System.out.printf("Phone        : %s%n", phone);
        System.out.println("==================================");
    }
}
