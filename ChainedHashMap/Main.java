package ChainedHashMap;

public class Main {
    
    public static void main(String[] args) {

        ChainedHashMap<Integer, String> aChainedHashMap 
        = new ChainedHashMap<>();

        aChainedHashMap.put(2, "Hello");
        aChainedHashMap.put(2, "there");
        aChainedHashMap.put(7, "Seven");
        aChainedHashMap.put(1, "Start");
        aChainedHashMap.put(1, "the");
        aChainedHashMap.put(1, "map");

        System.out.println(aChainedHashMap);
    }
}
