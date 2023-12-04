package study.data.structures.Heap;


import study.data.structures.Heap.ArrayList.LinkedMaxHeap;
import study.data.structures.Heap.BinaryTree.MaxHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MaxHeapTest {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        MaxHeap<Integer> testHeap = new MaxHeap<>();
        LinkedMaxHeap<Integer> linkedMaxHeap = new LinkedMaxHeap<>();

        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(25,17,15,9,5,8,16,6));

        //Заполним структуры данными
        for (Integer integer : test) {
            testHeap.add(integer);
        }

        for (Integer integer : test) {
            linkedMaxHeap.add(integer);
        }

        System.out.println("\nBinaryTreeMaxHeep:\n");
        //Тестирование производительности
        Random random = new Random();
        int numberOfElements = 10; // Можно изменить для разных тестов

        // Тестирование добавления 10 элементов
        long startTime = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            maxHeap.add(random.nextInt(100000)); // Добавление случайных чисел
        }
        long endTime = System.nanoTime();
        System.out.println("Time to add " + numberOfElements + " elements: " + (endTime - startTime) + " ns");

        // Тестирование извлечения максимального элемента
        startTime = System.nanoTime();
        maxHeap.peek();
        endTime = System.nanoTime();
        System.out.println("Time to peek the max element: " + (endTime - startTime) + " ns");

        // Тестирование добавления 10000 элементов
        numberOfElements = 10000;
        startTime = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            maxHeap.add(random.nextInt(100000)); // Добавление случайных чисел
        }
        endTime = System.nanoTime();
        System.out.println("Time to add " + numberOfElements + " elements: " + (endTime - startTime) + " ns");

        // Тестирование извлечения максимального элемента
        startTime = System.nanoTime();
        maxHeap.peek();
        endTime = System.nanoTime();
        System.out.println("Time to peek the max element: " + (endTime - startTime) + " ns");



        //Прочее для маленькой кучи
        System.out.println("Peek: " + testHeap.peek());
        System.out.println("MaxHeap as a tree:");
        // Визуализация структуры MaxHeap
        System.out.println(testHeap.asTree());
        testHeap.printElements();

        ////////////////////////////////////////////////////////////////////

        System.out.println("\nLinkedMaxHeep:\n");
        System.out.println("Peek: " + linkedMaxHeap.peek());
        System.out.println("LinkedMaxHeep as a tree:");
        System.out.println(linkedMaxHeap.asTree());
        System.out.println(linkedMaxHeap);
    }
}
