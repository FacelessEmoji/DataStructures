package study.data.structures.Trees.Search;

import java.util.Arrays;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {
    public static class Node<E> extends AbstractBinarySearchTree.Node<E> {
        public E value;
        public Node<E> leftChild;
        public Node<E> rightChild;

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node<E> leftChild, Node<E> rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    private Node<E> root;

    private BinarySearchTree(Node<E> root) {
        this.root = root;
    }

    public BinarySearchTree() {
        this.root = null;
    }

    @Override
    public void insert(E element) {
        root = insertRec(root, element);
    }

    private Node<E> insertRec(Node<E> root, E element) {
        if (root == null) {
            root = new Node<>(element);
            return root;
        }
        if (element.compareTo(root.value) < 0) {
            root.leftChild = insertRec(root.leftChild, element);
        } else if (element.compareTo(root.value) > 0) {
            root.rightChild = insertRec(root.rightChild, element);
        }
        return root;
    }

    @Override
    public boolean contains(E element) {
        return containsRec(root, element);
    }

    private boolean containsRec(Node<E> root, E element) {
        if (root == null) {
            return false;
        }
        if (element.equals(root.value)) {
            return true;
        }
        if (element.compareTo(root.value) < 0) {
            return containsRec(root.leftChild, element);
        }
        return containsRec(root.rightChild, element);
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        return searchRec(root, element);
    }

    private AbstractBinarySearchTree<E> searchRec(Node<E> root, E element) {
        if (root == null || element.equals(root.value)) {
            return new BinarySearchTree<>(root);
        }
        if (element.compareTo(root.value) < 0) {
            return searchRec(root.leftChild, element);
        }
        return searchRec(root.rightChild, element);
    }

    @Override
    public Node<E> getRoot() {
        return root;
    }

    @Override
    public Node<E> getLeft() {
        if (root != null) {
            return root.leftChild;
        }
        return null;
    }

    @Override
    public Node<E> getRight() {
        if (root != null) {
            return root.rightChild;
        }
        return null;
    }

    @Override
    public E getValue() {
        if (root != null) {
            return root.value;
        }
        return null;
    }

    public String asTree() {
        // Вычисляем высоту дерева
        int height = getHeight(root);

        // Вычисляем ширину матрицы
        int width = (int) Math.pow(2, height + 1) - 1;

        // Создаем матрицу для хранения элементов
        String[][] matrix = new String[height][width];

        // Заполняем матрицу пустыми строками
        for (String[] row : matrix) {
            Arrays.fill(row, " ");
        }

        // Заполняем матрицу значениями из дерева
        fillMatrix(root, matrix, 0, 0, width / 2);

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

        // Находим середину между left и right
        int mid = (left + right) / 2;

        // Заполняем текущую ячейку матрицы значением из узла
        matrix[row][mid] = node.value.toString();

        // Рекурсивно заполняем левое и правое поддерево
        fillMatrix(node.leftChild, matrix, row + 1, left, mid - 1);
        fillMatrix(node.rightChild, matrix, row + 1, mid + 1, right);
    }

    private int getHeight(Node<E> node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.leftChild);
        int rightHeight = getHeight(node.rightChild);
        return Math.max(leftHeight, rightHeight) + 1;
    }



    public void morrisTraversalInorder() {
        Node<E> current = root;
        while (current != null) {
            if (current.leftChild == null) {
                System.out.print(current.value + " ");
                current = current.rightChild;
            } else {
                Node<E> pre = current.leftChild;
                while (pre.rightChild != null && pre.rightChild != current) {
                    pre = pre.rightChild;
                }
                if (pre.rightChild == null) {
                    pre.rightChild = current;
                    current = current.leftChild;
                } else {
                    pre.rightChild = null;
                    System.out.print(current.value + " ");
                    current = current.rightChild;
                }
            }
        }
    }
}

