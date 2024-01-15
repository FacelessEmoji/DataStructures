package study.data.structures.CourseWork.List;

public interface CustomList<T> extends Iterable<T> {
    int size();
    T getFirst();
    T getLast();
    boolean contains(T data);
    CustomNode<T> addFirst(T data);
    CustomNode<T> addLast(T data);
    CustomNode<T> removeFirst();
    CustomNode<T> removeLast();
    void remove(T data);
    void removeAll();
    void printAll();
    CustomList<T> subList(int fromIndex, int toIndex);
}
