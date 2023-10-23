package study.data.structures.Trees.Basic;

import java.util.List;
import java.util.function.Consumer;

public interface AbstractBinaryTree<E> {
        E getKey();
        AbstractBinaryTree<E> getLeft();
        AbstractBinaryTree<E> getRight();
        void setKey(E key);
        String asIndentedPreOrder(int indent);
        List<AbstractBinaryTree<E>> preOrder();
        List<AbstractBinaryTree<E>> inOrder();
        List<AbstractBinaryTree<E>> postOrder();
        void forEachInOrder(Consumer<E> consumer);
        //
        List<AbstractBinaryTree<E>> depthFirst();  // обход в глубину
        List<AbstractBinaryTree<E>> breadthFirst();        // Обход в ширину
        }
