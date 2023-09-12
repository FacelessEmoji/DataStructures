package study.data.structures;

public class Main {

    public static void main(String[] args) {
        BidirectionalList<Minion> bidirectionalList = new BidirectionalList<>();
        Minion minion1 = new Minion("Steve", 5 , 1);
        Minion minion2 = new Minion("Ally", 7 , 2);
        Minion minion3 = new Minion("Nick", 14 , 1);
        Minion minion4 = new Minion("Tim", 1 , 17);

        System.out.println(bidirectionalList.addLast(minion1));
        System.out.println(bidirectionalList.head + " " + bidirectionalList.tail);

        System.out.println(bidirectionalList.addLast(minion2));
        System.out.println(bidirectionalList.head + " " + bidirectionalList.tail);

        System.out.println(bidirectionalList.addLast(minion3));
        System.out.println(bidirectionalList.head + " " + bidirectionalList.tail);

        System.out.println(bidirectionalList.removeLast());
        System.out.println(bidirectionalList.removeLast());
        System.out.println(bidirectionalList.removeLast());
        System.out.println(bidirectionalList.removeLast());


        System.out.println(bidirectionalList.addLast(minion4));
        System.out.println(bidirectionalList.head + " " + bidirectionalList.tail);
    }
}
