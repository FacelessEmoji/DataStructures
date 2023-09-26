package study.data.structures.Deque;

public class Main {

    public static void main(String[] args) {
        BidirectionalList<Minion, String> bidirectionalList = new BidirectionalList<>(Minion::getName);
        Minion minion1 = new Minion("Steve", 5 , 1);
        Minion minion2 = new Minion("Ally", 7 , 2);
        Minion minion3 = new Minion("Nick", 14 , 1);
        Minion minion4 = new Minion("Tim", 1 , 17);
        Minion minion5 = new Minion("Tim2", 1 , 17);


        System.out.printf("Добавим элемент в конец списка: %s\n",bidirectionalList.addLast(minion1));
        System.out.print("Выведем список:");
        bidirectionalList.printAll();
        System.out.printf("Добавим еще элемент в конец списка: %s\n", bidirectionalList.addLast(minion1));
        System.out.print("Выведем список:");
        bidirectionalList.printAll();

        System.out.printf("Добавим элемент в начало списка: %s\n",bidirectionalList.addLast(minion1));
        System.out.print("Выведем список:");
        bidirectionalList.printAll();
        System.out.printf("Добавим еще элемент в начало списка: %s\n", bidirectionalList.addLast(minion1));
        System.out.print("Выведем список:");
        bidirectionalList.printAll();

        System.out.printf("Удалим элемент из конца списка: %s\n",bidirectionalList.removeLast());
        System.out.print("Выведем список:");
        bidirectionalList.printAll();
        System.out.printf("Удалим элемент из начала списка: %s\n", bidirectionalList.removeFirst());
        System.out.print("Выведем список:");
        bidirectionalList.printAll();

        System.out.println("Очистим список.");
        bidirectionalList.deleteAll();

        System.out.print("Выведем список:");
        bidirectionalList.printAll();

        bidirectionalList.addLast(minion1);
        bidirectionalList.addLast(minion2);
        bidirectionalList.addLast(minion3);
        bidirectionalList.addLast(minion4);

        System.out.printf("Найдем объект c полем name равным Tim: %s\n", bidirectionalList.findByParameter("Tim"));
        System.out.printf("Заменим Tim на Tim2: %s\n", bidirectionalList.changeByParameter("Tim", minion5));
        System.out.printf("Выведем список:");
        bidirectionalList.printAll();
        System.out.printf("Удалим объект с name Steve: %s\n", bidirectionalList.removeByParameter("Steve"));
        System.out.print("Выведем список:");
        bidirectionalList.printAll();
    }
}
