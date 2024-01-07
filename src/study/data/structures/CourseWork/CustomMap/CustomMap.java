package study.data.structures.CourseWork.CustomMap;

public interface CustomMap<K, V> {
    void put(K key, V value); // Добавить элемент
    V get(K key);             // Получить элемент по ключу
    boolean containsKey(K key); // Проверить наличие ключа
    V remove(K key);         // Удалить элемент по ключу
    int size();              // Получить размер карты
    void clear();            // Очистить карту
    Iterable<K> keys();      // Получить все ключи
    Iterable<V> values();    // Получить все значения
}

