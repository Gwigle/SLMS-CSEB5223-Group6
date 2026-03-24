/*
File: 
Course.java

Author:
1. ARIFAH NUR IMAN BINTI MOHD FADZILAH     
2. REYHANA MARSYA BINTI AHMAD SAIFULLIZAN   
3. DESHINI A/P SELVAKUMAR                
4. PATVIR SINGH KHOSA                 

Description: 
Represents a course in the SLMS system with attributes, getters, setters, and display functionality.
*/

public class Course {

    // Variables to store course details
    private String courseCode; // Unique course code
    private String courseName; // Name of the course
    private int creditHour;    // Number of credit hours
    private String summary;    // Short description
    private String teamsLink;  // Link to Microsoft Teams
    private String courseType; // Type: core or elective

    // Constructor to create a new course
    public Course(String courseCode, String courseName, int creditHour,
                  String summary, String teamsLink, String courseType) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditHour = creditHour;
        this.summary = summary;
        this.teamsLink = teamsLink;
        this.courseType = courseType;
    }

    // ------------------------- GETTERS -------------------------
    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }
    public int getCreditHour() { return creditHour; }
    public String getSummary() { return summary; }
    public String getTeamsLink() { return teamsLink; }
    public String getCourseType() { return courseType; }

    // ------------------------- SETTERS -------------------------
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setCreditHour(int creditHour) { this.creditHour = creditHour; }
    public void setSummary(String summary) { this.summary = summary; }
    public void setTeamsLink(String teamsLink) { this.teamsLink = teamsLink; }
    public void setCourseType(String courseType) { this.courseType = courseType; }

    // Display course information in a readable format
    public void displayCourse() {
        System.out.println("==================================");
        System.out.printf("Course Code : %s%n", courseCode);
        System.out.printf("Course Name : %s%n", courseName);
        System.out.printf("Credit Hour : %d%n", creditHour);
        System.out.printf("Summary     : %s%n", summary);
        System.out.printf("Teams Link  : %s%n", teamsLink);
        System.out.printf("Type        : %s%n", courseType);
        System.out.println("==================================");
    }
}


