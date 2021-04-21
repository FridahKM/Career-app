package com.example.careerapp1036568;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button Medicine;
    private Button Law;
    private Button Engineering;
    private Button Finance;
    private Button IT;
    private Button Arts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Medicine = (Button) findViewById(R.id.MedicineCourse);
        Law = (Button) findViewById(R.id.LawCourse);
        Engineering = (Button) findViewById(R.id.EngineeringCourse);
        Finance = (Button) findViewById(R.id.FinanceCourse);
        IT = (Button) findViewById(R.id.ITCourse);
        Arts = (Button) findViewById(R.id.ArtsCourse);

        Medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMedicine();
            }
        });

        Law.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLaw();
            }
        });

        Arts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openArts();
            }
        });

        Engineering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEngineering();
            }
        });

        IT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIT();
            }
        });

        Finance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFinance();
            }
        });
    }

    //open MedicineActivity
    public void openMedicine(){
        Intent intent = new Intent(this, Medicine.class);
        startActivity(intent);
    }

    //open LawActivity
    public void openLaw(){
        Intent intent = new Intent(this, Law.class);
        startActivity(intent);
    }

    //open ArtsActivity
    public void openArts(){
        Intent intent = new Intent(this, Arts.class);
        startActivity(intent);
    }

    //open FinanceActivity
    public void openFinance(){
        Intent intent = new Intent(this, Finance.class);
        startActivity(intent);
    }

    //open EngineeringActivity
    public void openEngineering(){
        Intent intent = new Intent(this, Engineering.class);
        startActivity(intent);
    }

    //open ITActivity
    public void openIT(){
        Intent intent = new Intent(this, IT.class);
        startActivity(intent);
    }

}