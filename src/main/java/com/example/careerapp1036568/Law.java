package com.example.careerapp1036568;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Law extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] LawOptions = { "Select One","Forensic Science", "Lawyer", "Criminology"};
    private Spinner lawOptions;
    private ImageView occupationPic;
    private TextView Description;
    private TextView courseList;
    private TextView learnMore;
    private Button professionals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_law);
        //code for changing screen Title
        getSupportActionBar().setTitle("Law");

        occupationPic = (ImageView) findViewById(R.id.photoLaw);
        Description = (TextView) findViewById(R.id.CourseDescriptionLaw);
        courseList = (TextView) findViewById(R.id.CoursesLaw);
        learnMore =(TextView) findViewById(R.id.LearnMoreLaw);
        professionals = (Button) findViewById(R.id.professional);

        //code for spinner
        Spinner lawOptions = (Spinner) findViewById(R.id.LawSpinner);
        lawOptions.setOnItemSelectedListener(this);

        ArrayAdapter law = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, LawOptions);
        law.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lawOptions.setAdapter(law);

        //opening professions page
        professionals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfessionals();
            }
        });
    }

    //method for opening Url links
    public void gotoUrl(String s){
        Uri link = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, link));
    }

    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id){

        //views based on selection in spinner
        switch (position){
            case 1:
                occupationPic.setImageResource(R.drawable.forensic);
                Description.setText("Aforensic scientist provides scientific evidence for use in courts of law to support the prosecution or defence in criminal and civil investigations.");
                learnMore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gotoUrl("https://en.wikipedia.org/wiki/Forensic_science");
                    }
                });
                break;
            case 2:
                occupationPic.setImageResource(R.drawable.lawyer);
                Description.setText("A psychologist is a person whose profession is to represent clients in a court of law or to advise or act for clients in other legal matters.");
                learnMore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gotoUrl("https://en.wikipedia.org/wiki/Lawyer");
                    }
                });
                break;
            case 3:
                occupationPic.setImageResource(R.drawable.criminology);
                Description.setText("A criminologist is one who studies the biological and sociological causes and consequences of crime and criminal behavior.");
                learnMore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gotoUrl("https://en.wikipedia.org/wiki/Criminology");
                    }
                });
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //open ITActivity
    public void openProfessionals(){
        Intent intent = new Intent(this, Professionals.class);
        startActivity(intent);
    }

}