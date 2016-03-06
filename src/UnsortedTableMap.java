import java.util.ArrayList;

public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {
    /** Underlying storage for the map entries. */
    private ArrayList<MapEntry<K, V>> table = new ArrayList<>();

    /** Constructs and initially empty map. */
    public UnsortedTableMap() {
    }

    // private utility
    /**
     * @ return index of an entry with equal key, or -1 if non found
     */
    private int findIndex(K key) {
        int n = table.size();
        for (int j = 0; j < n; j++) {
            if (table.get(j).getKey().equals(key)) {
                return j;
            }
        }
        return -1;
    }

    public int size() {
        return table.size();
    }

    public V get(K key) {
        int j = findIndex(key);
        if (j == -1)
            return null;
        return table.get(j).getValue();
    }

    public V put(K key, V value) {
        int j = findIndex(key);
        if (j == -1) {
            table.add(new MapEntry<>(key, value));
            return null;
        } else {
            return table.get(j).setValue(value);
        }
    }

    public V remove(K key) {
        int j = findIndex(key);
        int n = size();
        if (j == -1) {
            return null;
        }
        V answer = table.get(j).getValue();
        if (j != n - 1) {
          //relocate last entry to hole created by removal
            table.set(j,  table.get(n-1));
        }
        
        table.remove(n-1);
        return answer;
}
    private class EntryIterator implements Iterator<Entry<K,V>> {
        private int j = 0;
        public boolean hasNext() {
            return j < table.size();
        }
        
        
        public Entry<K,V> next() {
            if (j == table.size()) {
                throw new NoSuchElemetnException();
            }
        }
    }

}