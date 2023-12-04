package study.data.structures.PriorityQueue;

public interface AbstractQueue <E extends Comparable <E>> {
    int size();
    void add(E element);
    E peek();
    E poll();
    }