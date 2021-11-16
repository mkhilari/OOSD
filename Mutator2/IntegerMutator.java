package Mutator2;

public class IntegerMutator implements Mutator<Integer> {
    
    private int n;

    public IntegerMutator(int n) {

        this.n = n;
    }

    public int getN() {
        return this.n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Integer mutate(Integer input) {

        return input % this.getN();
    }
}
