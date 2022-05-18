package School;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    
    public static void allocateTeaching(ArrayList<StaffMember> staff, 
    ArrayList<Subject> subjects) {

        Collections.sort(staff);
        Collections.sort(subjects);

        for (Subject subject : subjects) {

            for (StaffMember staffMember : staff) {

                if (!staffMember.getCluster().equals(subject.getCluster())) {

                    continue;
                }

                subject.allocate(staffMember);
            }
        }
    }
}
