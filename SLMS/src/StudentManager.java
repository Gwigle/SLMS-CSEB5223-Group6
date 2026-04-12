/*
File: 
StudentManager.java

Author:
1. ARIFAH NUR IMAN BINTI MOHD FADZILAH     
2. REYHANA MARSYA BINTI AHMAD SAIFULLIZAN   
3. DESHINI A/P SELVAKUMAR                
4. PATVIR SINGH KHOSA 

Description: 
Manages all student-related operations such as add, search, edit, delete and display.
*/

import java.util.Scanner;

public class StudentManager {

    private Scanner sc;
    private Student[] students = new Student[100];
    private int studentCount = 0;

    // Constructor
    public StudentManager(Scanner sc) {
        this.sc = sc;
        loadSampleStudents();
    }

    // Load sample students
    private void loadSampleStudents() {
        students[0] = new Student("BSW01085214", "ARIFAH NUR IMAN BINTI MOHD FADZILAH",
                "BSW01085214@student.uniten.edu.my", "010-1234567");
        students[1] = new Student("BSW01085069", "REYHANA MARSYA BINTI AHMAD SAIFULLIZAN",
                "BSW01085069@student.uniten.edu.my", "011-2345678");
        students[2] = new Student("SW01083593", "DESHINI A/P SELVAKUMAR",
                "SW01083593@student.uniten.edu.my", "012-3456789");
        studentCount = 3;
    }

    // ------------------------- STUDENT FUNCTIONS -------------------------

    // Add student
    public void addStudent() {
        if(studentCount >= students.length) {
            System.out.println("Student list full!");
            return;
        }

        System.out.print("Student ID: ");
        String id = sc.nextLine();

        if(findStudentIndex(id) != -1) {
            System.out.println("Student exists!");
            return;
        }

        System.out.print("Student Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();

        students[studentCount++] = new Student(id, name, email, phone);
        System.out.println("Student added successfully!");
    }

    // Find student index by ID
    public int findStudentIndex(String id) {
        for(int i = 0; i < studentCount; i++) {
            if(students[i].getStudentID().equalsIgnoreCase(id)) return i;
        }
        return -1;
    }

    // Search student
    public void searchStudent() {
        System.out.print("Enter student ID to search: ");
        int idx = findStudentIndex(sc.nextLine());
        if(idx != -1) students[idx].displayStudent();
        else System.out.println("Student not found!");
    }

    // Search and return student object
    public Student getStudentById(String id) {
        int idx = findStudentIndex(id);
        if(idx != -1) return students[idx];
        return null;
    }

    // Edit student
    public void editStudent() {
        System.out.print("Enter student ID to edit: ");
        int idx = findStudentIndex(sc.nextLine());

        if(idx != -1) {
            Student s = students[idx];
            System.out.println("Editing student: " + s.getStudentID());

            System.out.print("New Name (" + s.getStudentName() + "): ");
            String n = sc.nextLine();
            if(!n.isEmpty()) s.setStudentName(n);

            System.out.print("New Email (" + s.getEmail() + "): ");
            String e = sc.nextLine();
            if(!e.isEmpty()) s.setEmail(e);

            System.out.print("New Phone (" + s.getPhone() + "): ");
            String p = sc.nextLine();
            if(!p.isEmpty()) s.setPhone(p);

            System.out.println("Student updated successfully!");
            s.displayStudent();
        } else {
            System.out.println("Student not found!");
        }
    }

    // Delete student and return deleted index
    public int deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int idx = findStudentIndex(sc.nextLine());

        if(idx != -1) {
            students[idx].displayStudent();
            System.out.print("Confirm delete? (y/n): ");
            if(sc.nextLine().equalsIgnoreCase("y")) {
                for(int i = idx; i < studentCount - 1; i++) {
                    students[i] = students[i + 1];
                }
                students[studentCount - 1] = null;
                studentCount--;

                System.out.println("Student deleted successfully!");
                viewAllStudents(); // Added to match lab outline
                return idx;
            } else {
                System.out.println("Deletion canceled.");
            }
        } else {
            System.out.println("Student not found!");
        }
        return -1;
    }

    // Display all students
    public void viewAllStudents() {
        if(studentCount == 0) {
            System.out.println("No students.");
            return;
        }
        for(int i = 0; i < studentCount; i++) {
            students[i].displayStudent();
        }
    }

    // Getter for array
    public Student[] getStudents() {
        return students;
    }

    // Getter for student count
    public int getStudentCount() {
        return studentCount;
    }
}