package study.data.structures.Heap;

import java.util.Arrays;

class MaxHeap<E extends Comparable<E>> implements Heap<E> {
    private Node<E> root;
    private Node<E> lastNode;
    private int size;

    public MaxHeap() {
        root = null;
        lastNode = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (root == null) {
            root = newNode;
            lastNode = newNode;
        } else {
            int parentIndex = (size + 1) / 2;
            Node<E> parent = getNode(parentIndex);
            newNode.parent = parent;
            if (parent != null) {
                if ((size + 1) % 2 == 0) {
                    parent.left = newNode;
                } else {
                    parent.right = newNode;
                }
            }
            lastNode = newNode;
            heapifyUp(newNode);
        }
        size++;
    }

    private Node<E> getNode(int index) {
        String path = Integer.toBinaryString(index).substring(1); // Исключаем старший бит
        Node<E> current = root;
        for (char ch : path.toCharArray()) {
            if (current == null) {
                return null;
            }
            current = (ch == '0') ? current.left : current.right;
        }
        return current; // Возвращает родителя нового узла
    }



    private void heapifyUp(Node<E> node) {
        while (node.parent != null && node.value.compareTo(node.parent.value) > 0) {
            swap(node, node.parent);
            node = node.parent;
        }
    }

    private void swap(Node<E> a, Node<E> b) {
        E temp = a.value;
        a.value = b.value;
        b.value = temp;
    }

    @Override
    public E peek() {
        return root != null ? root.value : null;
    }

    @Override
    public E poll() {
        if (root == null) {
            return null;
        }

        E maxValue = root.value;
        root.value = lastNode.value;
        deleteLastNode();
        heapifyDown(root);

        return maxValue;
    }

    private void deleteLastNode() {
        if (size == 1) {
            root = null;
            lastNode = null;
        } else {
            Node<E> parentOfLast = getNode((size - 1) / 2);
            if (size % 2 == 0) {
                parentOfLast.left = null;
            } else {
                parentOfLast.right = null;
            }
            lastNode = parentOfLast;
        }
        size--;
    }


    private void heapifyDown(Node<E> node) {
        while (node != null && !isLeaf(node)) {
            Node<E> largerChild = largerChild(node);
            if (largerChild.value.compareTo(node.value) > 0) {
                swap(node, largerChild);
            }
            node = largerChild;
        }
    }

    private boolean isLeaf(Node<E> node) {
        return node.left == null && node.right == null;
    }

    private Node<E> largerChild(Node<E> node) {
        if (node.left != null && node.right != null) {
            return node.left.value.compareTo(node.right.value) > 0 ? node.left : node.right;
        } else if (node.left != null) {
            return node.left;
        } else {
            return node.right;
        }
    }

    //Служебный вывод дерева елочкой
    public String asTree() {
        int height = getHeight(root);

        // Вычисляем ширину матрицы
        int width = (int) Math.pow(2, height) - 1;

        // Создаем матрицу для хранения элементов
        String[][] matrix = new String[height][width];

        // Заполняем матрицу пустыми строками
        for (String[] row : matrix) {
            Arrays.fill(row, " ");
        }

        // Заполняем матрицу значениями из дерева
        fillMatrix(root, matrix, 0, 0, width);

        // Собираем матрицу в виде строки
        StringBuilder result = new StringBuilder();
        for (String[] row : matrix) {
            for (String cell : row) {
                result.append(cell);
            }
            result.append("\n");
        }

        return result.toString();
    }

    private void fillMatrix(Node<E> node, String[][] matrix, int row, int left, int right) {
        if (node == null) {
            return;
        }

        int mid = (left + right) / 2;
        matrix[row][mid] = node.value.toString();

        if (row + 1 < matrix.length) {
            fillMatrix(node.left, matrix, row + 1, left, mid);
            fillMatrix(node.right, matrix, row + 1, mid, right);
        }
    }

    private int getHeight(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    // Метод для обхода дерева и печати элементов
    public void printElements() {
        System.out.println("Элементы кучи при Inorder:");
        printInOrder(root);
    }

    private void printInOrder(Node<E> node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.value + " ");
            printInOrder(node.right);
        }
    }
}


