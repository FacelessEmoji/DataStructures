package study.data.structures;

public class Main {

    public static void main(String[] args) {
        BidirectionalList<Minion, String> bidirectionalList = new BidirectionalList<>(Minion::getName);
        Minion minion1 = new Minion("Steve", 5 , 1);
        Minion minion2 = new Minion("Ally", 7 , 2);
        Minion minion3 = new Minion("Nick", 14 , 1);
        Minion minion4 = new Minion("Tim", 1 , 17);

        System.out.println(bidirectionalList.addLast(minion1));
        System.out.println(bidirectionalList.addLast(minion2));

        bidirectionalList.printAll();

        System.out.println(bidirectionalList.addFirst(minion3));
        System.out.println(bidirectionalList.addFirst(minion4));

        bidirectionalList.printAll();

        System.out.println(bidirectionalList.removeLast());
        System.out.println(bidirectionalList.removeFirst());

        bidirectionalList.printAll();

        bidirectionalList.deleteAll();

        bidirectionalList.printAll();

        System.out.println(bidirectionalList.addLast(minion1));
        System.out.println(bidirectionalList.addLast(minion2));
        System.out.println(bidirectionalList.addFirst(minion3));
        System.out.println(bidirectionalList.addFirst(minion4));

        System.out.println(bidirectionalList.findByParameter("Tim"));
        System.out.println(bidirectionalList.removeByParameter("Steve"));
        System.out.println(bidirectionalList.removeByParameter("Tim"));
        System.out.println(bidirectionalList.removeByParameter("Nick"));
        System.out.println(bidirectionalList.removeByParameter("Ally"));

        bidirectionalList.deleteAll();

        bidirectionalList.printAll();
    }
}
