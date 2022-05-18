package School;

public abstract class CISBase implements Comparable<CISBase> {

    private String id;
    private Cluster cluster;
    private int totalLoad;
    private Integer unallocatedLoad;

    public CISBase(String id, Cluster cluster, 
    Integer totalLoad) {
        
        this.id = id;
        this.cluster = cluster;
        this.totalLoad = totalLoad;
        this.unallocatedLoad = totalLoad;
    }

    public String getID() {
        return this.id;
    }

    public Cluster getCluster() {
        return this.cluster;
    }

    public Integer getTotalLoad() {
        return this.totalLoad;
    }

    public Integer getUnallocatedLoad() {
        return this.unallocatedLoad;
    }

    public void setUnallocatedLoad(Integer unallocatedLoad) {
        this.unallocatedLoad = unallocatedLoad;
    }

    public int compareTo(CISBase other) {

        // Reversed 
        return - (this.getUnallocatedLoad() - other.getUnallocatedLoad());
    }

    public String toString() {

        String s = "";

        s += this.getID() + "\n";
        s += this.getCluster() + "\n";
        s += this.getTotalLoad() + "\n";
        s += this.getUnallocatedLoad() + "\n";

        return s;
    }
}
