package Workshops; 

import java.util.ArrayList;

class Meeting {
    static final int MAX_PEOPLE = 25;
    static final int MAX_ON_ZOOM = 1000000;
    
    private static int numPeopleOnZoom = 0;

    private int numPeople;
    private Participant host;
    private ArrayList<Participant> people;

    public Meeting(Participant host) {
        // Host is a participant 
        this.numPeople = 1;
        this.host = host;

        this.people = new ArrayList<Participant>();
        this.people.add(host);

        Meeting.numPeopleOnZoom += 1;
    }

    public void addParticipant(Participant person) {
        if (numPeople < MAX_PEOPLE && numPeople < MAX_ON_ZOOM) {
            // Add person 
            this.numPeople += 1;
            Meeting.numPeopleOnZoom += 1;

            this.people.add(person);
        }
    }

    public String getHostName() {
        return this.host.getName();
    }
}

class Participant {
    private String name;
    private boolean videoOn = false;
    private boolean muted = true;

    public Participant(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void joinMeeting(Meeting workshop) {
        workshop.addParticipant(this);

        // participants would kindly greet the meeting's host after joining:)
        this.videoOn = true;
        this.muted = false;

        System.out.println(this.name + " says hi to " + workshop.getHostName());
    }
}