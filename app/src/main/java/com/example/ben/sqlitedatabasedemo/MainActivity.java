package com.example.ben.sqlitedatabasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameField;
    private NumberPicker numberPicker;
    private Button submitButton;
    private Button viewDetails;
    private Button deleteButton;
    private Button createTbl;
    private MyDatabaseAdapter myDatabaseAdapter;
    private String TAG = "MAIN_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nameField = (EditText)findViewById(R.id.nameField);
        numberPicker = (NumberPicker)findViewById(R.id.numberPicker);
        viewDetails = (Button)findViewById(R.id.viewDetails);
        numberPicker.setMaxValue(100);
        numberPicker.setMinValue(0);
        submitButton = (Button)findViewById(R.id.submitButton);
        deleteButton = (Button)findViewById(R.id.deleteButton);
        createTbl = (Button)findViewById(R.id.createTbl);

        submitButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
        viewDetails.setOnClickListener(this);
        createTbl.setOnClickListener(this);

        // Make an instance of the outerclass, MyDatabaseAdapter to interact with the innerclass
        // MyDatabaseHelper.. Like doing insert/delete ect.
        myDatabaseAdapter = new MyDatabaseAdapter(this);


    }


    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick: ");
        // Insert data from EditText/numberpicker into database
        int  i = v.getId();
        switch(i) {
            case R.id.submitButton: long id = myDatabaseAdapter.insertData(nameField.getText().toString(), numberPicker.getValue());
                break;
            case R.id.deleteButton: myDatabaseAdapter.deleteTable();
                break;
            case R.id.viewDetails: myDatabaseAdapter.displayTable();
                break;
            case R.id.createTbl: myDatabaseAdapter.addTable();
                break;

        }
    }
}
