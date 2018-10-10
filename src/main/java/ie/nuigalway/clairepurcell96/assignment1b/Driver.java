/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.nuigalway.clairepurcell96.assignment1b;

import ie.nuigalway.clairepurcell96.assignment1.*;
import org.joda.time.DateTime;
import java.util.ArrayList;

/**
 *
 * @author clairepurcell96
 */
public class Driver {
    public static void main(String args[]) {
        // create a handfull of students
        Student johnDoe = new Student("John Doe", 21, new DateTime(1996, 10, 30, 1, 30), "12345678");
        Student janeDoe = new Student("Jane Doe", 20, new DateTime(1997, 12, 10, 4, 45), "87654321");
        Student markSmith = new Student("Mark Smith", 22, new DateTime(1996, 8, 2, 12, 0), "24681357");
        Student maryRyan = new Student("Mary Ryan", 22, new DateTime(1996, 1, 4, 10, 5), "00004567");
        Student conorOdonnell = new Student("Conor O'Donnell", 21, new DateTime(1997, 4, 3, 15, 43), "22224444");
        Student ciaraMcCarthy = new Student("Ciara McCarthy", 21, new DateTime(1996, 11, 17, 5, 20), "98765432");

        // create some modules
        CollegeModule softwareEng = new CollegeModule("Software Engineering", "CT000");
        CollegeModule databases = new CollegeModule("Database Systems", "CT123");
        CollegeModule machineLearning = new CollegeModule("Machine Learning", "CT456");

        // create some courses
        CourseProgramme computerEngineering = new CourseProgramme("Computer Engineering", new DateTime(2015, 9, 1, 9, 0), new DateTime(2019, 5, 20, 16, 0));
        CourseProgramme computerScience = new CourseProgramme("Computer Science", new DateTime(2015, 9, 1, 9, 0), new DateTime(2019, 5, 20, 16, 0));
        
        ArrayList<Student> students = new ArrayList<Student>(6);
        students.add(johnDoe);
        students.add(janeDoe);
        students.add(markSmith);
        students.add(maryRyan);
        students.add(conorOdonnell);
        students.add(ciaraMcCarthy);
        
        ArrayList<CollegeModule> modules = new ArrayList<CollegeModule>(3);
        modules.add(softwareEng);
        modules.add(databases);
        modules.add(machineLearning);
        
        ArrayList<CourseProgramme> courses = new ArrayList<CourseProgramme>(2);
        courses.add(computerEngineering);
        courses.add(computerScience);
        
        // add various students to various modules
        softwareEng.register(johnDoe);
        softwareEng.register(janeDoe);
        softwareEng.register(markSmith);
        softwareEng.register(maryRyan);
        softwareEng.register(ciaraMcCarthy);
        softwareEng.register(conorOdonnell);
        
        databases.register(janeDoe);
        databases.register(maryRyan);
        databases.register(ciaraMcCarthy);
        
        machineLearning.register(johnDoe);
        machineLearning.register(markSmith);
        machineLearning.register(conorOdonnell);
        
        softwareEng.setAssociatedCourse(computerEngineering);
        softwareEng.setAssociatedCourse(computerScience);
        databases.setAssociatedCourse(computerScience);
        machineLearning.setAssociatedCourse(computerEngineering);
        
        // add modules to courses
        computerEngineering.addModule(softwareEng);
        computerEngineering.addModule(machineLearning);
        computerScience.addModule(softwareEng);
        computerScience.addModule(databases);
        
        // register students for courses
        computerEngineering.register(johnDoe);
        computerEngineering.register(markSmith);
        computerEngineering.register(conorOdonnell);
        computerScience.register(janeDoe);
        computerScience.register(maryRyan);
        computerScience.register(ciaraMcCarthy);
        
        // print out all courses and associated modules
        System.out.println("**********************************************");
        System.out.println("\t\tCourses");
        System.out.println("**********************************************");
        System.out.println("Course Name\t\tModules");
        
        String courseString = "-----------\t\t-------";
        for (int j=0; j<courses.size(); j++) {
            courseString += "\n" + courses.get(j).getName();
            if (courses.get(j).getModules().size() > 0) {
                courseString += "\t" + courses.get(j).getModules().get(0).getName();
                for (int i=1; i<courses.get(j).getModules().size(); i++) {
                    courseString += "\n\t\t\t" + courses.get(j).getModules().get(i).getName();
                }
            }
        }
        System.out.println(courseString);
        System.out.println("**********************************************");
        
        // print out all students, usernames, registered modules and registered course
        System.out.println("******************************************************************************************");
        System.out.println("\t\t\t\t\tStudents");
        System.out.println("******************************************************************************************");
        System.out.println("Name\t\tUsername\t\tModules\t\t\tCourses");
        System.out.println("----\t\t--------\t\t-------\t\t\t-------");
        
        for (int i=0; i<students.size(); i++) {
            Student student = students.get(i);
            String course = "";
            String studentString = student.getName() + "\t" + student.getUsername();
            // loop through modules and courses to find modules and courses student is enrolled in
            ArrayList<String> moduleNames = new ArrayList<String>();
            
            for (int m=0; m<modules.size(); m++) {
                for (int s=0; s<modules.get(m).getStudents().size(); s++) {
                    if (modules.get(m).getStudents().get(s) == student) {
                        moduleNames.add(modules.get(m).getName());
                    }
                }
            }
            for (int c=0; c<courses.size(); c++) {
                for (int s=0; s<courses.get(c).getStudents().size(); s++) {
                    if (courses.get(c).getStudents().get(s) == student) {
                        // a student can only be registered for one course
                        course = courses.get(c).getName();
                    }
                }
            }
            if (moduleNames.size() > 0) {
                if (student.getUsername().length() > 12) {
                    studentString += "\t" + moduleNames.get(0);
                }
                else {
                    studentString += "\t\t" + moduleNames.get(0);
                }
                studentString += "\t" + course;
                moduleNames.remove(0);
                if (moduleNames.size() > 0) {
                    for (int mn=0; mn<moduleNames.size(); mn++) {
                        studentString += "\n\t\t\t\t\t" + moduleNames.get(mn);
                    }
                }
            }
            System.out.println(studentString);
            System.out.println("******************************************************************************************");
        }
    }
}
