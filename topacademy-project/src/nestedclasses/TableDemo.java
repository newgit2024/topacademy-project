package nestedclasses;

import oop.Passenger;

public class TableDemo {
    public static void main(String[] args) {
        Table table = new Table();
        table.put("Ivan", 33);
        table.put("Olga", 36);
        table.put("Vadim", 28);
        table.put("Rashid", 43);

        Table table1 = new Table();
        table.put("Ivan2", 33);
        table.put("Olga2", 36);
        table.put("Vadim2", 28);
        table.put("Rashid2", 43);

        //Table.TableEntry entry = Table.TableEntry("Roza", 22);

        Table.TableIterator iterator = table.new TableIterator();
        iterator.next();
        System.out.println(iterator.key() + " : " + iterator.value());
        iterator.next();
        System.out.println(iterator.key() + " : " + iterator.value());
        iterator.next();
        System.out.println(iterator.key() + " : " + iterator.value());
        iterator.next();
        System.out.println(iterator.key() + " : " + iterator.value());
        iterator.next();
        System.out.println(iterator.key() + " : " + iterator.value());

        Table.TableIterator iterator2 = table.new TableIterator();
        iterator2.next();
        System.out.println(iterator2.key() + " : " + iterator2.value());
        iterator2.next();
        System.out.println(iterator2.key() + " : " + iterator2.value());
        iterator2.next();
        System.out.println(iterator2.key() + " : " + iterator2.value());
        iterator2.next();
        System.out.println(iterator2.key() + " : " + iterator2.value());
        iterator2.next();
        System.out.println(iterator2.key() + " : " + iterator2.value());

        Table.TableIterator iterator3 = table1.new TableIterator();
        iterator3.next();
        System.out.println(iterator3.key() + " : " + iterator3.value());
        iterator3.next();
        System.out.println(iterator3.key() + " : " + iterator3.value());
        iterator3.next();
        System.out.println(iterator3.key() + " : " + iterator3.value());
        iterator3.next();
        System.out.println(iterator3.key() + " : " + iterator3.value());
        iterator3.next();
        System.out.println(iterator3.key() + " : " + iterator3.value());
    }
}
