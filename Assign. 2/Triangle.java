class Triangle {
    public Triangle() {

    }
    public static double calcArea(double a, double b, double c) {
        double s = (a + b + c) / 2;
 
        double area = Math.sqrt(s * ((s - a) * (s - b) * (s - c)));

        return area;
    }
    public static double calcPerimeter(double a, double b, double c) {
        double perimeter = a + b + c;

        return perimeter;
    }
    public static double calcCircumCircle(double a, double b, double c) {
        double radius = a * b * c;

        radius = radius / Math.sqrt((a + b + c) * (b + c - a) * (c + a - b) * (a + b - c));

        return radius;
    }  
    public static double calcInCircle(double a, double b, double c){
        double perimeter = calcPerimeter(a, b, c);
        double area = calcArea(a, b, c);
        double radius = (2 * area) / perimeter;

        return radius;
    }
}