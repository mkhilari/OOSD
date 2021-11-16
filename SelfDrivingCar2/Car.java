package SelfDrivingCar2;

import java.util.ArrayList;

public class Car {
    
    private boolean poweredOn = false;
    private double dangerThreshold;

    private ArrayList<Sensor> sensors = new ArrayList<>();

    public Car(double dangerThreshold) {

        this.dangerThreshold = dangerThreshold;
    }

    public Car(double dangerThreshold, ArrayList<Sensor> sensors) {

        this(dangerThreshold);

        this.sensors = sensors;
    }

    public boolean getPoweredOn() {
        return this.poweredOn;
    }

    public double getDangerThreshold() {
        return this.dangerThreshold;
    }

    public ArrayList<Sensor> getSensors() {
        return this.sensors;
    }

    public void setPoweredOn(boolean poweredOn) {
        this.poweredOn = poweredOn;
    }

    public void setDangerThreshold(double dangerThreshold) {
        this.dangerThreshold = dangerThreshold;
    }

    public int measureSensors() {

        int numDangers = 0;

        for (Sensor sensor : this.getSensors()) {

            double measurement = sensor.measure();

            System.out.println("Sensor " + sensor.getId() 
            + ": " + measurement);

            if (Double.compare(measurement, this.getDangerThreshold()) > 0) {
                
                numDangers += 1;
            }
        }

        System.out.println(numDangers + " sensors above threshold");

        return numDangers;
    }

    public boolean dangerImminent() {

        if (this.getSensors().size() < 4) {

            return true;
        }

        if (this.measureSensors() >= 7) {

            return true;
        }

        return false;
    }

    public void operate() {

    }

    public void run() {

        this.setPoweredOn(true);

        while (!this.dangerImminent()) {

            this.operate();
        }

        this.setPoweredOn(false);
    }
}
