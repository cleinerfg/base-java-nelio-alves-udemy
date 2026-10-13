package org.example.projects.course_platform.entities;

import java.util.HashSet;
import java.util.Set;

public class Course {

    private String name;
    private String teacher;
    private Set<String> students = new HashSet<>();

    public Course(String name, String teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    public Set<String> getStudents() {
        return students;
    }

    public void addStudent(String student) {
        students.add(student);
    }
}
