package collections;

import java.util.Comparator;

public class FishComparator implements Comparator<Fish> {

    @Override
    public int compare(Fish o1, Fish o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
