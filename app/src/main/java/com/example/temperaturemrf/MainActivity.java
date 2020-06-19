package com.example.temperaturemrf;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.annotation.NonNull;
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
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    String currentDate = sdf.format(new Date());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = findViewById(R.id.date);

        date.setText(currentDate);

        empnum = findViewById(R.id.empno);
        busTemperataure = findViewById(R.id.busTemp);
        recorder = findViewById(R.id.recorder);
        inTemperature = findViewById(R.id.inTemp);
        outTemperature = findViewById(R.id.outTemp);
        button = findViewById(R.id.button);

        dbTemp = FirebaseDatabase.getInstance().getReference("Data");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference reference =FirebaseDatabase.getInstance().getReference().child("Data");
                Query query = reference.orderByChild("employeeno").equalTo(empnum.getText().toString().trim()).orderByChild("date").equalTo(currentDate);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            updateEntry();
                        }
                        else
                            addToDatabase();
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });


    }

    private void addToDatabase() {
        String empnumberText = empnum.getText().toString().trim();
        String busTempText = busTemperataure.getSelectedItem().toString().trim();
        String recorderText = recorder.getText().toString().trim();
        String inTempText = inTemperature.getSelectedItem().toString().trim();
        String outTempText = outTemperature.getSelectedItem().toString().trim();

        if (!TextUtils.isEmpty(empnumberText) && !TextUtils.isEmpty(recorderText)) {
            String id = dbTemp.push().getKey();

            entry dataentry = new entry(currentDate, empnumberText, busTempText, recorderText, inTempText, outTempText);
            dbTemp.child(id).setValue(dataentry);
            Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Enter all fields", Toast.LENGTH_LONG).show();
        }
    }

    private void updateEntry(){
        Toast.makeText(this,"Same employee num",Toast.LENGTH_LONG).show();
    }

}

