package yahav_eliyahu_matanya_cohen_arad_rotem;

import java.util.Comparator;

public class PenguinNameComparator implements Comparator<Penguin> {
    @Override
    public int compare(Penguin p1, Penguin p2) {
        return p1.getName().compareTo(p2.getName()); // Sort by name in ascending order
    }
}
