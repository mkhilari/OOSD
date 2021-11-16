package ChainedHashMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class ChainedHashMap<K, V> {
    
    private HashMap<K, ArrayList<V>> values = new HashMap<>();

    public ChainedHashMap() {

    }

    public HashMap<K, ArrayList<V>> getValues() {
        return this.values;
    }

    public ArrayList<V> get(K key) {

        return this.getValues().get(key);
    }

    public void put(K key, V value) {

        if (!this.containsKey(key)) {

            this.getValues().put(key, new ArrayList<>());
        }

        this.get(key).add(value);
    }

    public ArrayList<V> remove(K key) {

        return this.getValues().remove(key);
    }

    public void clear() {

        for (K key : this.keySet()) {

            this.remove(key);
        }
    }

    public Set<K> keySet() {

        return this.getValues().keySet();
    }

    public Collection<ArrayList<V>> values() {

        return this.getValues().values();
    }

    public int size() {
        
        return this.getValues().size();
    }

    public boolean isEmpty() {

        return (this.size() == 0);
    }

    public boolean containsKey(K key) {

        return this.getValues().containsKey(key);
    }

    public boolean containsValue(V value) {

        for (K key : this.keySet()) {

            if (this.get(key).contains(value)) {

                return true;
            }
        }

        return false;
    }

    public String toString() {

        String s = "";

        for (K key : this.keySet()) {

            String keyLine = key + ": ";

            for (V value : this.get(key)) {

                keyLine += value + ", ";
            }

            s += keyLine.substring(0, keyLine.length() - ", ".length()) 
            + "\n";
        }

        return s;
    }
}
