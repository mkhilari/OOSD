package Town;

public class Slave extends Person {
    
    private double cost;
    private boolean isPassive = true;

    public Slave(String name, int age, double cost) throws NoNameException {

        super(name, age);

        this.cost = cost;
    }

    public double getCost() {
        return this.cost;
    }

    public boolean getIsPassive() {
        return this.isPassive;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setIsPassive(boolean isPassive) {
        this.isPassive = isPassive;
    }
}
