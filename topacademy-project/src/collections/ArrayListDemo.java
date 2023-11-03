package collections;

import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> al = new ArrayList<>();
        System.out.println("\nCollection Using Iterator:");
        Iterator<String> iter = al.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }


        List<Integer> al2 = new ArrayList<>();
        System.out.println("\nCollection Using Iterator:");
        Iterator<Integer> iter2 = al2.iterator();
        int sum = 0;
        while (iter2.hasNext()) {
            int num = iter2.next();
            sum += num;
        }

        /*
        for (int i = 0; i < 10; i++){
            al2.add(i);
        }

        System.out.println();
        for (int i = 0; i < 10; i++){
            al2.remove(i);
        }

         */


        LinkedList<String> ll = new LinkedList<>();
        ll.add("one");
        ll.add("two");
        ll.add("three");
        ll.add("four");
        ll.add("five");
        System.out.println("List:" + ll);
        ll.addLast("six");
        ll.add(3, "three");
        ll.addFirst("zero");
        System.out.println("List:" + ll);
        System.out.println(ll.poll());

        ListIterator<String> listIterator = ll.listIterator();

        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }


        var unmodList = Collections.unmodifiableList(ll);
        //unmodList.add("million");


        Set<Fish> fishes = new HashSet<>();
        fishes.add(new Fish("eel", 1.5, 120));
        fishes.add(new Fish("salmon", 2.5, 180));
        fishes.add(new Fish("carp", 3.5, 80));
        fishes.add(new Fish("trout", 2.2, 150));
        System.out.println("Collection:" + fishes);
        System.out.println("Collection's size:" + fishes.size());

        for (Fish f : fishes) {
            System.out.print(f + " ");
        }

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("RU");

        //TODO: Comparator, Comparable
        Comparator<Fish> fishComparator = new FishComparator();
        TreeSet<Fish> fishSet = new TreeSet<>(fishComparator);
        Fish trout = new Fish("trout", 2.2, 150);
        fishSet.add(trout);


        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(4);
        pq.add(3);
        pq.add(1);
        pq.offer(9);
        System.out.println("Collection:" + pq);
        System.out.println("Collection's size:" + pq.size());
        System.out.println("\nCollection Using Iterator:");
        Iterator<Integer> iter222 = pq.iterator();
        while (iter222.hasNext()) {
            System.out.println(iter222.next());
        }
    }
}
