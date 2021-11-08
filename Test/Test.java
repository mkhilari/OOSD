package Test;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            A.add(i, i);
        }

        A.add(4, 0);

        for (int a : A) {

            System.out.print(a + " ");
        }

        System.out.println();

        ArrayList<FighterJet> fighterJets = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            double speed = 300 + 80 * i;

            FighterJet newFighterJet = new FighterJet(speed);

            fighterJets.add(newFighterJet);
        }

        try {

            fighterJets.get(0).Attack(fighterJets.get(3));
        } catch (ExplosionException explosionException) {

        } catch (DamageException damageException) {

        } catch (Exception exception) {

        }
    }
    
}

class FighterJet {

    private double speed;

    public FighterJet(double speed) {

        this.speed = speed;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double speed) {

        // speed is >= 0 
        this.speed = Math.max(0, speed);
    }

    public void Attack(FighterJet other) 
    throws DamageException, ExplosionException {

        // Attack other 
    }
}

class DamageException extends Exception {

    public DamageException() {

        super("Damage taken");
    }

    public DamageException(String message) {

        super(message);
    }
}

class ExplosionException extends DamageException {

    public ExplosionException() {
        
        super("An explosion exploded");
    }

    public ExplosionException(String message) {

        super(message);
    }
}