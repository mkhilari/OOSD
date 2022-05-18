package Town2;

import java.util.ArrayList;

public class Castle {
    
    private Royal king;
    private double value;

    private ArrayList<Guard> guards = new ArrayList<>();

    public Castle(Royal king, double value) {

        this.king = king;
        this.value = value;
    }

    public Royal getKing() {
        return this.king;
    }

    public double getValue() {
        return this.value;
    }

    public ArrayList<Guard> getGuards() {
        return this.guards;
    }

    public void setKing(Royal king) {
        this.king = king;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
