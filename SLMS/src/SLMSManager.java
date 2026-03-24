/*
File: 
SLMSManager.java

Author:
1. ARIFAH NUR IMAN BINTI MOHD FADZILAH     
2. REYHANA MARSYA BINTI AHMAD SAIFULLIZAN   
3. DESHINI A/P SELVAKUMAR                
4. PATVIR SINGH KHOSA 

Description: 
This SLMSManager class manages courses, students and their relationship in the SLMS system.
*/

import java.util.Scanner;

public class SLMSManager {

    private Scanner sc = new Scanner(System.in); // Scanner to read user input

    // Arrays to store courses and students (maximum 100 each)
    private Course[] courses = new Course[100];
    private Student[] students = new Student[100];

    // 2D boolean array to track which student is assigned to which course
    private boolean[][] relationship = new boolean[100][100];

    // Track the current number of courses and students
    private int courseCount = 0;
    private int studentCount = 0;

    // Constructor: initialize sample courses, students and assignments
    public SLMSManager() {

        // Add sample courses
        courses[0] = new Course("CSEB5223", "Software Construction & Methods", 3,
                "Practice coding and build SLMS project.", "https://teams.microsoft.com/l/course/CSEB5223", "core");
        courses[1] = new Course("CSEB4113", "Software Quality", 3,
                "Learn software quality and testing.", "https://teams.microsoft.com/l/course/CSEB4113", "core");
        courses[2] = new Course("CCSB5113", "Software Security", 3,
                "Fundamentals of software security.", "https://teams.microsoft.com/l/course/CCSB5113", "elective");
        courseCount = 3; // We now have 3 courses

        // Add sample students
        students[0] = new Student("BSW01085214", "ARIFAH NUR IMAN BINTI MOHD FADZILAH",
                "BSW01085214@student.uniten.edu.my", "010-1234567");
        students[1] = new Student("BSW01085069", "REYHANA MARSYA BINTI AHMAD SAIFULLIZAN",
                "BSW01085069@student.uniten.edu.my", "011-2345678");
        students[2] = new Student("SW01083593", "DESHINI A/P SELVAKUMAR",
                "SW01083593@student.uniten.edu.my", "012-3456789");
        studentCount = 3; // We now have 3 students

        // Assign sample students to courses
        relationship[0][0] = true; // Student 0 assigned to Course 0
        relationship[1][1] = true; // Student 1 assigned to Course 1
        relationship[2][2] = true; // Student 2 assigned to Course 2
    }

    // ------------------------- COURSE FUNCTIONS -------------------------

    // Add a new course
    public void addCourse() {

        // Stop if course array is full
        if(courseCount >= courses.length) {
            System.out.println("Course list full!");
            return; // Exit method
        }

        System.out.print("Course Code: "); 
        String code = sc.nextLine(); // Read course code from user

        // Check if course code already exists
        // findCourseIndex returns -1 if not found
        if(findCourseIndex(code) != -1) { 
            System.out.println("Course exists!"); // Prevent duplicate course
            return; // Stop adding
        }

        System.out.print("Course Name: "); 
        String name = sc.nextLine(); // Read course name

        int credit = 0; // Variable to store credit hour

        // Loop until valid credit hour is entered
        while(true) {
            try {
                System.out.print("Credit Hour: "); 
                credit = Integer.parseInt(sc.nextLine()); // Convert input to integer
                if(credit <= 0) throw new NumberFormatException(); // Must be positive
                break; // Exit loop if valid
            } catch(NumberFormatException e) {
                System.out.println("Invalid input! Please enter a positive integer for credit hour.");
            }
        }

        System.out.print("Summary: "); 
        String summary = sc.nextLine(); // Read course summary

        System.out.print("Teams Link: "); 
        String link = sc.nextLine(); // Read Teams link

        String type = "";
        // Loop until valid course type is entered
        while(true) {
            System.out.print("Course Type (core/elective): "); 
            type = sc.nextLine().toLowerCase(); // Convert input to lowercase
            if(type.equals("core") || type.equals("elective")) break; // Only accept core or elective
            else System.out.println("Invalid course type. Please enter 'core' or 'elective'.");
        }

        // Create new Course object and add it to the array
        // courseCount++ ensures next course will go to next array position
        courses[courseCount++] = new Course(code, name, credit, summary, link, type);
        System.out.println("Course added successfully!"); // Confirm success
    }

    // Find the index of a course in the array
    public int findCourseIndex(String code) {
        for(int i = 0; i < courseCount; i++) {
            if(courses[i].getCourseCode().equalsIgnoreCase(code)) return i; // Found, return index
        }
        return -1; // Not found
    }

    // Search for a course by code
    public void searchCourse() {
        System.out.print("Enter course code to search: ");
        int idx = findCourseIndex(sc.nextLine());
        if(idx != -1) courses[idx].displayCourse(); // Show course info
        else System.out.println("Course not found!");
    }

    // Edit a course
    public void editCourse() {
        System.out.print("Enter course code to edit: ");
        int idx = findCourseIndex(sc.nextLine());
        if(idx != -1) {
            Course c = courses[idx];
            System.out.println("Editing course: " + c.getCourseCode());

            System.out.print("New Name (" + c.getCourseName() + "): "); 
            String n = sc.nextLine();
            if(!n.isEmpty()) c.setCourseName(n); // Update name if not empty

            System.out.print("New Credit (" + c.getCreditHour() + "): "); 
            String cr = sc.nextLine();
            if(!cr.isEmpty()) {
                try {
                    int credit = Integer.parseInt(cr);
                    if(credit > 0) c.setCreditHour(credit); // Update if positive
                    else System.out.println("Credit not updated: must be positive.");
                } catch(NumberFormatException e) { 
                    System.out.println("Invalid input for credit."); 
                }
            }

            System.out.print("New Summary (" + c.getSummary() + "): "); 
            String s = sc.nextLine();
            if(!s.isEmpty()) c.setSummary(s); // Update summary

            System.out.print("New Teams Link (" + c.getTeamsLink() + "): "); 
            String l = sc.nextLine();
            if(!l.isEmpty()) c.setTeamsLink(l); // Update Teams link

            System.out.print("New Type (" + c.getCourseType() + "): "); 
            String t = sc.nextLine();
            if(!t.isEmpty()) {
                t = t.toLowerCase().toLowerCase(); ;
                if(t.equals("core") || t.equals("elective")) c.setCourseType(t); 
                else System.out.println("Invalid type. Type not updated. Please enter 'core' or 'elective'.");
            }

            System.out.println("Course updated successfully!");
            c.displayCourse(); // Show updated info
        } else System.out.println("Course not found!");
    }

    // Delete a course
    public void deleteCourse() {
        System.out.print("Enter course code to delete: ");
        int idx = findCourseIndex(sc.nextLine());
        if(idx != -1) {
            courses[idx].displayCourse(); // Show course info before deletion
            System.out.print("Confirm delete? (y/n): ");
            if(sc.nextLine().equalsIgnoreCase("y")) {
                // Shift array left to remove course
                for(int i = idx; i < courseCount - 1; i++) courses[i] = courses[i + 1];
                courseCount--; // Reduce course count

                // Remove all student assignments for this course
                for(int s = 0; s < studentCount; s++) relationship[s][idx] = false;

                System.out.println("Course deleted successfully!");
                viewAllCourses(); // Show updated list
            } else System.out.println("Deletion canceled.");
        } else System.out.println("Course not found!");
    }

    // View all courses
    public void viewAllCourses() {
        if(courseCount == 0) { System.out.println("No courses."); return; }
        for(int i = 0; i < courseCount; i++) courses[i].displayCourse();
    }

    // ------------------------- STUDENT FUNCTIONS -------------------------

    // Add a new student
    public void addStudent() {
        if(studentCount >= students.length) { 
            System.out.println("Student list full!"); 
            return; 
        }

        System.out.print("Student ID: "); 
        String id = sc.nextLine();

        // Check if student already exists
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

        // Create new student object and add to array
        students[studentCount++] = new Student(id, name, email, phone);
        System.out.println("Student added successfully!");
    }

    // Find student index in array
    public int findStudentIndex(String id) {
        for(int i = 0; i < studentCount; i++)
            if(students[i].getStudentID().equalsIgnoreCase(id)) return i; // Found
        return -1; // Not found
    }

    // Search student by ID
    public void searchStudent() {
        System.out.print("Enter student ID to search: ");
        int idx = findStudentIndex(sc.nextLine());
        if(idx != -1) students[idx].displayStudent(); // Show info
        else System.out.println("Student not found!");
    }

    // Edit student info
    public void editStudent() {
        System.out.print("Enter student ID to edit: ");
        int idx = findStudentIndex(sc.nextLine());
        if(idx != -1) {
            Student s = students[idx];
            System.out.println("Editing student: " + s.getStudentID());

            System.out.print("New Name (" + s.getStudentName() + "): "); 
            String n = sc.nextLine();
            if(!n.isEmpty()) s.setStudentName(n); // Update name

            System.out.print("New Email (" + s.getEmail() + "): "); 
            String e = sc.nextLine();
            if(!e.isEmpty()) s.setEmail(e); // Update email

            System.out.print("New Phone (" + s.getPhone() + "): "); 
            String p = sc.nextLine();
            if(!p.isEmpty()) s.setPhone(p); // Update phone

            System.out.println("Student updated successfully!");
            s.displayStudent(); // Show updated info
        } else System.out.println("Student not found!");
    }

    // Delete student
    public void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int idx = findStudentIndex(sc.nextLine());
        if(idx != -1) {
            students[idx].displayStudent(); // Show info
            System.out.print("Confirm delete? (y/n): ");
            if(sc.nextLine().equalsIgnoreCase("y")) {
                // Shift array left to remove student
                for(int i = idx; i < studentCount - 1; i++) students[i] = students[i + 1];
                studentCount--; // Reduce count

                // Remove all course assignments for this student
                for(int c = 0; c < courseCount; c++) relationship[idx][c] = false;

                System.out.println("Student deleted successfully!");
            } else System.out.println("Deletion canceled.");
        } else System.out.println("Student not found!");
    }

    // View all students
    public void viewAllStudents() {
        if(studentCount == 0) { System.out.println("No students."); return; }
        for(int i = 0; i < studentCount; i++) students[i].displayStudent();
    }

    // ------------------------- RELATIONSHIP FUNCTIONS -------------------------

    // Assign student to course
    public void assignStudentToCourse() {
        System.out.print("Student ID: "); 
        String sid = sc.nextLine();
        System.out.print("Course Code: "); 
        String code = sc.nextLine();

        int sIdx = findStudentIndex(sid); // Get student index
        int cIdx = findCourseIndex(code);  // Get course index

        // Check if student or course exists
        if(sIdx == -1){ System.out.println("Student not found!"); return; }
        if(cIdx == -1){ System.out.println("Course not found!"); return; }

        // Check if already assigned
        if(relationship[sIdx][cIdx]){ System.out.println("Already assigned!"); return; }

        relationship[sIdx][cIdx] = true; // Assign student
        System.out.println("Assignment successful!");
    }

    // List all courses a student is enrolled in
    public void listCoursesOfStudent() {
        System.out.print("Enter Student ID: "); 
        String sid = sc.nextLine();
        int sIdx = findStudentIndex(sid);

        if(sIdx == -1){ System.out.println("Student not found!"); return; }

        boolean found = false;
        System.out.println("Courses enrolled:");
        for(int c = 0; c < courseCount; c++){
            if(relationship[sIdx][c]){
                courses[c].displayCourse(); // Show course info
                found = true;
            }
        }
        if(!found) System.out.println("No courses assigned.");
    }

    // List all students enrolled in a course
    public void listStudentsOfCourse() {
        System.out.print("Enter Course Code: "); 
        String code = sc.nextLine();
        int cIdx = findCourseIndex(code);

        if(cIdx == -1){ System.out.println("Course not found!"); return; }

        boolean found = false;
        System.out.println("Students enrolled:");
        for(int s = 0; s < studentCount; s++){
            if(relationship[s][cIdx]){
                students[s].displayStudent(); // Show student info
                found = true;
            }
        }
        if(!found) System.out.println("No students enrolled.");
    }
}
