package com.example.careerapp1036568;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IT extends AppCompatActivity {
    private Button professionals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_t);
        //code for changing screen Title
        getSupportActionBar().setTitle("IT");

        professionals = (Button) findViewById(R.id.professional);

        //opening professions page
        professionals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfessionals();
            }
        });
    }

    //open ITActivity
    public void openProfessionals(){
        Intent intent = new Intent(this, Professionals.class);
        startActivity(intent);
    }
}