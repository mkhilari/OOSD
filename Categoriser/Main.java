package Categoriser;

public class Main {
    
    public static void main(String[] args) {

        CategoryMap<String, String, StringCategoriser> aCategoryMap 
        = new CategoryMap<>(new StringCategoriser());

        aCategoryMap.add("Hulk");
        aCategoryMap.add("Hawkeye");
        aCategoryMap.add("Thanos");

        System.out.println(aCategoryMap.toString());
    }
}
