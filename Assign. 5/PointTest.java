import java.io.*; // PrintWriter

public class PointTest{
    public static void main(String[] args){
        PrintWriter out = new PrintWriter(System.out, true);
        // test a constructor and a transformer
        Point p1 = new Point("A", 2, 2);
        Point p2 = new Point("B", 3, 3);
        out.println(p1 + " " + p2);
        // test inspectors
        String n = p1.getName();
        int x = p1.getX();
        int y = p1.getY();
        out.println(n + " " + x + " " + y);
        // test a combiner and a comparator
        double d = p1.distance(p2);
        out.println(d);
        boolean b = p1.equals(p2);
        out.println(b);
        // test mutators
        p2.setX(1);
        p2.setY(2);
        out.println(p2);
        // test another constructor
        Point p = new Point(p1);
        out.println(p);
    }
}

