package study.data.structures.PriorityQueue;

import java.util.ArrayList;
import java.util.Arrays;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Тестирование добавления элементов
        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(17, 15,6, 9, 5, 8, 16, 6));
        for (Integer integer : test) {
            priorityQueue.add(integer);
            System.out.println("Очередь как дерево после добавления:\n" + priorityQueue);
        }

        // Тестирование size()
        System.out.println("Текущий размер очереди: " + priorityQueue.size());

        // Тестирование peek()
        System.out.println("Максимальный элемент (peek): " + priorityQueue.peek());

        // Тестирование poll()
        System.out.println("Удаление максимального элемента (poll): " + priorityQueue.poll());
        System.out.println("Удаление максимального элемента (poll): " + priorityQueue.poll());
        System.out.println("Удаление максимального элемента (poll): " + priorityQueue.poll());
        System.out.println("Удаление максимального элемента (poll): " + priorityQueue.poll());
        System.out.println("Удаление максимального элемента (poll): " + priorityQueue.poll());
        System.out.println("Удаление максимального элемента (poll): " + priorityQueue.poll());
        System.out.println("Удаление максимального элемента (poll): " + priorityQueue.poll());
        System.out.println("Очередь как дерево после poll:\n" + priorityQueue);

        // Повторное тестирование size()
        System.out.println("Размер очереди после удаления: " + priorityQueue.size());
    }
}


