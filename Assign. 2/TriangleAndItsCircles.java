import java.util.*;
import java.lang.Math;

public class TriangleAndItsCircles{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);

        System.out.print("a:");
        double a = in.nextDouble();

        System.out.print("b:");
        double b = in.nextDouble();

        System.out.print("c:");
        double c = in.nextDouble();

        double circumRad = Triangle.calcCircumCircle(a,b,c);
        double inRad = Triangle.calcInCircle(a,b,c);

        System.out.println("Circumcircle radius: " + circumRad);
        System.out.println("Incircle radius: " + inRad);
    }
}

