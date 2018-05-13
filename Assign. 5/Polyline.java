public class Polyline {

    private Point[] vertices;
    private String colour = "black";
    private int width = 1;

    public Polyline() {
        this.vertices = new Point[0];
    }

    public Polyline(Point[] vertices) {
        this.vertices = new Point[vertices.length];

        for (int i = 0; i < vertices.length; i++) {

            this.vertices[i] = new Point(vertices[i]);

        }
    }

    public String toString() {
        String s = "{[";

        for (int i = 0; i < this.vertices.length;i++) {

            s += this.vertices[i].toString();

        }
        s += "], " + getColour() + ", " + getWidth() + "}";

        return s;
    }

    public Point[] getVertices(){
        Point[] h = new Point[this.vertices.length];

        for (int i = 0; i < this.vertices.length; i++){

            h[i] = this.vertices[i];

        }

        return h;
    }

    public String getColour() {
        return this.colour;
    }

    public int getWidth() {
        return this.width;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double length() {
        double d = 0;

        for (int i = 0; i < this.vertices.length - 1; i++) {

            d += this.vertices[i].distance(this.vertices[i + 1]);

        }

        return d;
    }

    public void addLast(Point vertex){
        Point[] h = new Point[this.vertices.length + 1];
        int i = 0;

        for (i = 0; i < this.vertices.length; i++){

            h[i] = this.vertices[i]; 

        }

        h[i] = new Point(vertex);

        this.vertices = h;
    }

    public void addBefore(Point vertex, String vertexName){
        Point[] h = new Point[this.vertices.length + 1];

        for (int i = 0; i < this.vertices.length; i++){

            h[i + 1] = this.vertices[i]; 

        }

        h[0] = new Point(vertex);
        h[0].setName(vertexName);

        this.vertices = h;
    }

    public void remove(String vertexName){
        Point[] h = new Point[this.vertices.length - 1];
        int count = 0;

        for (int i = 0; i < vertices.length; i++){

            if (this.vertices[i].getName()!=vertexName){
                h[count] = this.vertices[i];
                count++;
            }
            
        }

        this.vertices = h;
    }

    public class PolylineIterator
        {
        private int current = -1;
        public PolylineIterator()
        {
            if (Polyline.this.vertices.length > 0)
            current = 0;
        }
        public boolean hasNext()
        {
            return current != -1;
        }
        public Point vertex() throws java.util.NoSuchElementException
        {
            if (!this.hasNext())
                throw new java.util.NoSuchElementException("end of iteration");

            Point vertex = Polyline.this.vertices[current];

            return vertex;
        }
        public void next()
        {
            if (current >= 0 && current < Polyline.this.vertices.length - 1)
                current++;
            else
                current = -1;
        }
    }
}