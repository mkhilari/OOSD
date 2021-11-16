package Mutator2;

public class Main {
    
    public static void main(String[] args) {

        IntegerMutator mutator = new IntegerMutator(30);

        MutatingList<Integer, IntegerMutator> mList 
        = new MutatingList<>(mutator);

        mList.add(100);
        mList.add(72);
        mList.add(500);

        System.out.println(mList.mutateIndex(2));
        System.out.println(mList);
    }
}
