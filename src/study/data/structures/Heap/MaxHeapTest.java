package study.data.structures.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MaxHeapTest {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        MaxHeap<Integer> testHeap = new MaxHeap<>();
        Random random = new Random();
        int numberOfElements = 10000; // Можно изменить для разных тестов

        // Тестирование добавления элементов
        long startTime = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            maxHeap.add(random.nextInt(100000)); // Добавление случайных чисел
        }
        long endTime = System.nanoTime();
        System.out.println("Time to add " + numberOfElements + " elements: " + (endTime - startTime) + " ns");

        // Тестирование извлечения максимального элемента
        startTime = System.nanoTime();
        maxHeap.poll();
        endTime = System.nanoTime();
        System.out.println("Time to poll the max element: " + (endTime - startTime) + " ns");

        // Визуализация структуры MaxHeap
        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(25,17,15,9,5,8,16,6));
        for (Integer integer : test) {
            testHeap.add(integer);
        }
        System.out.println("MaxHeap as a tree:");
        System.out.println(testHeap.asTree());

        testHeap.poll();
        System.out.println("MaxHeap as a tree after polling:");
        System.out.println(testHeap.asTree());

        // Визуализация структуры MaxHeap
        testHeap.printElements();
    }
}
