import java.util.*;

class DetermineTheShortestPath {
    static double[] a;
    static double[][] b;
    static double[] c;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter y for predetermined inputs, otherwise random");
        System.out.println();
        String s = in.next();

        if (s=="y"){
            fillArrays();
        } else {
            fillArrays(5,4);
        }
 


        System.out.println("Z1-Z2:");
        System.out.println(Arrays.toString(a));
        System.out.println();

        System.out.println("Z2-Z3:");
        for (double[] bi : b) {
            System.out.println(Arrays.toString(bi));
        }
        System.out.println();

        System.out.println("Z3-Z4:");
        System.out.println(Arrays.toString(c));
        System.out.println();

        System.out.println("Shortest path length:");
        System.out.println(TheShortestPath.length(a,b,c));
        System.out.println();

        System.out.println("Um, Vn:");
        System.out.println(Arrays.toString(TheShortestPath.intermediateStations(a,b,c)));
    }
    
    /*Fills arrays with random path lengths*/
    public static void fillArrays(int m, int n) {
        Random rnd = new Random();

        a = new double[m];
        b = new double[m][n];
        c = new double[n];

        for (int i = 0; i < m; i++) {
            a[i] = rnd.nextInt(9) + 1;
     
            for (int j = 0; j < n; j++) {
                b[i][j] = rnd.nextInt(10) + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            c[i] = rnd.nextInt(10) + 1;        
        }
    }

    /* Fills arrays with predetermined pathlengths */
    public static void fillArrays() {
        a = new double[3];
        b = new double[3][4];
        c = new double[4];

        a[0] = 5;
        a[1] = 3;
        a[2] = 2;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                b[i][j] = j + 1;
            }
        }

        c[0] = 6;
        c[1] = 8;
        c[2] = 2;
        c[3] = 4;
    }
}