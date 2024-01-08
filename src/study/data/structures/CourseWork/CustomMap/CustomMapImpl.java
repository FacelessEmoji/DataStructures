package study.data.structures.CourseWork.CustomMap;

import study.data.structures.CourseWork.List.CustomListImpl;
import java.util.Iterator;

public class CustomMapImpl<K, V> implements CustomMap<K, V>, Iterable<CustomKeyValue<K, V>> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.80d;
    private CustomListImpl<CustomKeyValue<K, V>>[] slots;
    private int count;
    private int capacity;

    public CustomMapImpl() {
        this(INITIAL_CAPACITY);
    }

    public CustomMapImpl(int capacity) {
        this.capacity = capacity;
        this.slots = new CustomListImpl[capacity];
        for (int i = 0; i < capacity; i++) {
            this.slots[i] = new CustomListImpl<>();
        }
        this.count = 0;
    }

    @Override
    public void put(K key, V value) {
        growIfNeeded();
        int slotNumber = findSlotNumber(key);
        CustomListImpl<CustomKeyValue<K, V>> slot = slots[slotNumber];

        for (CustomKeyValue<K, V> keyValue : slot) {
            if (keyValue.getKey().equals(key)) {
                keyValue.setValue(value);
                return;
            }
        }

        slot.addLast(new CustomKeyValue<>(key, value));
        count++;
    }

    @Override
    public V get(K key) {
        int slotNumber = findSlotNumber(key);
        CustomListImpl<CustomKeyValue<K, V>> slot = slots[slotNumber];
        for (CustomKeyValue<K, V> keyValue : slot) {
            if (keyValue.getKey().equals(key)) {
                return keyValue.getValue();
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return find(key) != null;
    }

    @Override
    public V remove(K key) {
        int slotNumber = findSlotNumber(key);
        CustomListImpl<CustomKeyValue<K, V>> slot = slots[slotNumber];

        for (CustomKeyValue<K, V> keyValue : slot) {
            if (keyValue.getKey().equals(key)) {
                slot.remove(keyValue); // Предполагается, что CustomListImpl имеет метод remove
                count--;
                return keyValue.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            slots[i].removeAll();
        }
        count = 0;
    }

    @Override
    public Iterable<K> keys() {
        CustomListImpl<K> keysList = new CustomListImpl<>();
        for (CustomListImpl<CustomKeyValue<K, V>> slot : slots) {
            for (CustomKeyValue<K, V> keyValue : slot) {
                keysList.addLast(keyValue.getKey());
            }
        }
        return keysList;
    }

    @Override
    public Iterable<V> values() {
        CustomListImpl<V> valuesList = new CustomListImpl<>();
        for (CustomListImpl<CustomKeyValue<K, V>> slot : slots) {
            for (CustomKeyValue<K, V> keyValue : slot) {
                valuesList.addLast(keyValue.getValue());
            }
        }
        return valuesList;
    }

    @Override
    public Iterator<CustomKeyValue<K, V>> iterator() {
        return new Iterator<>() {
            private int currentSlot = 0;
            private Iterator<CustomKeyValue<K, V>> slotIterator = slots[0].iterator();

            @Override
            public boolean hasNext() {
                while (currentSlot < capacity) {
                    if (slotIterator.hasNext()) {
                        return true;
                    }
                    if (++currentSlot < capacity) {
                        slotIterator = slots[currentSlot].iterator();
                    }
                }
                return false;
            }

            @Override
            public CustomKeyValue<K, V> next() {
                return slotIterator.next();
            }
        };
    }

    private int findSlotNumber(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    private void growIfNeeded() {
        if ((double) (size() + 1) / capacity > LOAD_FACTOR) {
            grow();
        }
    }

    private void grow() {
        CustomMapImpl<K, V> newTable = new CustomMapImpl<>(capacity * 2);
        for (CustomListImpl<CustomKeyValue<K, V>> slot : slots) {
            for (CustomKeyValue<K, V> keyValue : slot) {
                newTable.put(keyValue.getKey(), keyValue.getValue());
            }
        }
        slots = newTable.slots;
        capacity = newTable.capacity;
    }

    private CustomKeyValue<K, V> find(K key) {
        int slotNumber = findSlotNumber(key);
        CustomListImpl<CustomKeyValue<K, V>> slot = slots[slotNumber];
        for (CustomKeyValue<K, V> keyValue : slot) {
            if (keyValue.getKey().equals(key)) {
                return keyValue;
            }
        }
        return null;
    }
}

