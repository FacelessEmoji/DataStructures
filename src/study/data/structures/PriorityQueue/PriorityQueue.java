package study.data.structures.PriorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PriorityQueue<E extends Comparable<E>> implements AbstractQueue<E> {
    private ArrayList<E> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public void add(E element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    @Override
    public E peek() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }

    @Override
    public E poll() {
        if (heap.isEmpty()) return null;
        E maxElement = heap.get(0);
        Collections.swap(heap, 0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return maxElement;
    }

    private void heapifyUp(int index) {
        E temp = heap.get(index);
        while (index > 0 && temp.compareTo(heap.get(parentIndex(index))) > 0) {
            heap.set(index, heap.get(parentIndex(index)));
            index = parentIndex(index);
        }
        heap.set(index, temp);
    }

    private void heapifyDown(int index) {
        int childIndex;
        E temp = heap.get(index);
        while (leftChildIndex(index) < heap.size()) {
            childIndex = maxChildIndex(index);
            if (temp.compareTo(heap.get(childIndex)) < 0) {
                heap.set(index, heap.get(childIndex));
                index = childIndex;
            } else {
                break;
            }
        }
        heap.set(index, temp);
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    private int maxChildIndex(int index) {
        if (rightChildIndex(index) >= heap.size() || heap.get(leftChildIndex(index)).compareTo(heap.get(rightChildIndex(index))) > 0) {
            return leftChildIndex(index);
        } else {
            return rightChildIndex(index);
        }
    }

    //методы для вывода очереди

    public String asTree() {
        if (heap.isEmpty()) {
            return "Пустая куча";
        }

        int height = (int) (Math.log(heap.size()) / Math.log(2)) + 1;
        int width = (int) Math.pow(2, height) - 1;
        String[][] matrix = new String[height][width];

        for (String[] row : matrix) {
            Arrays.fill(row, " ");
        }

        fillMatrix(0, matrix, 0, 0, width - 1);

        StringBuilder result = new StringBuilder();
        for (String[] row : matrix) {
            for (String cell : row) {
                result.append(cell);
            }
            result.append("\n");
        }

        return result.toString();
    }

    private void fillMatrix(int index, String[][] matrix, int row, int left, int right) {
        if (index >= heap.size()) {
            return;
        }

        int mid = (left + right) / 2;
        matrix[row][mid] = heap.get(index).toString();

        fillMatrix(leftChildIndex(index), matrix, row + 1, left, mid - 1);
        fillMatrix(rightChildIndex(index), matrix, row + 1, mid + 1, right);
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}

