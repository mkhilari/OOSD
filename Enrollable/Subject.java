package Enrollable;

import java.util.ArrayList;

public class Subject implements Comparable<Subject>, Enrollable<Student> {
    
    private int subjectNumber;
    private String name;
    private ArrayList<Student> students;

    public Subject(int subjectNumber, String name) {
        this.subjectNumber = subjectNumber;
        this.name = name; 

        // Create students 
        this.students = new ArrayList<>();
    }

    public int getSubjectNumber() {
        return this.subjectNumber;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public void addStudent(Student newStudent) {
        this.students.add(newStudent);
    }

    public int compareTo(Subject other) {
        return this.subjectNumber - other.subjectNumber;
    }

    public void enrol(Student newStudent) {
        addStudent(newStudent);

        // Update newStudent subjects 
        newStudent.addSubject(this);
    }
}
