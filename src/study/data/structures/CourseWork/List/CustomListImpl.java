package study.data.structures.CourseWork.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomListImpl<T> implements CustomList<T> {
    public CustomNode<T> head;
    public CustomNode<T> tail;
    private int count;

    public CustomListImpl() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public int size() {
        return count;
    }

    public T getFirst() {
        return isEmpty() ? null : head.getData();
    }

    public T getLast() {
        return isEmpty() ? null : tail.getData();
    }

    public boolean contains(T data) {
        CustomNode<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    private boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    public CustomNode<T> addFirst(T data) {
        CustomNode<T> first = new CustomNode<T>(data);
        if (isEmpty()) {
            tail = first;
        } else {
            head.setNext(first);
            first.setPrevious(head);
        }
        head = first;
        count++;
        return head;
    }

    public CustomNode<T> addLast(T data) {
        CustomNode<T> newNode = new CustomNode<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
        }
        tail = newNode;
        count++;
        return newNode;
    }

    public CustomNode<T> removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            CustomNode<T> first = head;
            if (head.equals(tail)) { // Если в списке только один элемент
                head = null;
                tail = null;
            } else {
                head = first.getNext();
                head.setPrevious(null);
            }
            count--;
            return first;
        }
    }

    public CustomNode<T> removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            CustomNode<T> last = tail;
            if (head.equals(tail)) { // Если в списке только один элемент
                head = null;
                tail = null;
            } else {
                tail = last.getPrevious();
                tail.setNext(null);
            }
            count--;
            return last;
        }
    }

    public void remove(T data) {
        CustomNode<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                if (current == head) { // Если элемент находится в голове списка
                    removeFirst();
                } else if (current == tail) { // Если элемент находится в хвосте списка
                    removeLast();
                } else { // Если элемент находится где-то в середине
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                    count--;
                }
                return; // Выход из метода после удаления элемента
            }
            current = current.getNext();
        }
    }

    public void removeAll() {
        head = null;
        tail = null;
        count = 0;
    }

    public void printAll() {
        CustomNode<T> temp = head;
        while (temp != null) {
            System.out.printf("%s;", temp.getData());
            temp = temp.getNext();
        }
        System.out.println();
    }

    public CustomListImpl<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > this.size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Invalid index range");
        }

        CustomListImpl<T> subList = new CustomListImpl<>();
        int currentIndex = 0;
        CustomNode<T> current = head;

        while (current != null && currentIndex < toIndex) {
            if (currentIndex >= fromIndex) {
                subList.addLast(current.getData());
            }
            current = current.getNext();
            currentIndex++;
        }

        return subList;
    }

    // Внутренний класс для реализации итератора
    private class ListIterator implements Iterator<T> {
        private CustomNode<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.getData();
            current = current.getNext();
            return data;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        CustomNode<T> current = head;
        while (current != null) {
            sb.append(current.getData().toString());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }

        sb.append("]");
        return sb.toString();
    }
}


