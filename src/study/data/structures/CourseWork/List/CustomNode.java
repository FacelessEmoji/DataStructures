package study.data.structures.CourseWork.List;

public class CustomNode<T> {
    public T data;
    public CustomNode<T> next;
    public CustomNode<T> previous;

    public CustomNode(T data) {
        this.data = data;
    }

    public CustomNode(T data, CustomNode<T> next, CustomNode<T> previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CustomNode<T> getNext() {
        return next;
    }

    public void setNext(CustomNode<T> next) {
        this.next = next;
    }

    public CustomNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(CustomNode<T> previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return data != null ? data.toString() : "null";
    }

}
