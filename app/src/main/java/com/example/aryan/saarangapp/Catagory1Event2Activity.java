package com.example.aryan.saarangapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Catagory1Event2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory1_event2);


        TextView textview_catagory_1_event_1_location =(TextView)findViewById(R.id.location_1_1);
        textview_catagory_1_event_1_location.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                double latitude = 13.006334;
                double longitude = 80.242025;
                String label = "IITM";
                String uriBegin = "geo:" + latitude + "," + longitude;
                String query = latitude + "," + longitude + "(" + label + ")";
                String encodedQuery = Uri.encode(query);
                String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                Uri uri = Uri.parse(uriString);
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });



        TextView textview_catagory_1_event_1_call =(TextView)findViewById(R.id.call_1_1);
        textview_catagory_1_event_1_call.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String phone = "9400604865";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });

        TextView textview_catagory_1_event_1_mail =(TextView)findViewById(R.id.mail_1_1);
        textview_catagory_1_event_1_mail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "ch15b009@smail.iitm.ac.in");
                intent.putExtra(Intent.EXTRA_SUBJECT, "event regestration");
                intent.putExtra(Intent.EXTRA_TEXT, "please enter the message");

                startActivity(Intent.createChooser(intent, "Send Email"));


            }
        });

    }
}
