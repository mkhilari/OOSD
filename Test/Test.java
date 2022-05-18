package Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test {

    private int n;

    public static void main(String[] args) {

        List<Integer> A = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            A.add(i, i);
        }

        A.remove(3);

        A.add(1, 2);

        System.out.println(A.size() + " " + A.get(2) + " " + A.get(3));

        ArrayList<FighterJet> fighterJets = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            double speed = 300 + 80 * i;

            FighterJet newFighterJet = new FighterJet(speed);

            fighterJets.add(newFighterJet);
        }

        try {

            fighterJets.get(0).attack(fighterJets.get(3));
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

    public void attack(FighterJet other) 
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

class Dog {

    int age;

    public Dog() {

        this(5);
    }

    public Dog(int age) {

        this.age = age;
    }
}