package Category;

import java.util.ArrayList;
import java.util.HashMap;

public class CategorisedMap<K, V, C extends Categoriser<V, K>> {
    
    private HashMap<K, ArrayList<V>> map = new HashMap<>();
    private C categoriser;

    public CategorisedMap(C categoriser) {

        this.categoriser = categoriser;
    }

    void put(V value) {

        K key = categoriser.categorise(value);

        if (map.containsKey(key)) {

            map.put(key, new ArrayList<>());
        }

        map.get(key).add(value);
    }

    int getCategoryCount(V value) {

        K key = categoriser.categorise(value);

        if (!map.containsKey(key)) {

            return 0;
        }
        return map.get(key).size();
    }
}
