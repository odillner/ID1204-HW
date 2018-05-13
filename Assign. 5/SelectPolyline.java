import java.util.Random;

class SelectPolyline{

    public static final Random rand = new Random();
    public static final int NOF_POLYLINES = 10;

    public static void main(String[] args){
        // Create a random number of polylines
        Polyline[] polylines = new Polyline[NOF_POLYLINES];

        for (int i=0;i<NOF_POLYLINES;i++){
            polylines[i] = randomPolyline();
        }

        // Show the polylines
        System.out.println("Polylines:");
        for (int i=0;i<NOF_POLYLINES;i++){
            System.out.println("Polyline #" + (i+1) + ": " + polylines[i] + " Length: " + polylines[i].length());
        }
        // Determine the shortest yellow polyline
        double len = 0;
        int l = 0;
        /*Saves the length of the first yellow polyline for comparision */
        while (polylines[l].getColour()!="yellow"){
            len = polylines[l].length();
            l++;

            if (!(l<NOF_POLYLINES)){ /*Exits loop if out of bounds*/
                break;
            }
        }

        l = 0;

        for (int i=0;i<NOF_POLYLINES;i++){
            if (polylines[i].getColour()=="yellow"){
                if (polylines[i].length() < len){
                    len = polylines[i].length();
                    l = i;                          /*Saves polyline index*/
                }
            }
        }


        // Show the selected polyline
        System.out.println("Shortest yellow polyline: " + polylines[l]);

    }

    // The randomPoint method returns a new Point with a name
    // randomly chosen from the single letters A - - Z . Coordinates
    // are random .

    public static Point randomPoint(){
        String n = "" + (char) (65 + rand.nextInt(26));
        int x = rand.nextInt(11);
        int y = rand.nextInt(11);

        return new Point (n,x,y);
    }

// The method randomPolyline returns a random polyline ,

// with a colour either blue , red , or yellow . The names

// of the vertices are single letters from the set A - - Z .

// Two vertices can not have the same name .

    public static Polyline randomPolyline(){
// Create an empty polyline and add vertices
        Polyline polyline = new Polyline();
        int nofVertices = 2+rand.nextInt(7);
        int nofSelectedVertices = 0;
        boolean[] selectedNames = new boolean[26];

        // Two vertices can not have the same name

        Point chosenPoint = null ;
        char chosenChar = 0;

        while (nofSelectedVertices<nofVertices){
            chosenPoint = randomPoint();
            chosenChar = chosenPoint.getName().charAt(0);

            if (!selectedNames[chosenChar-65]){ /*Checks if the name has been selected, if not, saves it in the polyline */
                polyline.addLast(chosenPoint);
                nofSelectedVertices++;
            }
        }

        // Assign a colour
        String[] colours = {"blue","red","blue"};
        polyline.setColour(colours[rand.nextInt(3)]);

        return polyline;


    }
}