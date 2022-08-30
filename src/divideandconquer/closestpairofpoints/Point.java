package divideandconquer.closestpairofpoints;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceFrom(Point otherPoint) {
        double distanceX = this.x - otherPoint.getX();
        double distanceY = this.y - otherPoint.getY();
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
