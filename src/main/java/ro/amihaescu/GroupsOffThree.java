package ro.amihaescu;

import java.util.TreeSet;

public class GroupsOffThree {

    private final TreeSet<Double> set;
    private final int distance;

    public GroupsOffThree(int distance) {
        set = new TreeSet<>();
        this.distance = distance;
    }

    public static void main(String[] args) {
        var group = new GroupsOffThree(2);
        group.add(1);
        group.add(3);
        group.add(7);
        group.add(5);
        group.add(10);
        group.add(23);
    }

    public void add(double value) {
        set.add(value);
        Double lower = set.lower(value);
        Double lower2 = lower != null ? set.lower(lower) : null;
        Double upper = set.higher(value);
        Double upper2 = upper != null ? set.higher(upper) : null;
        var isGroup = isGroup(value, lower, lower2) || isGroup(upper2, upper, value) || isGroup(upper, value, lower);
        if (isGroup) System.out.println("Group found");
        printSet(set);
    }

    private boolean isGroup(Double value, Double lower, Double lower2) {
        if (lower == null || lower2 == null || value == null) {
            return false;
        }
        if (value - lower <= distance && lower - lower2 <= distance) {

            set.remove(value);
            set.remove(lower2);
            set.remove(lower);
            return true;
        }
        return false;
    }

    private void printSet(TreeSet<Double> set) {
        System.out.println("Set: ");
        for (Double value : set) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
