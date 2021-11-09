package Categoriser;

import java.util.ArrayList;
import java.util.HashMap;

public class CategoryMap<K, V, C extends Categoriser<K, V>> {
    
    private HashMap<K, ArrayList<V>> categoryValues = new HashMap<>();
    private C categoriser;

    public CategoryMap(C categoriser) {

        this.categoriser = categoriser;
    }

    public HashMap<K, ArrayList<V>> getCategoryValues() {
        return this.categoryValues;
    }

    public void add(V newValue) {

        K category = this.categoriser.getCategory(newValue);

        if (this.getCategoryValues().get(category) == null) {

            this.getCategoryValues().put(category, new ArrayList<>());
        }

        this.getCategoryValues().get(category).add(newValue);
    }

    public int getCategorySize(V value) {

        K category = categoriser.getCategory(value);

        if (this.getCategoryValues().get(category) == null) {

            return 0;
        }

        return this.getCategoryValues().get(category).size();
    }

    public String toString() {

        String s = "";

        for (K category : this.getCategoryValues().keySet()) {

            String line = category.toString() + ": [";

            for (V value : this.getCategoryValues().get(category)) {

                line += value.toString() + ", ";
            }

            line = line.substring(0, line.length() - 2);
            line += "]\n";

            s += line;
        }

        return s;
    }
}
