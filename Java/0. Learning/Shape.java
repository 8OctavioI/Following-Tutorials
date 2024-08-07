import java.util.ArrayList;

public class Shape {
    private String name;
    private int numOfPoints;
    //private Point[] points;
    ArrayList<Point> points = new ArrayList<Point>();
    private double perimeter;
    private double area;

    public double averageLength;
    public double maxLen = 0;

    public Shape(){
        name = "0-pointer";
    }

    public Shape(Point[] a){
        numOfPoints = a.length;
        for (Point pt : a) {
            points.add(pt);
        }
        update();
    }


    
    public double perimeter(){
        return perimeter;
    }
    public double area() {
        return area;
    }
    public String name(){
        return name;
    }

    public void dispDetails(){
        System.out.println(String.format("Name: %s\nPerimeter: %.2f\nArea: %.2f\nAverage Length: %.2f\nMax Length: %.2f", name, perimeter, area, averageLength, maxLen));
    }

    

    private double determinant(double a, double b, double c, double d){
        return a*d - b*c;
    }

    private void update(){
        name = String.format("%d-pointer", numOfPoints);
        perimeter = 0;
        area = 0;
        
        Point prevPoint = points.get(numOfPoints - 1);
        /*double dx = points.get(0).getX() - points.get(numOfPoints - 1).getX();
        double dy = points.get(0).getY() - points.get(numOfPoints - 1).getY();
        perimeter += Math.sqrt(Math.pow(dx,2) + Math.pow(dy, 2));

        area += Math.abs(determinant(points.get(0).getX(), points.get(0).getY(), points.get(numOfPoints - 1).getX(), points.get(numOfPoints - 1).getY()) / 2);
        */
        for (Point curr: points){
            double l = curr.distanceFrom(prevPoint);
            if (l > maxLen) maxLen = l;
            perimeter += l;
            area += Math.abs(determinant(curr.getX(), curr.getY(), prevPoint.getX(), prevPoint.getY()) / 2);
            prevPoint = curr;
        }
        averageLength = perimeter/numOfPoints;

    }

    public void addPoint(Point pt) {
        points.add(pt);
        numOfPoints++;
        update();
    }

    
}
