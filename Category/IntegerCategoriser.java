package Category;

public class IntegerCategoriser implements Categoriser<Integer, Integer> {
    
    public Integer categorise(Integer input) {

        while (input > 10) {

            input = input / 10;
        }

        return input;
    }
}
