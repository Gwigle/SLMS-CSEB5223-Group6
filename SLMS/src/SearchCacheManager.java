/*
File: 
SearchCacheManager.java

Author:
1. ARIFAH NUR IMAN BINTI MOHD FADZILAH     
2. REYHANA MARSYA BINTI AHMAD SAIFULLIZAN   
3. DESHINI A/P SELVAKUMAR                
4. PATVIR SINGH KHOSA 

Description: 
Acts as a simple middleware/API cache layer for storing recent searches
and providing basic auto-suggestions for input fields.
*/

public class SearchCacheManager {

    private String[] recentCourseSearches = new String[20];
    private String[] recentStudentSearches = new String[20];
    private int courseSearchCount = 0;
    private int studentSearchCount = 0;

    // Cache recent course search
    public void cacheCourseSearch(String courseCode) {
        if(courseSearchCount < recentCourseSearches.length) {
            recentCourseSearches[courseSearchCount++] = courseCode;
        }
    }

    // Cache recent student search
    public void cacheStudentSearch(String studentId) {
        if(studentSearchCount < recentStudentSearches.length) {
            recentStudentSearches[studentSearchCount++] = studentId;
        }
    }

    // Show cached course suggestions
    public void suggestCourses(String input) {
        System.out.println("Suggested Course Codes:");
        boolean found = false;

        for(int i = 0; i < courseSearchCount; i++) {
            if(recentCourseSearches[i].toLowerCase().contains(input.toLowerCase())) {
                System.out.println("- " + recentCourseSearches[i]);
                found = true;
            }
        }

        if(!found) {
            System.out.println("No suggestions found.");
        }
    }

    // Show cached student suggestions
    public void suggestStudents(String input) {
        System.out.println("Suggested Student IDs:");
        boolean found = false;

        for(int i = 0; i < studentSearchCount; i++) {
            if(recentStudentSearches[i].toLowerCase().contains(input.toLowerCase())) {
                System.out.println("- " + recentStudentSearches[i]);
                found = true;
            }
        }

        if(!found) {
            System.out.println("No suggestions found.");
        }
    }
}
