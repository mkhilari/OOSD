package Frozen;

public class Main {

    public static void main(String[] args) {

        // Create can 
        Can aCan = new Can("Monster Zero Ultra", 500, 10);

        try {
            
            aCan.drink();

            aCan.setTemperature(-10);

            aCan.drink();
        } catch (FrozenException e) {
            
            System.out.println(e.getMessage());
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}
