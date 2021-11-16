package Mutator;

import java.util.ArrayList;

public class MutatingList<T, M extends Mutator<T>> {
    
    private M mutator;

    private ArrayList<T> values = new ArrayList<>();

    public MutatingList(M mutator) {

        this.mutator = mutator;
    }

    public MutatingList(M mutator, ArrayList<T> values) {

        this(mutator);

        this.values = values;
    }

    public M getMutator() {
        return this.mutator;
    }

    public ArrayList<T> getValues() {
        return this.values;
    }

    public void setMutator(M mutator) {
        this.mutator = mutator;
    }

    public void add(T element) {

        this.getValues().add(element);
    }

    public T mutateIndex(int index) {

        return this.getMutator()
        .mutate(this.getValues().get(index));
    }

    public ArrayList<T> mutateList() {

        for (int i = 0; i < this.getValues().size(); i++) {

            this.mutateIndex(i);
        }

        return this.getValues();
    }

    public String toString() {

        String s = "";

        for (int i = 0; i < this.getValues().size(); i++) {

            s += this.getValues().get(i) + 
            " -> " + this.getMutator().mutate(this.getValues().get(i))
            + "\n";
        }

        return s;
    }
}
