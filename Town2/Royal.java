package Town2;

import java.util.ArrayList;

public class Royal extends Person {

    private ArrayList<Castle> castles = new ArrayList<>();
    private ArrayList<Servant> servants = new ArrayList<>();

    public Royal(String name, int age) {

        super(name, age);
    }

    public ArrayList<Castle> getCastles() {
        return this.castles;
    }

    public ArrayList<Servant> getServants() {
        return this.servants;
    }

    public double getTotalWealth() {

        double castleWealth = 0;

        for (Castle castle : this.getCastles()) {

            castleWealth += castle.getValue();
        }

        double servantWealth = 0;

        for (Servant servant : this.getServants()) {

            servantWealth += servant.getCost();
        }

        double totalWealth = castleWealth + servantWealth;

        return totalWealth;
    }
}
