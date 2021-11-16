package Mutator2;

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

        T value = this.getValues().get(index);

        return this.getMutator().mutate(value);
    }

    public ArrayList<T> mutateList() {

        ArrayList<T> newList = new ArrayList<>();

        for (T value : this.getValues()) {

            T newValue = this.getMutator().mutate(value);

            newList.add(newValue);
        }

        return newList;
    }

    public String toString() {

        String s = "";

        for (T value : this.getValues()) {

            T newValue = this.getMutator().mutate(value);

            s += value + " -> " + newValue + "\n";
        }

        return s;
    }

    public String toString2() {

        String s = "";

        ArrayList<T> newValues = this.mutateList();

        for (int i = 0; i < this.getValues().size(); i++) {

            s += this.getValues().get(i) 
            + " -> " + newValues.get(i) + "\n";
        }

        return s;
    }
}
