package com.bhjbestkalyangame.adminapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NotificationActivity extends AppCompatActivity {

    FirebaseDatabase mDatabase;
    DatabaseReference mReference, mRef;

    Button mNotify;
    EditText mText;
    TextView mNotiTrigger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        mText = findViewById(R.id.tinker);

        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference("Notification");
        mRef = mDatabase.getReference("Notification");

        mNotiTrigger = findViewById(R.id.notification_number);

        mNotify = findViewById(R.id.notify);

        mNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mReference.child("Tinker").setValue(mText.getText().toString());
            }
        });

        mRef.child("Tinker").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mNotiTrigger.setText(""+snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}
