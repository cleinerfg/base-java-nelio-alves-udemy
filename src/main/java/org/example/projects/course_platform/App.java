package org.example.projects.course_platform;

import org.example.projects.course_platform.entities.Course;

import java.util.HashSet;
import java.util.Set;

public class App {

    static void main(String[] args) {
        Course c1 = new Course("A", "Alex");
        Course c2 = new Course("B", "Alex");
        Course c3 = new Course("C", "Alex");

        c1.addStudent("Mariana");
        c1.addStudent("Lucas");
        c2.addStudent("Beatriz");
        c2.addStudent("Luan");
        c2.addStudent("Gabriel");
        c3.addStudent("Mariana");
        c3.addStudent("Rafael");
        c1.addStudent("Sofia");
        c2.addStudent("Lucas");
        c3.addStudent("Mateus");
        c1.addStudent("Beatriz");
        c2.addStudent("Sofia");
        c3.addStudent("Gabriel");
        c1.addStudent("Rafael");
        c3.addStudent("Mateus");

        Set<String> students = new HashSet<>();
        students.addAll(c1.getStudents());
        students.addAll(c2.getStudents());
        students.addAll(c3.getStudents());

        System.out.println("Distinct students: " + students);
        System.out.println(("Total distinct students: " + students.size()));
    }
}
