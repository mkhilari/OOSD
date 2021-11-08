package Town;

import java.util.ArrayList;

public class Royal extends Person {

    public static final int MAX_CASTLES = 3;

    private ArrayList<Castle> castles = new ArrayList<>();
    private ArrayList<Servant> servants = new ArrayList<>();

    public Royal(String name, int age) throws NoNameException {

        super(name, age);
    }

    protected ArrayList<Castle> getCastles() {
        return this.castles;
    }
    
    public ArrayList<Servant> getServants() {
        return this.servants;
    }

    public double getTotalWealth() {

        double totalWealth = 0;

        for (Servant servant : this.getServants()) {

            totalWealth += servant.getCost();
        }

        return totalWealth;
    }

    public void addCastle(Castle newCastle) throws TooManyCastlesException {

        if (this.getCastles().size() >= MAX_CASTLES) {
            
            throw new TooManyCastlesException(MAX_CASTLES);
        }

        this.getCastles().add(newCastle);
    }
}
