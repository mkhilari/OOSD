package Mutator;

public class Main {
    
    public static void main(String[] args) {

        IntegerMutator mutator = new IntegerMutator(30);

        MutatingList<Integer, IntegerMutator> mList = new MutatingList<>(mutator);

        mList.add(100);
        mList.add(72);
        mList.add(500);

        System.out.println(mList.mutateIndex(2));
        System.out.println(mList);
    }
}

interface Measurable<T> {

    public default T measure() {

        return null;
    }
}

class Stick implements Measurable<Double> {

    private double length;

    public Stick(double length) {
        
        this.length = length;
    }

    public Double measure() {

        return this.getLength();
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}