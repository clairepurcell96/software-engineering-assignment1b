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
        Module softwareEng = new Module("Software Engineering", "CT000");
        Module databases = new Module("Database Systems", "CT123");
        Module machineLearning = new Module("Machine Learning", "CT456");

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
        
        ArrayList<Module> modules = new ArrayList<Module>(3);
        modules.add(softwareEng);
        modules.add(databases);
        modules.add(machineLearning);
        
        ArrayList<CourseProgramme> courses = new ArrayList<CourseProgramme>(2);
        courses.add(computerEngineering);
        courses.add(computerScience);
        
        // add various students to various modules
        softwareEng.register(johnDoe);
        softwareEng.register(markSmith);
        softwareEng.register(maryRyan);
        softwareEng.register(ciaraMcCarthy);
        
        databases.register(janeDoe);
        databases.register(maryRyan);
        databases.register(conorOdonnell);
        databases.register(ciaraMcCarthy);
        
        machineLearning.register(johnDoe);
        machineLearning.register(janeDoe);
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
        
        for (int j=0; j<courses.size(); j++) {
            System.out.println(courses.get(j).getName() + " - Modules: ");
            for (int i=0; i<courses.get(j).getModules().size(); i++) {
                System.out.println(courses.get(j).getModules().get(i).getName());
            }
        }
        
        System.out.println("******************************************************************************************");
        System.out.println("\t\t\t\t\tStudents");
        System.out.println("******************************************************************************************");
        System.out.println("Name\t\tUsername\t\tModules\t\t\tCourses");
        System.out.println("----\t\t--------\t\t-------\t\t\t-------");
        
        for (int i=0; i<students.size(); i++) {
            String studentString = "";
            Student student = students.get(i);
            // loop through modules and courses to find modules and courses student is enrolled in
            ArrayList<Student> registeredModules = new ArrayList<Student>();
            ArrayList<Student> registeredCourses = new ArrayList<Student>();
            ArrayList<String> moduleNames = new ArrayList<String>();
            
            for (int m=0; m<modules.size(); m++) {
                for (int s=0; s<modules.get(m).getStudents().size(); s++) {
                    if (modules.get(m).getStudents().get(s) == student) {
                        moduleNames.add(modules.get(m).getName());
                    }
                }
            }
            // add courses to string
            for (int c=0; c<courses.size(); c++) {
                for (int s=0; s<courses.get(c).getStudents().size(); s++) {
                    if (courses.get(c).getStudents().get(s) == student) {
                        
                    }
                }
            }
            if (moduleNames.size() > 0) {
                if (student.getUsername().length() > 12) {
                    studentString += student.getName() + "\t" + student.getUsername() + "\t" + moduleNames.get(0);
                }
                else {
                    studentString += student.getName() + "\t" + student.getUsername() + "\t\t" + moduleNames.get(0);
                }
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
