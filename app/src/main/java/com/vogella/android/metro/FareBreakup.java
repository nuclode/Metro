package com.vogella.android.metro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FareBreakup extends AppCompatActivity {

    int price[][] = {{6, 6, 6, 11, 11, 11, 17, 17, 17},
            {6, 6, 6, 6, 11, 11, 11, 17, 17},
            {6, 6, 6, 6, 6, 11, 11, 11, 17},
            {11, 6, 6, 6, 6, 6, 11, 11, 11},
            {11, 11, 6, 6, 6, 6, 6, 11, 11},
            {11, 11, 11, 6, 6, 6, 6, 6, 11},
            {17, 11, 11, 11, 6, 6, 6, 6, 6},
            {17, 17, 11, 11, 11, 6, 6, 6, 6},
            {17, 17, 17, 11, 11, 11, 6, 6, 6}};

    double dist[][] = {{0, 1.45, 2.56, 3.44, 4.19, 5.3, 6.82, 8.07, 8.86},
            {1.45, 0, 1.11, 1.99, 2.73, 3.84, 5.36, 6.62, 7.41},
            {2.56, 1.11, 0, 0.88, 1.63, 2.74, 4.26, 5.51, 6.3},
            {3.44, 1.99, 0.88, 0, 0.75, 1.85, 3.38, 4.63, 5.42},
            {4.19, 2.73, 1.63, 0.75, 0, 1.11, 2.63, 3.88, 4.67},
            {5.3, 3.84, 2.74, 1.85, 1.11, 0, 1.52, 2.77, 3.56},
            {6.82, 5.36, 4.26, 3.38, 2.63, 1.52, 0, 1.25, 2.04},
            {8.07, 6.62, 5.51, 4.63, 3.88, 2.77, 1.25, 0, 0.79},
            {8.86, 7.41, 6.3, 5.42, 4.67, 3.56, 2.04, 0.79, 0}};

    TextView description, details;

    static String stations[] = {"Mansarovar", "New Aatish Market", "Vivek Vihar", "Shayam Nagar", "Ram Nagar", "Civil Line", "Railway Station", "Sindhi Camp", "Chandpole"};
    static int source, destination;

    StringBuilder sbr = new StringBuilder("");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fare_breakup);

        description = findViewById(R.id.description);
        details = findViewById(R.id.details);

        description.setText(stations[source] + " to " + stations[destination]);
        if (source <= destination) {
            for (int i = source; i <= destination; i++) {
                sbr.append(String.format("%-20s",stations[i]));
                sbr.append(String.format("%-10s",dist[source][i]));
                sbr.append(String.format("%-10s",price[source][i]));
                sbr.append("\n\n");
            }
        } else {
            for (int i = source; i >= destination; i--) {
                sbr.append(String.format("%-20s",stations[i]));
                sbr.append(String.format("%-10s",dist[source][i]));
                sbr.append(String.format("%-10s",price[source][i]));
                sbr.append("\n\n");
            }
        }

        details.setText("" + sbr.toString());
    }
}
