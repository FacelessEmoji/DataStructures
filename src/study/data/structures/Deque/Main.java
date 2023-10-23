package study.data.structures.Deque;

import study.data.structures.Minion;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        BidirectionalList<Minion, String> bidirectionalList = new BidirectionalList<>(Minion::getName, Comparator.comparing(Minion::getName));
        Minion minion1 = new Minion("Steve", 5 , 10);
        Minion minion2 = new Minion("Ally", 20 , 20);
        Minion minion3 = new Minion("Nick", 20 , 20);
        Minion minion4 = new Minion("Tim", 6 , 4);
        Minion minion5 = new Minion("James", 7 , 5);
        Minion minion6 = new Minion("Kate", 8 , 6);
//
//
//        System.out.printf("Добавим элемент в конец списка: %s\n",bidirectionalList.addLast(minion1));
//        System.out.print("Выведем список:");
//        bidirectionalList.printAll();
//        System.out.printf("Добавим еще элемент в конец списка: %s\n", bidirectionalList.addLast(minion1));
//        System.out.print("Выведем список:");
//        bidirectionalList.printAll();
//
//        System.out.printf("Добавим элемент в начало списка: %s\n",bidirectionalList.addLast(minion1));
//        System.out.print("Выведем список:");
//        bidirectionalList.printAll();
//        System.out.printf("Добавим еще элемент в начало списка: %s\n", bidirectionalList.addLast(minion1));
//        System.out.print("Выведем список:");
//        bidirectionalList.printAll();
//
//        System.out.printf("Удалим элемент из конца списка: %s\n",bidirectionalList.removeLast());
//        System.out.print("Выведем список:");
//        bidirectionalList.printAll();
//        System.out.printf("Удалим элемент из начала списка: %s\n", bidirectionalList.removeFirst());
//        System.out.print("Выведем список:");
//        bidirectionalList.printAll();
//
//        System.out.println("Очистим список.");
//        bidirectionalList.deleteAll();
//
//        System.out.print("Выведем список:");
//        bidirectionalList.printAll();
//
//        bidirectionalList.addLast(minion1);
//        bidirectionalList.addLast(minion2);
//        bidirectionalList.addLast(minion3);
//        bidirectionalList.addLast(minion4);
//
//        System.out.printf("Найдем объект c полем name равным Tim: %s\n", bidirectionalList.findByParameter("Tim"));
//        System.out.printf("Заменим Tim на Tim2: %s\n", bidirectionalList.changeByParameter("Tim", minion5));
//        System.out.printf("Выведем список:");
//        bidirectionalList.printAll();
//        System.out.printf("Удалим объект с name Steve: %s\n", bidirectionalList.removeByParameter("Steve"));
//        System.out.print("Выведем список:");
//        bidirectionalList.printAll();
//
//        try {
//            Minion firstMinion = bidirectionalList.get(0);
//            System.out.println("Первый миньон: " + firstMinion.name);
//
//            bidirectionalList.set(0, new Minion("NewSteve", 6, 1));
//            Minion modifiedMinion = bidirectionalList.get(0);
//            System.out.println("Новый измененный миньон: " + modifiedMinion.name);
//        } catch(IndexOutOfBoundsException ex) {
//            System.err.println("Index is out of bounds of the list");
//        }
//        bidirectionalList.deleteAll();

        bidirectionalList.addLast(minion1);
        bidirectionalList.addLast(minion2);
        bidirectionalList.addLast(minion3);
        bidirectionalList.addLast(minion4);
        bidirectionalList.addLast(minion5);
        bidirectionalList.addLast(minion6);

        bidirectionalList.printAll();

        List<Minion> minionList = new ArrayList<>();
        for (Minion minion: bidirectionalList) {
            minionList.add(minion);
        }
        Collections.sort(minionList);
        minionList.forEach(System.out::println);
    }
}
