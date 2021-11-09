package Town;

import java.util.ArrayList;

public class Castle {
    
    private double value;
    private Royal king;

    private ArrayList<Guard> guards = new ArrayList<>();

    public Castle(double value, Royal king) {

        this.value = value;
        this.king = king;
    }

    public double getValue() {
        return this.value;
    }

    public Royal getKing() {
        return this.king;
    }

    public ArrayList<Guard> getGuards() {
        return this.guards;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setKing(Royal king) {
        this.king = king;
    }
}
