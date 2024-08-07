public class Point {
    private double x, y;

    public Point(double a, double b){
        x = a;
        y = b;
    }
    public Point() {
        x = 0;
        y = 0;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    public double distanceFrom(Point pt){
        double dx = pt.getX() - this.x;
        double dy = pt.getY() - y;

        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }



}

