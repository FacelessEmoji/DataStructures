package study.data.structures.Queue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnidirectionalQueue<T> implements Iterable<T>{
    private Object[] array;
    private int size;
    private int head;
    private int tail;
    private Comparator<T> comparator;


    public UnidirectionalQueue(int capacity, Comparator<T> comparator) {
        this.array = new Object[capacity];
        this.size = 0;
        this.head = 0;
        this.tail = -1;
        this.comparator = comparator;
    }


    public boolean isEmpty(){
        return size == 0;
    }

    public int count(){
        return size;
    }

    public void expand(){
        int newCapacity = array.length * 2;
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(head + i) % array.length];
        }
        array = newArray;
        head = 0;
        tail = size - 1;
    }

    public void enqueue(T element) {
        if (size == array.length) {
            expand();
        }
        tail = (tail + 1) % array.length;
        array[tail] = element;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T element = (T) array[head];
        array[head] = null;
        head = (head + 1) % array.length;
        size--;
        return element;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Your queue data: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[(head + i) % array.length] + " ");
        }
        System.out.println();
    }

    //Итератор
    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
        private int currentIndex;
        private int itemsIterated;

        public QueueIterator() {
            currentIndex = head;
            itemsIterated = 0;
        }

        @Override
        public boolean hasNext() {
            return itemsIterated < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T item = (T) array[currentIndex];
            currentIndex = (currentIndex + 1) % array.length;
            itemsIterated++;
            return item;
        }
    }

    //Компаратор
    public int compare(T first, T second) {
        if (comparator != null) {
            return comparator.compare(first, second);
        }
        if (first instanceof Comparable<?>) {
            return ((Comparable<T>) first).compareTo(second);
        }
        throw new IllegalArgumentException("No comparator provided, and items are not comparable.");
    }
}
