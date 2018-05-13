import java.util.*; // Scanner , Locale
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;

class Temperatures {
    public static void main ( String [] args ) {
        System.out.println(" TEMPERATURES \n");

        // input tools
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);

        // enter the number of weeks and measurements
        System.out.print(" number of weeks : ");
        int nofWeeks = in.nextInt();
        System.out.print(" number of measurements per week : ");
        int nofMeasurementsPerWeek = in.nextInt();
// storage space for temperature data
        double[][] t = new double[nofWeeks][nofMeasurementsPerWeek];
// read the temperatures
        for (int week = 0; week < nofWeeks; week++) {
            System.out.println(" temperatures - week " + (week+1) + ":");
            for (int reading = 0; reading < nofMeasurementsPerWeek; reading++)
                t[week][reading] = in.nextDouble();
        }
        System.out.println();
// show the temperatures
        System.out.println(" the temperatures :");
        for (int week = 0; week < nofWeeks; week++) {
            for (int reading = 0; reading < nofMeasurementsPerWeek; reading++)
                System.out.print(t[week][reading] + " ");
            System.out.println();
        }
        System.out.println();
// the least , greatest and average temperature - weekly
        double[] minT = new double[nofWeeks];
        double[] maxT = new double[nofWeeks];
        double[] sumT = new double[nofWeeks];
        double[] avgT = new double[nofWeeks];
// compute and store the least , greatest and average
// temperature for each week .
// *** WRITE YOUR CODE HERE ***
// show the least , greatest and average temperature for
// each week

        for (int week = 0; week < nofWeeks; week++) {
            minT[week] = t[week][0];
            maxT[week] = t[week][0];

            for (int measure=0; measure < nofMeasurementsPerWeek; measure++) {
                sumT[week] += t[week][measure];

                if (t[week][measure] < minT[week]){
                    minT[week] = t[week][measure];
                }

                if (t[week][measure] > maxT[week]){
                    maxT[week] = t[week][measure];
                }

            }

            avgT[week] = sumT[week] / nofMeasurementsPerWeek;

        }


// *** WRITE YOUR CODE HERE ***
// the least , greatest and average temperature - whole period
        double minTemp = minT[0];
        double maxTemp = maxT[0];
        double sumTemp = 0;
        double avgTemp = 0;

        for (int week=0; week < nofWeeks; week++) {
            if (minTemp > minT[week]) {
                minTemp = minT[week];
            }

            if (maxTemp < maxT[week]) {
                maxTemp = maxT[week];
            }
            sumTemp += sumT[week];
        }
        avgTemp = (sumTemp / nofWeeks) / nofMeasurementsPerWeek;

// compute and store the least , greatest and average
// temperature for the whole period
// *** WRITE YOUR CODE HERE ***
// show the least , greatest and average temperature for
// the whole period
        System.out.print("mintemp:" + minTemp + "\n");
        System.out.print("maxtemp:" + maxTemp + "\n");
        System.out.print("sumtemp:" + sumTemp + "\n");
        System.out.print("avgtemp:" + avgTemp + "\n");

        String[] columns = new String[nofMeasurementsPerWeek+5];
        Object[][] data = new Object[nofWeeks][nofMeasurementsPerWeek+5];

        String[] columnstotal = new String[4];
        Object[][] datatotal = new Object[1][4];
        
        columns[0] = "week";
        for (int i=1;i<nofMeasurementsPerWeek+1;i++){
            columns[i] = "meas." + i;
        }

        for (int i=0;i<nofWeeks;i++){
            data[i][0] = i+1;
            for (int k=0;k<nofMeasurementsPerWeek;k++){
                data[i][k+1] = t[i][k];
            }
            data[i][nofMeasurementsPerWeek+1] = minT[i];
            data[i][nofMeasurementsPerWeek+2] = maxT[i];
            data[i][nofMeasurementsPerWeek+3] = sumT[i];
            data[i][nofMeasurementsPerWeek+4] = avgT[i];
        }
        datatotal[0][0] = minTemp;
        datatotal[0][1] = maxTemp;
        datatotal[0][2] = sumTemp;
        datatotal[0][3] = avgTemp;

        columns[nofMeasurementsPerWeek+1] = "minT";
        columns[nofMeasurementsPerWeek+2] = "maxT";
        columns[nofMeasurementsPerWeek+3] = "sumT";
        columns[nofMeasurementsPerWeek+4] = "avgT";

        for (int i=0;i<4;i++){
            columnstotal[i] = columns[nofMeasurementsPerWeek+i+1];
        }
        
        JFrame frame = new JFrame("Uppg1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTable table1 = new JTable(data, columns);
        table1.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table1.setFillsViewportHeight(true);
        JScrollPane pane1 = new JScrollPane(table1);


        JTable table2 = new JTable(datatotal,columnstotal);
        table2.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table2.setFillsViewportHeight(true);
        JScrollPane pane2 = new JScrollPane(table2);


        frame.setLayout(new BorderLayout());
        frame.add(pane1, BorderLayout.PAGE_START);
        frame.add(pane2, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);

        
// *** WRITE YOUR CODE HERE ***

    }
}

