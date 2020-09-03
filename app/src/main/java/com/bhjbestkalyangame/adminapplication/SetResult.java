package com.bhjbestkalyangame.adminapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SetResult extends AppCompatActivity {

    String mDate, mFrom;
    int mTotalNumber;
    TextView aDate, Heading;
    LinearLayout LY;
    EditText eT;

    FirebaseDatabase mDatabase;
    DatabaseReference mReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_result);

        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference("current_lucky_numbers");

        Intent mIntent = getIntent();
        Bundle mBundle = mIntent.getExtras();

        eT = new EditText(this);
        Heading = findViewById(R.id.heading);
        aDate = findViewById(R.id.date);
        LY = findViewById(R.id.input_text_linearlayout);

        mFrom = mBundle.getString("mFrom");
        mDate = mBundle.getString("mDate");
        mTotalNumber = Integer.valueOf(mBundle.getString("mTotalNumber"));
        aDate.setText(mDate);
        Heading.setText("Enter "+ mFrom +" Numbers");

        for(int i = 0; i< mTotalNumber; i++){

            EditText ET = new EditText(this);
            ET.setId(i);
            ET.setHint("Enter " + (i+1) + " Number");
            LinearLayout.LayoutParams ETParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            ETParams.setMargins(0, 3,0, 10);
            ET.setInputType(InputType.TYPE_CLASS_NUMBER);
            ET.setLayoutParams(ETParams);
            LY.addView(ET);
        }
            int BID = 90;
            Button B = new Button(this);
            B.setId(BID);
            LinearLayout.LayoutParams BParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
            BParams.setMargins(0,7,0,0);
            B.setLayoutParams(BParams);
            B.setText("Upload");
            B.setBackgroundColor(Color.MAGENTA);
            B.setPadding(5,5,5,5);
            B.setTextColor(Color.WHITE);
            LY.addView(B);

            B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mReference.child(mFrom).removeValue();

                    for(int i= 0; i<mTotalNumber; i++) {
                        eT = findViewById(i);
                        mReference.child(mFrom).push().setValue(eT.getText().toString());
                    }
                    Intent IntentSuccess = new Intent(SetResult.this, Success.class);
                    IntentSuccess.putExtra("mFrom", mFrom);
                    startActivity(IntentSuccess);
                    finish();
                }
            });




    }
}
