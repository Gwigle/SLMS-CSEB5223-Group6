/*
File: 
SLMSManager.java

Author:
1. ARIFAH NUR IMAN BINTI MOHD FADZILAH     
2. REYHANA MARSYA BINTI AHMAD SAIFULLIZAN   
3. DESHINI A/P SELVAKUMAR                
4. PATVIR SINGH KHOSA 

Description: 
Manages courses, students and their relationships in the SLMS system.
 */

import java.util.Scanner;

public class SLMSManager {

    private Scanner sc = new Scanner(System.in);

    private Course[] courses = new Course[100];
    private Student[] students = new Student[100];
    private boolean[][] relationship = new boolean[100][100];

    private int courseCount = 0;
    private int studentCount = 0;

    // Sample data
    public SLMSManager() {
        courses[0] = new Course("CSEB5223", "Software Construction & Methods", 3,
                "Practice coding and build SLMS project.", "https://teams.microsoft.com/l/course/CSEB5223", "core");
        courses[1] = new Course("CSEB4113", "Software Quality", 3,
                "Learn software quality and testing.", "https://teams.microsoft.com/l/course/CSEB4113", "core");
        courses[2] = new Course("CCSB5113", "Software Security", 3,
                "Fundamentals of software security.", "https://teams.microsoft.com/l/course/CCSB5113", "elective");
        courseCount = 3;

        students[0] = new Student("BSW01085214", "ARIFAH NUR IMAN BINTI MOHD FADZILAH",
                "BSW01085214@student.uniten.edu.my", "010-1234567");
        students[1] = new Student("BSW01085069", "REYHANA MARSYA BINTI AHMAD SAIFULLIZAN",
                "BSW01085069@student.uniten.edu.my", "011-2345678");
        students[2] = new Student("SW01083593", "DESHINI A/P SELVAKUMAR",
                "SW01083593@student.uniten.edu.my", "012-3456789");
        studentCount = 3;

        // Sample assignments
        relationship[0][0] = true;
        relationship[1][1] = true;
        relationship[2][2] = true;
    }

    //Course functions
    public void addCourse() {
        if(courseCount >= courses.length) { 
            System.out.println("Course list full!"); 
            return; 
        }

        System.out.print("Course Code: "); 
        String code = sc.nextLine();
        if(findCourseIndex(code) != -1) { 
            System.out.println("Course exists!"); 
            return; 
        }

        System.out.print("Course Name: "); 
        String name = sc.nextLine();

        int credit = 0;
        while(true) {
            try {
                System.out.print("Credit Hour: "); 
                credit = Integer.parseInt(sc.nextLine());
                if(credit <= 0) throw new NumberFormatException();
                break;
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
            if(type.equals("core") || type.equals("elective") || type.equals("university")) break;
            else System.out.println("Invalid course type. Please enter 'core', 'elective', or 'university'.");
        }

        courses[courseCount++] = new Course(code,name,credit,summary,link,type);
        System.out.println("Course added successfully!");
    }

    public int findCourseIndex(String code) {
        for(int i=0;i<courseCount;i++)
            if(courses[i].getCourseCode().equalsIgnoreCase(code)) return i;
        return -1;
    }

    public void searchCourse() {
        System.out.print("Enter course code to search: ");
        int idx = findCourseIndex(sc.nextLine());
        if(idx != -1) courses[idx].displayCourse();
        else System.out.println("Course not found!");
    }

    public void editCourse() {
        System.out.print("Enter course code to edit: ");
        int idx = findCourseIndex(sc.nextLine());
        if(idx != -1) {
            Course c = courses[idx];
            System.out.println("Editing course: " + c.getCourseCode());

            System.out.print("New Name ("+c.getCourseName()+"): "); 
            String n = sc.nextLine();
            if(!n.isEmpty()) c.setCourseName(n);

            System.out.print("New Credit ("+c.getCreditHour()+"): "); 
            String cr = sc.nextLine();
            if(!cr.isEmpty()) {
                try {
                    int credit = Integer.parseInt(cr);
                    if(credit>0) c.setCreditHour(credit);
                    else System.out.println("Credit not updated: must be positive.");
                } catch(NumberFormatException e) { System.out.println("Invalid input for credit."); }
            }

            System.out.print("New Summary ("+c.getSummary()+"): "); 
            String s = sc.nextLine();
            if(!s.isEmpty()) c.setSummary(s);

            System.out.print("New Teams Link ("+c.getTeamsLink()+"): "); 
            String l = sc.nextLine();
            if(!l.isEmpty()) c.setTeamsLink(l);

            System.out.print("New Type ("+c.getCourseType()+"): "); 
            String t = sc.nextLine();
            if(!t.isEmpty()) {
                t = t.toLowerCase();
                if(t.equals("core") || t.equals("elective") || t.equals("university")) c.setCourseType(t);
                else System.out.println("Invalid type. Type not updated.");
            }

            System.out.println("Course updated successfully!");
            c.displayCourse();
        } else System.out.println("Course not found!");
    }

    public void deleteCourse() {
        System.out.print("Enter course code to delete: ");
        int idx = findCourseIndex(sc.nextLine());
        if(idx != -1) {
            courses[idx].displayCourse();
            System.out.print("Confirm delete? (y/n): ");
            if(sc.nextLine().equalsIgnoreCase("y")) {
                for(int i=idx;i<courseCount-1;i++) courses[i]=courses[i+1];
                courseCount--;
                // Remove relationships
                for(int s=0;s<studentCount;s++) relationship[s][idx]=false;
                System.out.println("Course deleted successfully!");
                viewAllCourses();
            } else System.out.println("Deletion canceled.");
        } else System.out.println("Course not found!");
    }

    public void viewAllCourses() {
        if(courseCount==0){ System.out.println("No courses."); return; }
        for(int i=0;i<courseCount;i++) courses[i].displayCourse();
    }

    //Student functions
    public void addStudent() {
        if(studentCount >= students.length) { System.out.println("Student list full!"); return; }

        System.out.print("Student ID: "); String id = sc.nextLine();
        if(findStudentIndex(id) != -1) { System.out.println("Student exists!"); return; }

        System.out.print("Student Name: "); String name = sc.nextLine();
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.print("Phone: "); String phone = sc.nextLine();

        students[studentCount++] = new Student(id,name,email,phone);
        System.out.println("Student added successfully!");
    }

    public int findStudentIndex(String id) {
        for(int i=0;i<studentCount;i++)
            if(students[i].getStudentID().equalsIgnoreCase(id)) return i;
        return -1;
    }

    public void searchStudent() {
        System.out.print("Enter student ID to search: ");
        int idx = findStudentIndex(sc.nextLine());
        if(idx != -1) students[idx].displayStudent();
        else System.out.println("Student not found!");
    }

    public void editStudent() {
        System.out.print("Enter student ID to edit: ");
        int idx = findStudentIndex(sc.nextLine());
        if(idx != -1) {
            Student s = students[idx];
            System.out.println("Editing student: "+s.getStudentID());

            System.out.print("New Name ("+s.getStudentName()+"): "); String n = sc.nextLine();
            if(!n.isEmpty()) s.setStudentName(n);

            System.out.print("New Email ("+s.getEmail()+"): "); String e = sc.nextLine();
            if(!e.isEmpty()) s.setEmail(e);

            System.out.print("New Phone ("+s.getPhone()+"): "); String p = sc.nextLine();
            if(!p.isEmpty()) s.setPhone(p);

            System.out.println("Student updated successfully!");
            s.displayStudent();
        } else System.out.println("Student not found!");
    }

    public void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int idx = findStudentIndex(sc.nextLine());
        if(idx != -1) {
            students[idx].displayStudent();
            System.out.print("Confirm delete? (y/n): ");
            if(sc.nextLine().equalsIgnoreCase("y")) {
                for(int i=idx;i<studentCount-1;i++) students[i]=students[i+1];
                studentCount--;
                // Remove relationships
                for(int c=0;c<courseCount;c++) relationship[idx][c]=false;
                System.out.println("Student deleted successfully!");
            } else System.out.println("Deletion canceled.");
        } else System.out.println("Student not found!");
    }

    public void viewAllStudents() {
        if(studentCount==0){ System.out.println("No students."); return; }
        for(int i=0;i<studentCount;i++) students[i].displayStudent();
    }

    //Relationship functions
    public void assignStudentToCourse() {
        System.out.print("Student ID: "); String sid = sc.nextLine();
        System.out.print("Course Code: "); String code = sc.nextLine();

        int sIdx=findStudentIndex(sid), cIdx=findCourseIndex(code);
        if(sIdx==-1){ System.out.println("Student not found!"); return; }
        if(cIdx==-1){ System.out.println("Course not found!"); return; }
        if(relationship[sIdx][cIdx]){ System.out.println("Already assigned!"); return; }

        relationship[sIdx][cIdx]=true;
        System.out.println("Assignment successful!");
    }

    public void listCoursesOfStudent() {
        System.out.print("Enter Student ID: "); String sid = sc.nextLine();
        int sIdx=findStudentIndex(sid);
        if(sIdx==-1){ System.out.println("Student not found!"); return; }

        boolean found=false;
        System.out.println("Courses enrolled:");
        for(int c=0;c<courseCount;c++){
            if(relationship[sIdx][c]){
                courses[c].displayCourse();
                found=true;
            }
        }
        if(!found) System.out.println("No courses assigned.");
    }

    public void listStudentsOfCourse() {
        System.out.print("Enter Course Code: "); String code = sc.nextLine();
        int cIdx=findCourseIndex(code);
        if(cIdx==-1){ System.out.println("Course not found!"); return; }

        boolean found=false;
        System.out.println("Students enrolled:");
        for(int s=0;s<studentCount;s++){
            if(relationship[s][cIdx]){
                students[s].displayStudent();
                found=true;
            }
        }
        if(!found) System.out.println("No students enrolled.");
    }
}