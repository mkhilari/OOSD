package Enrollable;

import java.util.ArrayList;

public class Course implements Comparable<Course>, Enrollable<Student> {
    
    private int courseNumber;
    private String name;
    private ArrayList<Subject> subjects;
    private ArrayList<Student> students;

    public Course(int courseNumber, String name) {
        this.courseNumber = courseNumber;
        this.name = name;

        // Create subjects 
        this.subjects = new ArrayList<>();

        // Create students 
        this.students = new ArrayList<>();
    }

    public int getCourseNumber() {
        return this.courseNumber;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Subject> getSubjects() {
        return this.subjects;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public void addSubject(Subject newSubject) {
        this.subjects.add(newSubject);
    }

    public void addStudent(Student newStudent) {
        this.students.add(newStudent);
    }

    public int compareTo(Course other) {
        return this.courseNumber - other.courseNumber;
    }

    public void enrol(Student newStudent) {
        addStudent(newStudent);
    }
}
