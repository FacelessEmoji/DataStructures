package study.data.structures.Heap;

class Node<E> {
    E value;
    Node<E> left;
    Node<E> right;
    Node<E> parent;

    public Node(E value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

