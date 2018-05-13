import java.io.*; // PrintWriter

public class PolylineTest1 {
    public static void main(String[] args){
        PrintWriter out = new PrintWriter(System.out, true);

        Point[] points = new Point[3];
        points[0] = new Point("A", 1, 1);
        points[1] = new Point("B", 2, 2);
        points[2] = new Point("C", 3, 3);

        Polyline1 pLine = new Polyline1(points);

        out.println(pLine);

        points = pLine.getVertices();

        for (int i=0;i<points.length;i++){
            out.println("Vertice #" + (i+1) + ": " + points[i]);
        }

        out.println("Colour: " + pLine.getColour());
        pLine.setColour("green");
        out.println("Colour: " + pLine.getColour());

        out.println("Width: " + pLine.getWidth());
        pLine.setWidth(3);
        out.println("Width: " + pLine.getWidth());

        out.println("Length: " + pLine.length());

        Point p1 = new Point("D", 4, 4);
        pLine.addLast(p1);
        out.println(pLine);

        Point p2 = new Point("E", 5, 5);
        pLine.addBefore(p2, p2.getName());
        out.println(pLine);

        pLine.remove(p1.getName());
        out.println(pLine);
    }
}

