class TheShortestPath
{

// The method intermediateStations returns a vector of the
// intermediate stations that are on the shortest path .
// The ordinal number of the first station is located in
// index 1 of the vector , and the second station on index 2.

    public static int[] intermediateStations(double[] a, double[][] b , double[] c)
    {
        int[] vals = {0,0};
        double len = a[0] + b[0][0] + c[0]; /*inits length with any length to be able to compare with other lengths */
        double temp;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                temp = a[i] + b[i][j] + c[j];

                if (temp < len) {   /*Saves length and station indexes if length is shorter then previosly saved length*/
                    len = temp;
                    vals[0] = i + 1;
                    vals[1] = j + 1;
                }
            }
        }

        return vals;
    }

// The method length returns the length of the shortest path .

    public static double length (double[] a , double[][] b, double[] c)
    {
        double len = a[0] + b[0][0] + c[0]; /*inits length with any length to be able to compare with other lengths */
        double temp;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                temp = a[i] + b[i][j] + c[j];

                if (temp < len) { /*Saves length if length is shorter then previosly saved length*/
                    len = temp;
                }
            }
        }

        return len;
    }

}