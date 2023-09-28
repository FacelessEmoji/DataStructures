package study.data.structures.Deque;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class BidirectionalList<T, ID> implements Iterable<T>{
    Node<T> head;
    Node<T> tail;
    private final Function<T, ID> idExtractor;

    public BidirectionalList(Function<T, ID> idExtractor) {
        this.idExtractor = idExtractor;
        this.head = null;
        this.tail = null;
    }

    private boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    public Node<T> addFirst(T data) {
        Node<T> first = new Node<T>(data);
        if (isEmpty()) {
            tail = first;
        } else {
            head.setNext(first);
            first.setPrevious(head);
        }
        head = first;
        return head;
    }

    public Node<T> addLast(T data) {
        Node<T> last = new Node<T>(data);
        if (isEmpty()) {
            head = last;
        } else {
            tail.setPrevious(last);
            last.setNext(tail);
        }
        tail = last;
        return last;
    }

    public Node<T> removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            Node<T> first = head;
            if (this.head.equals(this.tail)) {
                head = null;
                tail = null;
            } else {
                head = first.getPrevious();
                head.setNext(null);
            }
            return first;
        }
    }

    public Node<T> removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            Node<T> last = tail;
            if (this.head.equals(this.tail)) {
                head = null;
                tail = null;
            } else {
                tail = last.getNext();
                tail.setPrevious(null);
            }
            return last;
        }
    }

    public void deleteAll() {
        Node<T> temp = head;
        while (!isEmpty()) {
            if (temp.getPrevious() != null) {
                Node<T> box = null;
                box = temp.getPrevious();

                temp.setPrevious(null);
                temp = box;
            } else {
                temp = null;
                break;
            }
        }
        head = null;
        tail = null;
    }



    public void printAll() {
        if (isEmpty()) {
            System.out.println("Your BidirectionalList is empty!");
        } else {
            Node<T> temp = head;
            while (!(temp.getPrevious() == null)) {
                System.out.printf("%s;", temp);
                temp = temp.getPrevious();
            }
            System.out.printf("%s\n", temp);
        }
    }


    public Node<T> findByParameter(ID data) {
        Node<T> temp = head;
        while (temp != null) {
            if (idExtractor.apply(temp.getData()).equals(data)) {
                return temp;
            } else {
                temp = temp.getPrevious();
            }
        }
        return null;
    }

    public Node<T> changeByParameter(ID data, T newData) {
        Node<T> temp = head;
        while (temp != null) {
            if (idExtractor.apply(temp.getData()).equals(data)) {
                temp.setData(newData);
                return temp;
            } else {
                temp = temp.getPrevious();
            }
        }
        return null;
    }

    public Node<T> removeByParameter(ID data) {
        Node<T> temp = head;
        while (temp != null) {
            if (idExtractor.apply(temp.getData()).equals(data)) {
                Node<T> nextNode = temp.getNext();
                Node<T> previousNode = temp.getPrevious();

                if (nextNode != null) {
                    nextNode.setPrevious(previousNode);
                } else {
                    head = previousNode;
                }

                if (previousNode != null) {
                    previousNode.setNext(nextNode);
                } else {
                    tail = nextNode;
                }

                temp.setNext(null);
                temp.setPrevious(null);

                return temp;
            }
            temp = temp.getPrevious();
        }
        return null;
    }

    //Итератор:
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node<T> currentNode;

        public ListIterator() {
            currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T item = currentNode.getData();
            currentNode = currentNode.getPrevious();
            return item;
        }
    }

    //Индексатор:
    public T get(int index) {
        Node<T> current = getNodeAt(index);
        if (current != null) {
            return current.getData();
        }
        throw new IndexOutOfBoundsException();
    }

    public void set(int index, T value) {
        Node<T> current = getNodeAt(index);
        if (current != null) {
            current.setData(value);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node<T> getNodeAt(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        int i = 0;
        while (current != null && i < index) {
            current = current.getPrevious();
            i++;
        }
        return current;
    }

}
