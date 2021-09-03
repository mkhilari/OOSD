package Can;

public class Can implements Drinkable {

    private String name;
    private int volume;

    public Can(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }

    public String getName() {
        return this.name;
    }

    public int getVolume() {
        return this.volume;
    }

    public void consume() {
        this.drink();
    }

    public void drink() {

        System.out.println(this.getName());

        for (int i = 3 * this.getVolume(); i > 0; i--) {

            for (int j = 0; j < i; j++) {
                System.out.print("/// ");
            }

            System.out.println();
        }

        System.out.println("Ran out");
    }

    public void evaporate() {

        System.out.println(this.getName());

        for (int i = 10 * this.getVolume(); i > 0; i--) {

            for (int j = 0; j < i; j++) {
                System.out.print("^^^ ");
            }

            System.out.println();
        }

        System.out.println("Evaporated");
    }
}