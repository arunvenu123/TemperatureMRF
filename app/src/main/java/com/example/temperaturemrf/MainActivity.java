package com.example.temperaturemrf;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView date;
    EditText empnum;
    Spinner busTemperataure;
    EditText recorder;
    Spinner inTemperature;
    Spinner outTemperature;
    DatabaseReference dbTemp;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = findViewById(R.id.date);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String currentDate = sdf.format(new Date());
        date.setText(currentDate);

        empnum = findViewById(R.id.empno);
        busTemperataure = findViewById(R.id.busTemp);
        recorder = findViewById(R.id.recorder);
        inTemperature = findViewById(R.id.inTemp);
        outTemperature = findViewById(R.id.outTemp);
        button = findViewById(R.id.button);

        String empnumberText = empnum.getText().toString().trim();
        String busTempText = busTemperataure.getSelectedItem().toString().trim();
        String recorderText = recorder.getText().toString().trim();
        String inTempText = inTemperature.getSelectedItem().toString().trim();
        String outTempText = outTemperature.getSelectedItem().toString().trim();


    }
}
