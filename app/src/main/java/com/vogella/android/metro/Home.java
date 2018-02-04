package com.vogella.android.metro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Home extends AppCompatActivity implements View.OnClickListener {

    Spinner from, to;
    Button find, about, helpline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        from = findViewById(R.id.from);
        to = findViewById(R.id.to);
        find = findViewById(R.id.find);
        about = findViewById(R.id.about);
        helpline = findViewById(R.id.helpline);
        find.setOnClickListener(this);
        about.setOnClickListener(this);
        helpline.setOnClickListener(this);

        ArrayAdapter<String> arr = new ArrayAdapter<>(Home.this, R.layout.support_simple_spinner_dropdown_item, FareBreakup.stations);
        from.setAdapter(arr);
        to.setAdapter(arr);

        from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                FareBreakup.source = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(Home.this, "Please select any station", Toast.LENGTH_SHORT).show();
            }
        });

        to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                FareBreakup.destination = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(Home.this, "Please select any station", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.about) {
            Intent i = new Intent(Home.this, About.class);
            startActivity(i);
        } else if (view.getId() == R.id.helpline) {
            Intent i = new Intent(Home.this, Helpline.class);
            startActivity(i);
        } else if (view.getId() == R.id.find) {
            Intent i = new Intent(Home.this, FareBreakup.class);
            startActivity(i);
        }
    }
}
