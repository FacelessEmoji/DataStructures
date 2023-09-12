package study.data.structures;

public class BidirectionalList<T> {
    Node head;
    Node tail;

    public BidirectionalList() {
        this.head = null;
        this.tail = null;
    }

    private boolean isEmpty(){
        //заглушка
        return this.head == null && this.tail == null;
    }

    public Node addFirst(T data){
        Node first = new Node(data);
        if (isEmpty()){
            tail = first;
        } else {
            head.setNext(first);
            first.setPrevious(head);
        }
        head = first;
        return head;
    }

    public Node addLast(T data){
        Node last = new Node(data);
        if (isEmpty()){
            head = last;
        } else {
            tail.setPrevious(last);
            last.setNext(tail);
        }
        tail = last;
        return last;
    }

    public Node removeFirst(){
        if (isEmpty()){
            return null;
        } else{
            Node first = head;
            if (this.head.equals(this.tail)){
                head = null;
                tail = null;
            }else {
                head = first.previous;
                head.next = null;
            }
            return first;
        }
    }

    public Node removeLast(){
        if (isEmpty()){
            return null;
        } else{
            Node last = tail;
            if (this.head.equals(this.tail)){
                head = null;
                tail = null;
            }else {
                tail = last.next;
                tail.previous = null;
            }
            return last;
        }
    }
}
