package com.vogella.android.metro;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Helpline extends AppCompatActivity implements View.OnClickListener {

    Button[] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpline);

        buttons = new Button[9];

        for(int i=0; i<buttons.length; i++) {
            String buttonId = "button" + (i+1);
            int resId = getResources().getIdentifier(buttonId, "id", getPackageName());
            buttons[i] = findViewById(resId);
            buttons[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        for(int i=0; i<9; i++) {
            if (buttons[i].getId() == view.getId()) {
                String number = buttons[i].getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + number));
                startActivity(callIntent);
                break;
            }
        }
    }
}
