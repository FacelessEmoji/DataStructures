package study.data.structures.Hashtable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class HashTable<K, V> implements Iterable<KeyValue<K, V>> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.80d;
    private LinkedList<KeyValue<K, V>>[] slots;
    private int count;
    private int capacity;

    // Конструктор без параметров
    public HashTable() {
        this(INITIAL_CAPACITY);
    }

    // Конструктор с указанной емкостью
    public HashTable(int capacity) {
        this.capacity = capacity;
        this.slots = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            this.slots[i] = new LinkedList<>();
        }
        this.count = 0;
    }

    // Метод для добавления элемента
    public void add(K key, V value) {
        this.growIfNeeded();
        int slotNumber = this.findSlotNumber(key);
        LinkedList<KeyValue<K, V>> slot = this.slots[slotNumber];
        for (KeyValue<K, V> keyValue : slot) {
            if (keyValue.getKey().equals(key)) {
                keyValue.setValue(value);
                return;
            }
        }
        slot.add(new KeyValue<>(key, value));
        this.count++;
    }

    // Метод для вычисления номера слота
    private int findSlotNumber(K key) {
        return Math.abs(key.hashCode()) % this.capacity;
    }

    // Метод для проверки необходимости роста хеш-таблицы
    private void growIfNeeded() {
        if ((double) (this.size() + 1) / this.capacity() > LOAD_FACTOR) {
            this.grow();
        }
    }

    // Метод для увеличения размера хеш-таблицы
    private void grow() {
        HashTable<K, V> newTable = new HashTable<>(this.capacity * 2);
        for (LinkedList<KeyValue<K, V>> slot : this.slots) {
            for (KeyValue<K, V> keyValue : slot) {
                newTable.add(keyValue.getKey(), keyValue.getValue());
            }
        }
        this.slots = newTable.slots;
        this.capacity = newTable.capacity;
    }

    // Метод для получения размера
    public int size() {
        return this.count;
    }

    // Метод для получения емкости
    public int capacity() {
        return this.capacity;
    }

    // Метод для получения значения по ключу
    public V get(K key) {
        int slotNumber = this.findSlotNumber(key);
        LinkedList<KeyValue<K, V>> slot = this.slots[slotNumber];
        for (KeyValue<K, V> keyValue : slot) {
            if (keyValue.getKey().equals(key)) {
                return keyValue.getValue();
            }
        }
        return null;
    }

    public boolean addOrReplace(K key, V value) {
        this.growIfNeeded();
        int slotNumber = this.findSlotNumber(key);
        LinkedList<KeyValue<K, V>> slot = this.slots[slotNumber];

        for (KeyValue<K, V> keyValue : slot) {
            if (keyValue.getKey().equals(key)) {
                keyValue.setValue(value);
                return true; // Замена существующего элемента
            }
        }

        slot.add(new KeyValue<>(key, value));
        this.count++;
        return false; // Добавление нового элемента
    }

    // Найти элемент по ключу
    public KeyValue<K, V> find(K key) {
        int slotNumber = this.findSlotNumber(key);
        LinkedList<KeyValue<K, V>> slot = this.slots[slotNumber];

        for (KeyValue<K, V> keyValue : slot) {
            if (keyValue.getKey().equals(key)) {
                return keyValue;
            }
        }

        return null;
    }

    // Проверка наличия ключа
    public boolean containsKey(K key) {
        return find(key) != null;
    }

    // Удаление элемента по ключу
    public boolean remove(K key) {
        int slotNumber = this.findSlotNumber(key);
        LinkedList<KeyValue<K, V>> slot = this.slots[slotNumber];

        for (KeyValue<K, V> keyValue : slot) {
            if (keyValue.getKey().equals(key)) {
                slot.remove(keyValue);
                this.count--;
                return true;
            }
        }

        return false;
    }

    // Очистить хеш-таблицу
    public void clear() {
        for (int i = 0; i < this.capacity; i++) {
            this.slots[i].clear();
        }
        this.count = 0;
    }

    // Получить все ключи
    public Iterable<K> keys() {
        ArrayList<K> keysList = new ArrayList<>();
        for (LinkedList<KeyValue<K, V>> slot : this.slots) {
            for (KeyValue<K, V> keyValue : slot) {
                keysList.add(keyValue.getKey());
            }
        }
        return keysList;
    }

    // Получить все значения
    public Iterable<V> values() {
        ArrayList<V> valuesList = new ArrayList<>();
        for (LinkedList<KeyValue<K, V>> slot : this.slots) {
            for (KeyValue<K, V> keyValue : slot) {
                valuesList.add(keyValue.getValue());
            }
        }
        return valuesList;
    }



    // Итератор для обхода всех элементов хеш-таблицы
    @Override
    public Iterator<KeyValue<K, V>> iterator() {
        return new Iterator<KeyValue<K, V>>() {
            private int currentSlot = 0;
            private Iterator<KeyValue<K, V>> slotIterator = slots[0].iterator();

            @Override
            public boolean hasNext() {
                if (slotIterator.hasNext()) {
                    return true;
                }
                while (++currentSlot < capacity) {
                    slotIterator = slots[currentSlot].iterator();
                    if (slotIterator.hasNext()) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public KeyValue<K, V> next() {
                return slotIterator.next();
            }
        };
    }
}
