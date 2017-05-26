package com.example.aryan.saarangapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RegestrationDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textview_catagory_1 =(TextView)findViewById(R.id.catagory_1);
        textview_catagory_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this,
                        Catagory1Activity.class);
                startActivity(myIntent);
            }
        });


        TextView textview_catagory_2 =(TextView)findViewById(R.id.catagory_2);
        textview_catagory_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this,
                        Catagory2Activity.class);
                startActivity(myIntent);
            }
        });


        TextView textview_catagory_3 =(TextView)findViewById(R.id.catagory_3);
        textview_catagory_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this,
                        Catagory3Activity.class);
                startActivity(myIntent);
            }
        });


        TextView textview_catagory_4 =(TextView)findViewById(R.id.catagory_4);
        textview_catagory_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this,
                        Catagory4Activity.class);
                startActivity(myIntent);
            }
        });


        TextView textview_catagory_5 =(TextView)findViewById(R.id.catagory_5);
        textview_catagory_5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this,
                        Catagory5Activity.class);
                startActivity(myIntent);
            }
        });


        TextView textview_catagory_6 =(TextView)findViewById(R.id.catagory_6);
        textview_catagory_6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this,
                        Catagory6Activity.class);
                startActivity(myIntent);
            }
        });


        //fab function

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });
        mDbHelper = new RegestrationDbHelper(this);


    }
}
