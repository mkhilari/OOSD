package SelfDrivingCar;

public abstract class Sensor {
    
    private String id;

    public Sensor(String id) {

        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract double measure();

    public String toString() {

        return this.getId();
    }
}
