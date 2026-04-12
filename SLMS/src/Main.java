/*
File:
Main.java

Author:
1. ARIFAH NUR IMAN BINTI MOHD FADZILAH     
2. REYHANA MARSYA BINTI AHMAD SAIFULLIZAN   
3. DESHINI A/P SELVAKUMAR                
4. PATVIR SINGH KHOSA 

Description: 
Main entry point for SLMS system. Handles menu navigation and integrates
CourseManager, StudentManager, RelationshipManager and SearchCacheManager.
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create manager objects
        CourseManager courseManager = new CourseManager(sc);
        StudentManager studentManager = new StudentManager(sc);
        RelationshipManager relationshipManager = new RelationshipManager(sc, courseManager, studentManager);
        SearchCacheManager cacheManager = new SearchCacheManager();

        int choice;

        do {
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
            System.out.println("10. Course Search Suggestions");
            System.out.println("11. Student Search Suggestions");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                choice = -1;
                continue;
            }

            switch(choice) {
                case 1:
                    courseManager.addCourse();
                    break;

                case 2:
                    courseManager.viewAllCourses();
                    break;

                case 3:
                    System.out.println("a. Search Course\nb. Edit Course\nc. Delete Course");
                    String c = sc.nextLine();

                    if(c.equalsIgnoreCase("a")) {
                        System.out.print("Enter course code to cache/search: ");
                        String courseCode = sc.nextLine();
                        cacheManager.cacheCourseSearch(courseCode);

                        Course course = courseManager.getCourseByCode(courseCode);
                        if(course != null) course.displayCourse();
                        else System.out.println("Course not found!");
                    }
                    else if(c.equalsIgnoreCase("b")) {
                        courseManager.editCourse();
                    }
                    else if(c.equalsIgnoreCase("c")) {
                        int deletedCourseIndex = courseManager.deleteCourse();
                        relationshipManager.removeCourseRelationship(deletedCourseIndex);
                    }
                    else {
                        System.out.println("Invalid option!");
                    }
                    break;

                case 4:
                    studentManager.addStudent();
                    break;

                case 5:
                    studentManager.viewAllStudents();
                    break;

                case 6:
                    System.out.println("a. Search Student\nb. Edit Student\nc. Delete Student");
                    String s = sc.nextLine();

                    if(s.equalsIgnoreCase("a")) {
                        System.out.print("Enter student ID to cache/search: ");
                        String studentId = sc.nextLine();
                        cacheManager.cacheStudentSearch(studentId);

                        Student student = studentManager.getStudentById(studentId);
                        if(student != null) student.displayStudent();
                        else System.out.println("Student not found!");
                    }
                    else if(s.equalsIgnoreCase("b")) {
                        studentManager.editStudent();
                    }
                    else if(s.equalsIgnoreCase("c")) {
                        int deletedStudentIndex = studentManager.deleteStudent();
                        relationshipManager.removeStudentRelationship(deletedStudentIndex);
                    }
                    else {
                        System.out.println("Invalid option!");
                    }
                    break;

                case 7:
                    relationshipManager.assignStudentToCourse();
                    break;

                case 8:
                    relationshipManager.listCourses();
                    break;

                case 9:
                    relationshipManager.listStudents();
                    break;

                case 10:
                    System.out.print("Enter partial course code: ");
                    cacheManager.suggestCourses(sc.nextLine());
                    break;

                case 11:
                    System.out.print("Enter partial student ID: ");
                    cacheManager.suggestStudents(sc.nextLine());
                    break;

                case 0:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while(choice != 0);

        sc.close();
    }
}
