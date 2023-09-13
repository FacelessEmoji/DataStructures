package study.data.structures;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BidirectionalList<T> {
    Node head;
    Node tail;

    public BidirectionalList() {
        this.head = null;
        this.tail = null;
    }

    private boolean isEmpty() {
        //заглушка
        return this.head == null && this.tail == null;
    }

    public Node addFirst(T data) {
        Node first = new Node(data);
        if (isEmpty()) {
            tail = first;
        } else {
            head.setNext(first);
            first.setPrevious(head);
        }
        head = first;
        return head;
    }

    public Node addLast(T data) {
        Node last = new Node(data);
        if (isEmpty()) {
            head = last;
        } else {
            tail.setPrevious(last);
            last.setNext(tail);
        }
        tail = last;
        return last;
    }

    public Node removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            Node first = head;
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

    public Node removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            Node last = tail;
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

    public void printAll() {
        Node temp = head;
        while (!(temp.getPrevious() == null)) {
            System.out.printf("%s;", temp);
            temp = temp.getPrevious();
        }
        System.out.printf("%s; ", temp);
    }

    public <T extends Comparable<? super T>> Node findByParameter(String parameter, T data)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (isEmpty()) {
            return null;
        } else {
            String methodName = "get" + parameter.substring(0, 1).toUpperCase() + parameter.substring(1);
            Method method = head.getData().getClass().getMethod(methodName);
            Node temp = head;
            while (temp != null) {
                if (method.invoke(temp.getData()).equals(data)) {
                    return temp;
                } else {
                    temp = temp.getPrevious();
                }
            }
            return null;
        }
    }

}
