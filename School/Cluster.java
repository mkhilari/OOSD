package School;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Cluster {
    
    private String clusterID;

    private ArrayList<Subject> subjects = new ArrayList<>();

    public Cluster(String clusterID) {

        this.clusterID = clusterID;
    }

    public String getClusterID() {
        return this.clusterID;
    }

    public ArrayList<Subject> getSubjects() {
        return this.subjects;
    }

    public boolean equals(Cluster other) {

        return this.getClusterID().equals(other.getClusterID());
    }

    public String toString() {

        return this.getClusterID();
    }
}
