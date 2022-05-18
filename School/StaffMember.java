package School;

import java.util.ArrayList;

public class StaffMember extends CISBase implements Allocatable<Subject> {
    

    private ArrayList<Subject> subjects = new ArrayList<>();

    public StaffMember(String id, Cluster cluster, 
    Integer totalLoad) {

        super(id, cluster, totalLoad);
    }

    public ArrayList<Subject> getSubjects() {
        return this.subjects;
    }

    public void allocate(Subject subject) {

        this.getSubjects().add(subject);
    }
}
