public class Point {
    String name = "";
    int x = 0;
    int y = 0;

    public Point(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }
    public Point(int x, int y){
        this.name = "";
        this.x = x;
        this.y = y;
    }
    public Point(Point p){
        this.name = p.getName();
        this.x = p.getX();
        this.y = p.getY();
    }
    public String toString(){
        return "(" + getName() + " " + getX() + " " + getY() + ")";
    }
    public String getName(){
        return this.name;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    
    /* Calculates distance relative to provided point using Pythagoras theorem */
    public double distance(Point p){
        int a = Math.abs(this.x-p.getX());
        int b = Math.abs(this.y-p.getY());

        double c = Math.sqrt(a*a+b*b);
        return c;
    }

}