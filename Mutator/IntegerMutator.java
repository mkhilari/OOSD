package Mutator;

public class IntegerMutator implements Mutator<Integer> {

    private int n;

    public IntegerMutator(int n) {

        this.n = n;
    }
    
    public Integer mutate(Integer input) {

        input = input % n;

        return input;
    }

    public int getN() {
        return this.n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
