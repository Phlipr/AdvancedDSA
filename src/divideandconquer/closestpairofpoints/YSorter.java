package divideandconquer.closestpairofpoints;

import java.util.Comparator;

public class YSorter implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        return Double.compare(o1.getY(), o2.getY());
    }
}
