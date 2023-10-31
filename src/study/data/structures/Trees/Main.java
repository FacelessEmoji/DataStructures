package study.data.structures.Trees;

import study.data.structures.Minion;
import study.data.structures.Trees.Basic.AbstractBinaryTree;
import study.data.structures.Trees.Basic.BinaryTree;
import study.data.structures.Trees.Search.AbstractBinarySearchTree;
import study.data.structures.Trees.Search.BinarySearchTree;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем объекты Minion
        Integer minion1 = 4;
        Integer minion2 = 2;
        Integer minion3 = 6;
        Integer minion4 = 1;
        Integer minion5 = 3;
        Integer minion6 = 5;
        Integer minion7 = 7;
        Integer minion8 = 10;
        Integer minion9 = 9;
        Integer minion10 = 69;

//        Minion minion1 = new Minion("Bob", 30, 2);
//        Minion minion2 = new Minion("Kevin", 25, 1);
//        Minion minion3 = new Minion("Stuart", 35, 1);
//        Minion minion4 = new Minion("Dave", 28, 2);
//        Minion minion5 = new Minion("Jerry", 26, 2);
//        Minion minion6 = new Minion("Tim", 33, 1);
//        Minion minion7 = new Minion("Mark", 32, 1);

        System.out.println("Binary Tree:");

        BinaryTree<Integer> root = new BinaryTree<>(minion1);
        root.left = new BinaryTree<>(minion2);
        root.right = new BinaryTree<>(minion3);
        root.left.left = new BinaryTree<>(minion4);
        root.left.right = new BinaryTree<>(minion5);
        root.right.left = new BinaryTree<>(minion6);
        root.right.right = new BinaryTree<>(minion7);

        System.out.println("\nasIndentedPreOrder:");
        System.out.println(root.asIndentedPreOrder(0));

        System.out.println("\npreOrder:");
        root.preOrder().forEach(System.out::print);

        System.out.println("\ninOrder:");
        root.inOrder().forEach(System.out::print);

        System.out.println("\npostOrder:");
        root.postOrder().forEach(System.out::print);

        System.out.println("\nPrinting in order:");
        //root.forEachInOrder(minion -> System.out.println(minion.name));
        root.forEachInOrder(minion -> System.out.print(minion));

        System.out.println("\nBFS:");
        root.breadthFirst().forEach(System.out::print);

        System.out.println("\nDFS:");
        root.depthFirst().forEach(System.out::print);

        System.out.println("\nBinary Search Tree:");

        // Создаем и заполняем дерево поиска
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(minion1);
        bst.insert(minion2);
        bst.insert(minion3);
        bst.insert(minion4);
        bst.insert(minion5);
        bst.insert(minion6);
        bst.insert(minion7);
        bst.insert(minion8);
        bst.insert(minion9);

        System.out.println(bst.asTree());
        // Проверка наличия элемента
        System.out.println("\nContains 4: " + bst.contains(minion1)); // Должно вернуть true
//        System.out.println("\nContains Phil: " + bst.contains(new Minion("Phil", 32, 1))); // Должно вернуть false

        // Поиск элемента
        AbstractBinarySearchTree<Integer> searchResult = bst.search(minion10);
        //System.out.println("\nSearch Kevin: " + searchResult.getValue().name); // Должно вернуть "Kevin"
        System.out.println("\nSearch 69: " + searchResult.getValue()); // Должно вернуть "Kevin"

        // Morris Traversal для дерева поиска
        System.out.println("\nMorris Traversal Inorder:");
        bst.morrisTraversalInorder();
    }
}
