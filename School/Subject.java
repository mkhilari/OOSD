package School;

import java.util.ArrayList;
import java.util.HashMap;

public class Subject extends CISBase implements Allocatable<StaffMember> {
    

    private HashMap<StaffMember, Integer> staffLoad = new HashMap<>();

    public Subject(String id, Cluster cluster, 
    Integer totalLoad) {

        super(id, cluster, totalLoad);
    }

    public HashMap<StaffMember, Integer> getStaffLoad() {
        return this.staffLoad;
    }

    public void allocate(StaffMember staffMember) {

        if (staffMember.getUnallocatedLoad() <= 0) {
            
            return;
        }

        if (this.getUnallocatedLoad() 
        < staffMember.getUnallocatedLoad()) {

            int load = this.getUnallocatedLoad();

            this.getStaffLoad().put(staffMember, load);

            this.setUnallocatedLoad(0);
            staffMember.setUnallocatedLoad(staffMember.getUnallocatedLoad() 
            - load);
        }

        if (this.getUnallocatedLoad() 
        > staffMember.getUnallocatedLoad()) {

            int load = staffMember.getUnallocatedLoad();

            this.getStaffLoad().put(staffMember, load);

            this.setUnallocatedLoad(this.getUnallocatedLoad() 
            - load);
            staffMember.setUnallocatedLoad(0);
        }

        staffMember.allocate(this);
    }
}
