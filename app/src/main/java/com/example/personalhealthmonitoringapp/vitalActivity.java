package com.example.personalhealthmonitoringapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.PrivateKey;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class vitalActivity<mEmail> extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private EditText DName, BP, HRate, ResRate,chol,BTemp,notes;
    private Button btn;
    Email objEmail =  new Email();
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Vitals");
    private TextView dateText;

    private void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        String date = month +"/" + day +"/"+ year;
        dateText.setText(date);
        System.out.println(date);
    }
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vital);

        DName = findViewById(R.id.DName);
        BP = findViewById(R.id.BP);
        HRate = findViewById(R.id.HRate);
        ResRate = findViewById(R.id.rp);
        chol = findViewById(R.id.cholesterol);
        BTemp = findViewById(R.id.bTemp);
        notes = findViewById(R.id.notes);

        btn = findViewById(R.id.btn);
        dateText = findViewById(R.id.dateTextID);

        findViewById(R.id.dateBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String DNameStr = DName.getText().toString();
                String BPStr = BP.getText().toString();
                String NotesStr = notes.getText().toString();
                String CholStr = chol.getText().toString();
                String BTempStr = BTemp.getText().toString();
                String HRateStr = HRate.getText().toString();

                String ResRateStr = ResRate.getText().toString();
                String dateStr = dateText.getText().toString();

                HashMap<String , String> userMap = new HashMap<>();

                userMap.put("Dname" , DNameStr);
                userMap.put("BP" , BPStr);
                userMap.put("HRate" , HRateStr);
                userMap.put("ResRate" , ResRateStr);
                userMap.put("Date" , dateStr);
                userMap.put("Cholesterol" , CholStr);
                userMap.put("BodyTemp" ,BTempStr);
                userMap.put("Notes" , NotesStr);



                root.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {

                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(vitalActivity.this, "Vitals added Successfully", Toast.LENGTH_SHORT).show();
                    }
                });
                Intent intent = new Intent(vitalActivity.this,showVitals.class);
                startActivity(intent);
            }
        });
    }

}