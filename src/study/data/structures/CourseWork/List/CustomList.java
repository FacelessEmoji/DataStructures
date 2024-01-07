package study.data.structures.CourseWork.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomList<T> implements Iterable<T> {
    public CustomNode<T> head;
    public CustomNode<T> tail;
    private int count;

    public CustomList() {
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
            if (this.head.equals(this.tail)) {
                head = null;
                tail = null;
            } else {
                head = first.getPrevious();
                head.setNext(null);
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
            if (this.head.equals(this.tail)) {
                head = null;
                tail = null;
            } else {
                tail = last.getNext();
                tail.setPrevious(null);
            }
            count--;
            return last;
        }
    }

    public void remove(T data) {
        CustomNode<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                // Если элемент находится в голове списка
                if (current == head) {
                    head = head.getNext();
                    if (head != null) {
                        head.setPrevious(null);
                    }
                } else if (current == tail) { // Если элемент находится в хвосте списка
                    tail = tail.getPrevious();
                    if (tail != null) {
                        tail.setNext(null);
                    }
                } else { // Если элемент находится где-то в середине
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                }
                break;
            }
            count--;
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

    public CustomList<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > this.size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Invalid index range");
        }

        CustomList<T> subList = new CustomList<>();
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
