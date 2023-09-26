package study.data.structures.Queue;

public class UnidirectionalQueue<T> {
    private T[] array;
    private int size;
    private int head;
    private int tail;

    public UnidirectionalQueue(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.size = 0;
        this.head = 0;
        this.tail = 0;
    }
}
