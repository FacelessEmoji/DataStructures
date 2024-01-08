package study.data.structures.CourseWork.CustomMap;

public interface CustomMap<K, V> {
    void put(K key, V value);
    V get(K key);
    boolean containsKey(K key);
    V remove(K key);
    int size();
    void clear();
    Iterable<K> keys();
    Iterable<V> values();
}


