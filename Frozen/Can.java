package Frozen;

public class Can implements Drinkable {
    
    private String name;
    private double volume;
    private double temperature;

    public Can(String name, double volume, double temperature) {

        this.name = name;
        this.volume = volume;
        this.temperature = temperature;
    }

    public Can(String name) {

        this.name = name;
        this.volume = DEFAULT_VOLUME;
        this.temperature = DEFAULT_TEMPERATURE;
    }

    public String getName() {
        return this.name;
    }

    public double getVolume() {
        return this.volume;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void drink() throws FrozenException, Exception {

        // Check temperature 
        if (this.getTemperature() <= 0) {
            throw new FrozenException();
        }

        if (this.getVolume() <= 0) {
            throw new Exception("Can empty");
        }

        this.setVolume(0);
        System.out.println("Drinkable drank");
    }
}
