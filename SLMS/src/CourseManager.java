/*
File:
CourseManager.java

Author:
1. ARIFAH NUR IMAN BINTI MOHD FADZILAH     
2. REYHANA MARSYA BINTI AHMAD SAIFULLIZAN   
3. DESHINI A/P SELVAKUMAR                
4. PATVIR SINGH KHOSA 

Description:
Handles all course-related operations such as add, search, edit, delete and view.
*/

import java.util.Scanner;

public class CourseManager {

    private Scanner sc;
    private Course[] courses = new Course[100]; // Fixed-size storage
    private int courseCount = 0; // Tracks number of stored courses

    // Constructor:  Initializes scanner and loads sample data
    public CourseManager(Scanner sc) {
        this.sc = sc;
        loadSampleCourses();
    }

    // Load sample courses
    private void loadSampleCourses() {
        courses[0] = new Course("CSEB5223", "Software Construction & Methods", 3,
                "Practice coding and build SLMS project.", "https://teams.microsoft.com/l/course/CSEB5223", "core");
        courses[1] = new Course("CSEB4113", "Software Quality", 3,
                "Learn software quality and testing.", "https://teams.microsoft.com/l/course/CSEB4113", "core");
        courses[2] = new Course("CCSB5113", "Software Security", 3,
                "Fundamentals of software security.", "https://teams.microsoft.com/l/course/CCSB5113", "elective");
        courseCount = 3;
    }

    // ------------------------- COURSE FUNCTIONS -------------------------

    // Add a new course
    public void addCourse() {
        if(courseCount >= courses.length) {
            System.out.println("Course list full!"); // Prevent overflow of array
            return;
        }

        System.out.print("Course Code: ");
        String code = sc.nextLine();

        if(findCourseIndex(code) != -1) {
            System.out.println("Course exists!"); // Prevent duplicate course entry
            return;
        }

        System.out.print("Course Name: ");
        String name = sc.nextLine();

        int credit = 0; // store validated credit hour
        while(true) {
            try {
                System.out.print("Credit Hour: ");
                credit = Integer.parseInt(sc.nextLine()); // Convert user input (String) into integer
                if(credit <= 0) throw new NumberFormatException(); // Validate credit must be positive
                break;
            // Error handling to catch non-integer input (example: abc), negative or zero values
            } catch(NumberFormatException e) {
                System.out.println("Invalid input! Please enter a positive integer for credit hour.");
            }
        }

        System.out.print("Summary: ");
        String summary = sc.nextLine();

        System.out.print("Teams Link: ");
        String link = sc.nextLine();

        String type = "";
        while(true) {
            System.out.print("Course Type (core/elective/university): ");
            type = sc.nextLine().toLowerCase();
            // validation of allowed values
            if(type.equals("core") || type.equals("elective") || type.equals("university")) break;
            else System.out.println("Invalid course type. Please enter 'core', 'elective' or 'university'.");
        }

        courses[courseCount++] = new Course(code, name, credit, summary, link, type);
        System.out.println("Course added successfully!");
    }

    // Find course index by course code (linear search)
    public int findCourseIndex(String code) {
        for(int i = 0; i < courseCount; i++) {
            if(courses[i].getCourseCode().equalsIgnoreCase(code)) return i;
        }
        return -1; 
    }

    // Search for course
    public void searchCourse() {
        System.out.print("Enter course code to search: ");
        int idx = findCourseIndex(sc.nextLine());
        if(idx != -1) courses[idx].displayCourse();
        else System.out.println("Course not found!");
    }

    // Search and return course object
    public Course getCourseByCode(String code) {
        int idx = findCourseIndex(code);
        if(idx != -1) return courses[idx];
        return null; 
    }

    // Edit course
    public void editCourse() {
        System.out.print("Enter course code to edit: ");
        int idx = findCourseIndex(sc.nextLine());

        if(idx != -1) {
            Course c = courses[idx];
            System.out.println("Editing course: " + c.getCourseCode());

            System.out.print("New Name (" + c.getCourseName() + "): ");
            String n = sc.nextLine();
            if(!n.isEmpty()) c.setCourseName(n); // ignore empty input

            System.out.print("New Credit (" + c.getCreditHour() + "): ");
            String cr = sc.nextLine();
            if(!cr.isEmpty()) {
                try {
                    int credit = Integer.parseInt(cr);
                    if(credit > 0) c.setCreditHour(credit);
                    else System.out.println("Credit not updated: must be positive.");
                } catch(NumberFormatException e) {
                    System.out.println("Invalid input for credit.");
                }
            }

            System.out.print("New Summary (" + c.getSummary() + "): ");
            String s = sc.nextLine();
            if(!s.isEmpty()) c.setSummary(s);

            System.out.print("New Teams Link (" + c.getTeamsLink() + "): ");
            String l = sc.nextLine();
            if(!l.isEmpty()) c.setTeamsLink(l);

            System.out.print("New Type (" + c.getCourseType() + "): ");
            String t = sc.nextLine();
            if(!t.isEmpty()) {
                t = t.toLowerCase();
                if(t.equals("core") || t.equals("elective") || t.equals("university")) c.setCourseType(t);
                else System.out.println("Invalid type. Type not updated.");
            }

            System.out.println("Course updated successfully!");
            c.displayCourse();
        } else {
            System.out.println("Course not found!");
        }
    }

    // Delete course and return deleted index
    public int deleteCourse() {
        System.out.print("Enter course code to delete: ");
        int idx = findCourseIndex(sc.nextLine());

        if(idx != -1) {
            courses[idx].displayCourse();
            System.out.print("Confirm delete? (y/n): ");
            if(sc.nextLine().equalsIgnoreCase("y")) {
                // shift elements left
                for(int i = idx; i < courseCount - 1; i++) {
                    courses[i] = courses[i + 1];
                }
                courses[courseCount - 1] = null; // remove last elements
                courseCount--;

                System.out.println("Course deleted successfully!");
                viewAllCourses(); 
                return idx;
            } else {
                System.out.println("Deletion canceled.");
            }
        } else {
            System.out.println("Course not found!");
        }
        return -1;
    }

    // Display all courses
    public void viewAllCourses() {
        if(courseCount == 0) {
            System.out.println("No courses.");
            return;
        }
        for(int i = 0; i < courseCount; i++) {
            courses[i].displayCourse();
        }
    }

    // Getter for array
    public Course[] getCourses() {
        return courses;
    }

    // Getter for course count
    public int getCourseCount() {
        return courseCount;
    }
}
