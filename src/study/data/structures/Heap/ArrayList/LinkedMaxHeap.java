package study.data.structures.Heap.ArrayList;

import study.data.structures.Heap.Heap;
import java.util.ArrayList;
import java.util.Arrays;

public class LinkedMaxHeap<E extends Comparable<E>> implements Heap<E> {
    private ArrayList<E> heap;

    public LinkedMaxHeap() {
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

    private void heapifyUp(int index) {
        E temp = heap.get(index);
        while (index > 0 && temp.compareTo(heap.get(parentIndex(index))) > 0) {
            heap.set(index, heap.get(parentIndex(index)));
            index = parentIndex(index);
        }
        heap.set(index, temp);
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    @Override
    public E peek() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    public String asTree() {
        int height = getHeight();

        int width = (int) Math.pow(2, height) - 1;
        String[][] matrix = new String[height][width];
        for (String[] row : matrix) {
            Arrays.fill(row, " ");
        }

        fillMatrix(0, matrix, 0, 0, width);

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

        if (row + 1 < matrix.length) {
            fillMatrix(2 * index + 1, matrix, row + 1, left, mid);
            fillMatrix(2 * index + 2, matrix, row + 1, mid, right);
        }
    }

    private int getHeight() {
        return (int) (Math.log(heap.size()) / Math.log(2)) + 1;
    }

    public String toString() {
        if (heap.isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < heap.size(); i++) {
            sb.append(heap.get(i));
            if (i < heap.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
