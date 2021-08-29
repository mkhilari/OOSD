import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Subject aSubject = new Subject(20003, "OOSD");

        // Sort array of students 
        Arrays.sort(aSubject.getStudents().toArray());
    }
}