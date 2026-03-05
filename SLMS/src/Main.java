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

        SLMSManager manager = new SLMSManager();
        Scanner sc = new Scanner(System.in);

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
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = Integer.parseInt(sc.nextLine());

            switch(choice){
                case 1: manager.addCourse(); break;
                case 2: manager.viewAllCourses(); break;
                case 3:
                    System.out.println("a. Search Course\nb. Edit Course\nc. Delete Course");
                    String c = sc.nextLine();
                    if(c.equalsIgnoreCase("a")) manager.searchCourse();
                    else if(c.equalsIgnoreCase("b")) manager.editCourse();
                    else if(c.equalsIgnoreCase("c")) manager.deleteCourse();
                    break;
                case 4: manager.addStudent(); break;
                case 5: manager.viewAllStudents(); break;
                case 6:
                    System.out.println("a. Search Student\nb. Edit Student\nc. Delete Student");
                    String s = sc.nextLine();
                    if(s.equalsIgnoreCase("a")) manager.searchStudent();
                    else if(s.equalsIgnoreCase("b")) manager.editStudent();
                    else if(s.equalsIgnoreCase("c")) manager.deleteStudent();
                    break;
                case 7: manager.assignStudentToCourse(); break;
                case 8: manager.listCoursesOfStudent(); break;
                case 9: manager.listStudentsOfCourse(); break;
                case 0: System.out.println("Exiting system..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while(choice!=0);
    }
}