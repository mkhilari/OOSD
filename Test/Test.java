package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Test {

    public static void main(String[] args) {

        HashMap<String, Integer> personAge = new HashMap<>();

        personAge.put("John", 30);
        personAge.put("John", 45);

        int x = personAge.get("John");

        System.out.println("x = " + x);
    }
    
}

interface Drinkable {

    public int drink();
}

class Can implements Drinkable, Comparable<Drinkable> {

    public int drink() {
        return 2;
    }

    public int compareTo(Drinkable other) {
        return this.drink() - other.drink();
    }
}
