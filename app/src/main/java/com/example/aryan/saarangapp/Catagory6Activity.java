package com.example.aryan.saarangapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Catagory6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory6);



        TextView textview_catagory_6_event_1 =(TextView)findViewById(R.id.catagory_6_event_1);
        textview_catagory_6_event_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(Catagory6Activity.this,
                        Catagory1Event1Activity.class);
                startActivity(myIntent);
            }
        });

        TextView textview_catagory_6_event_2 =(TextView)findViewById(R.id.catagory_6_event_2);
        textview_catagory_6_event_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(Catagory6Activity.this,
                        Catagory1Event2Activity.class);
                startActivity(myIntent);
            }
        });
    }
}
