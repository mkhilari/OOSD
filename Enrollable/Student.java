import java.util.ArrayList;

public class Student implements Comparable<Student> {
    
    private int studentNumber;
    private String name;
    private ArrayList<Subject> subjects;

    public Student(int studentNumber, String name) {
        this.studentNumber = studentNumber;
        this.name = name;

        // Create subjects 
        this.subjects = new ArrayList<>();
    }

    public int getStudentNumber() {
        return this.studentNumber;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Subject> getSubjects() {
        return this.subjects;
    }

    public void addSubject(Subject newSubject) {
        this.subjects.add(newSubject);
    }

    public int compareTo(Student other) {
        return this.studentNumber - other.studentNumber;
    }
}
