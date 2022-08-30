package divideandconquer.closestpairofpoints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestPairs {
    List<Point> points;

    public ClosestPairs(List<Point> points) {
        this.points = points;
    }

    public double findDistanceBetweenClosestPairs() {
        // Step 1: Create sorted lists of points
        List<Point> sortedXPoints = new ArrayList<>(this.points);
        List<Point> sortedYPoints = new ArrayList<>(this.points);

        Collections.sort(sortedXPoints, new XSorter());
        Collections.sort(sortedYPoints, new YSorter());

        // Step 2: Use recursion to find the closest pairs
        return findClosestPairs(sortedXPoints, sortedYPoints, sortedXPoints.size());
    }

    private double findClosestPairs(List<Point> sortedXPoints, List<Point> sortedYPoints, int numOfPoints) {
        // base case for recursion
        if (numOfPoints <= 3) {
            return determineClosestPair(sortedXPoints);
        }

        // Step 3: Determine middle point x coordinate
        int middleIndex = numOfPoints / 2;
        double middlePointX = sortedXPoints.get(middleIndex).getX();

        // Step 4: Recursively split points into subarrays
        List<Point> leftSubArray = new ArrayList<>();
        List<Point> rightSubArray = new ArrayList<>();

        for (int i = 0; i < numOfPoints; i++) {
            if (sortedXPoints.get(i).getX() <= middlePointX) {
                leftSubArray.add(sortedXPoints.get(i));
            } else {
                rightSubArray.add(sortedXPoints.get(i));
            }
        }

        double deltaLeft = findClosestPairs(leftSubArray, sortedYPoints, middleIndex);
        double deltaRight = findClosestPairs(rightSubArray, sortedYPoints, numOfPoints - middleIndex);

        double delta = Math.min(deltaLeft, deltaRight);

        List<Point> pointsInStrip = new ArrayList<>();

        for (int index = 0; index < numOfPoints; index++) {
            if (Math.abs(sortedYPoints.get(index).getX() - middlePointX) < delta) {
                pointsInStrip.add(sortedYPoints.get(index));
            }
        }

        double minimumDistanceInStrip = findMinimumDistance(pointsInStrip, delta);

        return Math.min(delta, minimumDistanceInStrip);
    }

    private double findMinimumDistance(List<Point> points, double delta) {
        double minimumDistance = delta;

        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size() && (points.get(j).getY() - points.get(i).getY()) < minimumDistance; j++) {
                minimumDistance = points.get(j).distanceFrom(points.get(i));
            }
        }

        return minimumDistance;
    }

    private double determineClosestPair(List<Point> points) {
        double minimumDistance = Double.MAX_VALUE;

        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                double distanceBetweenPoints = points.get(i).distanceFrom(points.get(j));
                if (distanceBetweenPoints < minimumDistance) {
                    minimumDistance = distanceBetweenPoints;
                }
            }
        }

        return minimumDistance;
    }
}
