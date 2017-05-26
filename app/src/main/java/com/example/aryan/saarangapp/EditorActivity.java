package com.example.aryan.saarangapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditorActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mEmailIdEditText;
    private EditText mContactEditText;
    private Spinner mCatagorySpinner;
    private Spinner mEventsSpinner;

    private int mCatagory=0;
    private int mEvents=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);


        mNameEditText = (EditText) findViewById(R.id.edit_name);
        mEmailIdEditText= (EditText) findViewById(R.id.edit_email_id);
        mContactEditText= (EditText) findViewById(R.id.edit_contact);

        mCatagorySpinner = (Spinner) findViewById(R.id.spinner_catagory);
        mEventsSpinner = (Spinner) findViewById(R.id.spinner_events);
        setupSpinner();
    }


    private void insertRegestration(){
        String nameString= mNameEditText.getText().toString().trim();
        String emailIdString=mEmailIdEditText.getText().toString().trim();
        String contactString=mContactEditText.getText().toString().trim();






        RegestrationDbHelper mDbHelper = new RegestrationDbHelper(getBaseContext());
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RegestrationContract.RegestrationEntry.COLUMN_REGESTRATION_NAME,nameString);
        values.put(RegestrationContract.RegestrationEntry.COLUMN_REGESTRATION_EMAIL_ID, emailIdString);
        values.put(RegestrationContract.RegestrationEntry.COLUMN_REGESTRATION_CONTACT, contactString);
        values.put(RegestrationContract.RegestrationEntry.COLUMN_REGESTRATION_CATAGORY, mCatagory);
        values.put(RegestrationContract.RegestrationEntry.COLUMN_REGESTRATION_EVENT, mEvents);
        Log.v("Editor activity",nameString);


        long newRowId = db.insert(RegestrationContract.RegestrationEntry.TABLE_NAME, null, values);
        if(newRowId==-1){
            Toast.makeText(getApplicationContext(),"error with regestration",Toast.LENGTH_SHORT).show();

        }
        else {Toast.makeText(getApplicationContext(),"Regestered successfully with id: "+newRowId,Toast.LENGTH_SHORT).show();}

    }


    private void setupSpinner(){
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter catagorySpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_Catagory_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        catagorySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mCatagorySpinner.setAdapter(catagorySpinnerAdapter);

        // Set the integer mSelected to the constant values
        mCatagorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.Catagory_one))) {
                        mCatagory = RegestrationContract.RegestrationEntry.CATAGORY_ONE;
                    } else if (selection.equals(getString(R.string.Catagory_two))) {
                        mCatagory = RegestrationContract.RegestrationEntry.CATAGORY_TWO;
                    } else if (selection.equals(getString(R.string.Catagory_three))) {
                        mCatagory = RegestrationContract.RegestrationEntry.CATAGORY_THREE;
                    } else if (selection.equals(getString(R.string.Catagory_four))) {
                        mCatagory = RegestrationContract.RegestrationEntry.CATAGORY_FOUR;
                    } else if (selection.equals(getString(R.string.Catagory_five))) {
                        mCatagory = RegestrationContract.RegestrationEntry.CATAGORY_FIVE;

                    } else {
                        mCatagory = RegestrationContract.RegestrationEntry.CATAGORY_SIX;
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mCatagory = 0; // Unknown
            }
        });



        //spinner for events
        ArrayAdapter eventSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_Event_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        eventSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mEventsSpinner.setAdapter(eventSpinnerAdapter);

        // Set the integer mSelected to the constant values
        mEventsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.Catagory_one))) {
                        mEvents = RegestrationContract.RegestrationEntry.EVENT_ONE;

                    } else {
                        mEvents = RegestrationContract.RegestrationEntry.EVENT_TWO;
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mEvents = 0; // Unknown
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                //Save ;'
                insertRegestration();


                //Exit activity
                finish();
                return true;
            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:

                // Do nothing for now
                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
