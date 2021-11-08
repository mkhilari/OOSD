package Town;

public class Servant extends Slave {
    
    private Person master;

    public Servant(String name, int age, double cost, 
    Person master) throws NoNameException {

        super(name, age, cost);

        this.master = master;
    }

    public Person getMaster() {
        return this.master;
    }

    public void setMaster(Person master) {
        this.master = master;
    }
}
