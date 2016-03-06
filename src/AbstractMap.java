import java.util.*;
/**
 * @author williamshyr
 *
 * @param <K>
 * @param <V>
 */
public abstract class AbstractMap<K,V> implements Map<K,V> {
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * @param <K>
     * @param <V>
     */
    protected static class MapEntry<K,V> implements Entry<K,V> {
        private K k;
        private V v;
        /**
         * @param key
         * @param value
         */
        public MapEntry(K key, V value) {
            k = key;
            v = value;
        }
        
        public K getKey() {
            return k;
        }
        
        public V getValue() {
            return v;
        }
        protected void setKey(K key) {
            k = key;
        }
        protected V setValue(V value) {
            V old = v;
            v = value;
            return old;
        }
    }
} //--------- end of nested MapEntry class --------

//Support for public keySet method
private class KeyIterator implements Iterator<K> {
    private Iterator<Entry<K,V>> entries = entrySet().iterator();
    public boolean hasNext() {
        return entries.hasNext();
    }
    public K next() {
        return entries.next().getKey();
    }
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
private class KeyIterable implements Iterable<K> {
    public Iterator<K> iterator() {
        return new KeyIterator();
    }
public Iterable<K> keySet() {
    return new KeyIterable();
}
private class ValueIterator implmements Iterator<V> {
    private Iterator<Entry<K,V>> entries = entrySet().iterator();
    public boolean hasNext() {
        return entries.hasNext();
    }
    public V next() {
        return entries.next().getValue
    }
    public void remove() {
        throw neew UnsupportedOperationException();
    }
}
private class ValueIterable implements Iterable<V> {
    public Iterator<V> iterator() {
    return new ValueIterator();
    }
    public Iterable<V> values() {
        return new ValueIterable();
    }
}

    }
    
}





