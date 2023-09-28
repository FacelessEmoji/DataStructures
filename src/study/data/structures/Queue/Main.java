package study.data.structures.Queue;

import study.data.structures.Minion;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        UnidirectionalQueue<Minion> queue = new UnidirectionalQueue<>(1);
        Minion minion1 = new Minion("Steve", 5 , 1);
        Minion minion2 = new Minion("Ally", 7 , 2);
        Minion minion3 = new Minion("Nick", 14 , 2);
        Minion minion4 = new Minion("Tim", 1 , 17);
        Minion minion5 = new Minion("James", 69 , 0);
        Minion minion6 = new Minion("Kate", 11 , 4);

        queue.enqueue(minion1);
        queue.enqueue(minion2);
        queue.enqueue(minion3);

        System.out.println("Dequeue: " + queue.dequeue()); // Dequeue: 1
        System.out.println("Count: " + queue.count()); // Count: 2

        queue.enqueue(minion4);
        queue.enqueue(minion5);
        queue.enqueue(minion6); // Expand will be called here

        System.out.println("Count: " + queue.count());
        queue.print();// Count: 5

        //ForEach
        for (Minion minion : queue) {
            System.out.println(minion);
        }

        //Явный вызов
        Iterator<Minion> minionIterator = queue.iterator();

        while (minionIterator.hasNext()){
            System.out.println(minionIterator.next());
        }


    }
}
