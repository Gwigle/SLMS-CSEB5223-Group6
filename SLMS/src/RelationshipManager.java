/*
File: 
RelationshipManager.java

Author:
1. ARIFAH NUR IMAN BINTI MOHD FADZILAH     
2. REYHANA MARSYA BINTI AHMAD SAIFULLIZAN   
3. DESHINI A/P SELVAKUMAR                
4. PATVIR SINGH KHOSA 

Description: 
Manages relationships between students and courses using a 2D boolean array.
Handles assigning, finding, and listing course-student relationships.
*/

import java.util.Scanner;

public class RelationshipManager {

    private Scanner sc;
    private CourseManager courseManager;
    private StudentManager studentManager;

    // 2D relationship array: relationship[studentIndex][courseIndex]
    private boolean[][] relationship = new boolean[100][100];

    // Constructor
    public RelationshipManager(Scanner sc, CourseManager courseManager, StudentManager studentManager) {
        this.sc = sc;
        this.courseManager = courseManager;
        this.studentManager = studentManager;
        loadSampleRelationships();
    }

    // Load sample assignments
    private void loadSampleRelationships() {
        relationship[0][0] = true; // Student 0 -> Course 0
        relationship[1][1] = true; // Student 1 -> Course 1
        relationship[2][2] = true; // Student 2 -> Course 2
    }

    // ------------------------- RELATIONSHIP FUNCTIONS -------------------------

    // Assign student to course
    public void assignStudentToCourse() {
        System.out.print("Student ID: ");
        String sid = sc.nextLine();
        System.out.print("Course Code: ");
        String code = sc.nextLine();

        int sIdx = studentManager.findStudentIndex(sid);
        int cIdx = courseManager.findCourseIndex(code);

        if(sIdx == -1) {
            System.out.println("Student not found!");
            return;
        }

        if(cIdx == -1) {
            System.out.println("Course not found!");
            return;
        }

        if(relationship[sIdx][cIdx]) {
            System.out.println("Already assigned! Student is already enrolled in this course.");
            return;
        }

        relationship[sIdx][cIdx] = true;
        System.out.println("Assignment successful!");
    }

    // addCourse() to student relationship
    public void addCourse() {
        assignStudentToCourse();
    }

    // addStudent() to course relationship
    public void addStudent() {
        assignStudentToCourse();
    }

    // Find student's course(s)
    public void findCourse() {
        listCourses();
    }

    // List all courses of a student
    public void listCourses() {
        System.out.print("Enter Student ID: ");
        String sid = sc.nextLine();

        int sIdx = studentManager.findStudentIndex(sid);

        if(sIdx == -1) {
            System.out.println("Student not found!");
            return;
        }

        boolean found = false;
        System.out.println("Courses enrolled:");

        for(int c = 0; c < courseManager.getCourseCount(); c++) {
            if(relationship[sIdx][c]) {
                courseManager.getCourses()[c].displayCourse();
                found = true;
            }
        }

        if(!found) {
            System.out.println("This student has no assigned course.");
        }
    }

    // Find student(s) in a course
    public void findStudent() {
        listStudents();
    }

    // List all students of a course
    public void listStudents() {
        System.out.print("Enter Course Code: ");
        String code = sc.nextLine();

        int cIdx = courseManager.findCourseIndex(code);

        if(cIdx == -1) {
            System.out.println("Course not found!");
            return;
        }

        boolean found = false;
        System.out.println("Students enrolled:");

        for(int s = 0; s < studentManager.getStudentCount(); s++) {
            if(relationship[s][cIdx]) {
                studentManager.getStudents()[s].displayStudent();
                found = true;
            }
        }

        if(!found) {
            System.out.println("This course has no assigned student.");
        }
    }

    // Remove course relationships after course deletion
    public void removeCourseRelationship(int deletedCourseIndex) {
        if(deletedCourseIndex == -1) return;

        for(int s = 0; s < studentManager.getStudentCount(); s++) {
            for(int c = deletedCourseIndex; c < courseManager.getCourseCount(); c++) {
                relationship[s][c] = relationship[s][c + 1]; //Prevent overflow
            }
            relationship[s][courseManager.getCourseCount()] = false;
        }
    }

    // Remove student relationships after student deletion
    public void removeStudentRelationship(int deletedStudentIndex) {
        if(deletedStudentIndex == -1) return;

        for(int s = deletedStudentIndex; s < studentManager.getStudentCount(); s++) {
            for(int c = 0; c < courseManager.getCourseCount(); c++) {
                relationship[s][c] = relationship[s + 1][c];
            }
        }

        for(int c = 0; c < courseManager.getCourseCount(); c++) {
            relationship[studentManager.getStudentCount()][c] = false;
        }
    }
}
