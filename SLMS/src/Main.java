/*
File:
Main.java

Author:
1. ARIFAH NUR IMAN BINTI MOHD FADZILAH     
2. REYHANA MARSYA BINTI AHMAD SAIFULLIZAN   
3. DESHINI A/P SELVAKUMAR                
4. PATVIR SINGH KHOSA 

Description: 
Main entry point for SLMS system. Handles menu navigation and user input.
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SLMSManager manager = new SLMSManager(); // Create manager to handle courses and students from SLMSManager.java file
        Scanner sc = new Scanner(System.in);     // Scanner to read input

        int choice;
        // This do-while loop keeps system running until admin chooses to exit
        do {
            // Display main menu
            System.out.println("\n===== SLMS MENU =====");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Search/Edit/Delete Course");
            System.out.println("4. Add Student");
            System.out.println("5. View All Students");
            System.out.println("6. Search/Edit/Delete Student");
            System.out.println("7. Assign Student to Course");
            System.out.println("8. List Courses of Student");
            System.out.println("9. List Students of Course");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = Integer.parseInt(sc.nextLine()); // Read choice

            switch(choice){
                case 1: manager.addCourse(); break; // Call add course
                case 2: manager.viewAllCourses(); break; // Show all courses
                case 3:
                    // Submenu for course actions  
                    System.out.println("a. Search Course\nb. Edit Course\nc. Delete Course");
                    String c = sc.nextLine();
                    // equalsIgnoreCase check c input and allow both uppercase and lowercase letters (a/A, b/B, c/C)
                    if(c.equalsIgnoreCase("a")) manager.searchCourse();
                    else if(c.equalsIgnoreCase("b")) manager.editCourse();
                    else if(c.equalsIgnoreCase("c")) manager.deleteCourse();
                    break;
                case 4: manager.addStudent(); break; // Add student
                case 5: manager.viewAllStudents(); break; // Show all students
                case 6:
                    // Submenu for student actions
                    System.out.println("a. Search Student\nb. Edit Student\nc. Delete Student");
                    String s = sc.nextLine();
                    // equalsIgnoreCase check s input and allow both uppercase and lowercase letters (a/A, b/B, c/C)
                    if(s.equalsIgnoreCase("a")) manager.searchStudent();
                    else if(s.equalsIgnoreCase("b")) manager.editStudent();
                    else if(s.equalsIgnoreCase("c")) manager.deleteStudent();
                    break;
                case 7: manager.assignStudentToCourse(); break; // Assign student to course
                case 8: manager.listCoursesOfStudent(); break;  // Show courses of a student
                case 9: manager.listStudentsOfCourse(); break;  // Show students of a course
                case 0: System.out.println("Exiting system..."); break; // Exit
                default: System.out.println("Invalid choice!"); // Invalid input
            }
        } while(choice != 0); // Continue loop until 0 is entered
    }
}
