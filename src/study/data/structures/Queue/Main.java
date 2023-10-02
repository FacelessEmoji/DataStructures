package study.data.structures.Queue;

import study.data.structures.Minion;

import java.util.Comparator;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        UnidirectionalQueue<Minion> queue = new UnidirectionalQueue<>(1, Comparator.comparing(Minion::getName));
        Minion minion1 = new Minion("Steve", 1 , 1);
        Minion minion2 = new Minion("Ally", 2 , 2);
        Minion minion3 = new Minion("Nick", 3 , 3);
        Minion minion4 = new Minion("Tim", 6 , 4);
        Minion minion5 = new Minion("James", 7 , 5);
        Minion minion6 = new Minion("Kate", 8 , 6);

        queue.enqueue(minion1);// Здесь будет вызван метод expand()
        queue.enqueue(minion2);
        queue.enqueue(minion3);// Здесь будет вызван метод expand()

        System.out.println("Извлечен элемент из очереди: " + queue.dequeue().name);
        System.out.println("Количество элементов в очереди: " + queue.count());

        queue.enqueue(minion4);
        queue.enqueue(minion5);// Здесь будет вызван метод expand()
        queue.enqueue(minion6);

        System.out.println("Количество элементов в очереди: " + queue.count());
        System.out.print("Элементы очереди: ");
        queue.print();

        // Использование forEach
        System.out.println("Проход по элементам через forEach:");
        for (Minion minion : queue) {
            System.out.println(minion.name);
        }

        // Явный вызов итератора
        Iterator<Minion> minionIterator = queue.iterator();
        System.out.println("Проход по элементам через итератор:");
        while (minionIterator.hasNext()){
            System.out.println(minionIterator.next().name);
        }

        // Использование компаратора
        int compareResult = queue.compare(minion2, minion3);
        if (compareResult < 0) {
            System.out.println(minion2.name + " предшествует " + minion3.name + " при сравнении по имени.");
        } else if (compareResult > 0) {
            System.out.println(minion2.name + " следует за " + minion3.name + " при сравнении по имени.");
        } else {
            System.out.println(minion2.name + " и " + minion3.name + " имеют одинаковые имена.");
        }
    }
}
