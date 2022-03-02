package com.example.personalhealthmonitoringapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {
    ImageButton mProfile, mVitals, mMedication, mDiet, mNotes, mAppointment, mSearch, mCommunication;
    Button mSignOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProfile = findViewById(R.id.Profile);
        mVitals = findViewById(R.id.Vitals);
        mMedication = findViewById(R.id.Medication);
        mDiet = findViewById(R.id.Diet);
        mNotes = findViewById(R.id.Notes);
        mAppointment = findViewById(R.id.Appointment);
        mSearch = findViewById(R.id.Search);
        mCommunication = findViewById(R.id.Communication);
        mSignOut = findViewById(R.id.SignOut);

        mProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), profileActivity.class));
            }
        });

        mVitals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), vitalActivity.class));
            }
        });

        mMedication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), medicationActivity.class));
            }
        });

        mDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), dietActivity.class));
            }
        });

        mNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), notesActivity.class));
            }
        });

        mAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), appointmentActivity.class));
            }
        });

        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), searchActivity.class));
            }
        });

        mCommunication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), communicationActivity.class));
            }
        });

        mSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));

            }

        });


    }
}

