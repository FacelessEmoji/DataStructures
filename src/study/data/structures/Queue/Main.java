package study.data.structures.Queue;

public class Main {
    public static void main(String[] args) {
        UnidirectionalQueue<Integer> queue = new UnidirectionalQueue<>(1);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Dequeue: " + queue.dequeue()); // Dequeue: 1
        System.out.println("Count: " + queue.count()); // Count: 2

        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6); // Expand will be called here

        System.out.println("Count: " + queue.count()); // Count: 5

    }
}
