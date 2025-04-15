package yahav_eliyahu_matanya_cohen_arad_rotem;

import java.util.Comparator;

public class PenguinAgeComparator implements Comparator<Penguin> {
    @Override
    public int compare(Penguin p1, Penguin p2) {
        return Integer.compare(p1.getAge(), p2.getAge()); // Sort by age in ascending order
    }
}