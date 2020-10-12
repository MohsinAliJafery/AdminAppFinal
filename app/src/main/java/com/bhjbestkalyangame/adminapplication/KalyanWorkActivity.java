package com.bhjbestkalyangame.adminapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class KalyanWorkActivity extends AppCompatActivity {
     private TextView dateTimeDisplay;
     private Calendar calendar;
     private SimpleDateFormat dateFormat;
     private  String date;
     private Button singleGameButton, mNotification;
     private  Button joriGameButton;
     private  Button panelGameButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalyan_work);
        /* start display date code */

        dateTimeDisplay = (TextView)findViewById(R.id.dateFieldID);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("MM/dd/yyyy    h:mm a");
        date = dateFormat.format(calendar.getTime());
        dateTimeDisplay.setText(date);     /* End display date code */

        singleGameButton = (Button) findViewById((R.id.SingleButtonID));
        joriGameButton =(Button) findViewById((R.id.JoriButtonID));
        panelGameButton =(Button) findViewById((R.id.PanelButtonID));
        mNotification = findViewById(R.id.notification);


        singleGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KalyanWorkActivity.this, ChooseActivity.class);
                intent.putExtra("mFrom", "Single");
                startActivity(intent);
                finish();
            }
        });
        joriGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KalyanWorkActivity.this, ChooseActivity.class);
                intent.putExtra("mFrom","Jodi");
                startActivity(intent);
                finish();
            }
        });
        panelGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KalyanWorkActivity.this, ChooseActivity.class);
                intent.putExtra("mFrom","Panel");
                startActivity(intent);
                finish();
            }
        });

        mNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KalyanWorkActivity.this, NotificationActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}