package study.data.structures.Queue;

import java.util.Arrays;

public class UnidirectionalQueue<T> {
    private Object[] array;
    private int size;
    private int head;
    private int tail;

    public UnidirectionalQueue(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
        this.head = 0;
        this.tail = -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int count(){
        return size;
    }

    public void expand(){
        System.out.println("Array before:");
        Arrays.stream(array).forEach(System.out::println);

        int newCapacity = array.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.out.println("Loop");
        for (int i = 0; i < size; i++) {
            System.out.println((head + i) % array.length);
            newArray[i] = array[(head + i) % array.length];
        }
        array = newArray;
        head = 0;
        tail = size - 1;

        System.out.println("Array after:");
        Arrays.stream(array).forEach(System.out::println);
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
}
