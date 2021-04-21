package com.example.careerapp1036568;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Medicine extends AppCompatActivity {
    String[] medicineOptions = { "Select One","Dentistry", "Psychology", "Veterinary", "Surgery", "Nurse"};
    private Spinner medOptions;
    private ImageView occupationPic;
    private TextView Description;
    private TextView courseList;
    private TextView learnMore;
    private Button professionals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);
        //code for changing screen Title
        getSupportActionBar().setTitle("Medicine");

        View listView = findViewById(R.id.listView);

        /*Professionals.MyAdapter adapter = new Professionals.MyAdapter(this, CName, UName, nameU);
        listView.setAdapter(adapter);*/

        occupationPic = (ImageView) findViewById(R.id.photo);
        Description = (TextView) findViewById(R.id.CourseDescription);
        courseList = (TextView) findViewById(R.id.Courses);
        learnMore =(TextView) findViewById(R.id.LearnMore);
        professionals = (Button) findViewById(R.id.professional);

        //code for spinner
        Spinner medOptions = (Spinner) findViewById(R.id.MedSpinner);
        medOptions.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        ArrayAdapter med = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, medicineOptions);
        med.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        medOptions.setAdapter(med);

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

    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id){

        //views based on selection in spinner
        switch (position){
            case 1:
                occupationPic.setImageResource(R.drawable.dentist);
                Description.setText("A person who is qualified to treat diseases and other conditions that affect the teeth and gums, especially the repair and extraction of teeth and the insertion of artificial ones.");
                learnMore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gotoUrl("https://en.wikipedia.org/wiki/Dentistry");
                    }
                });

                //list courses

                break;
            case 2:
                occupationPic.setImageResource(R.drawable.psychologist);
                Description.setText("A psychologist is a person who specializes in the study of mind and behavior or in the treatment of mental, emotional, and behavioral disorders");
                learnMore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gotoUrl("https://en.wikipedia.org/wiki/Psychology");
                    }
                });

                break;
            case 3:
                occupationPic.setImageResource(R.drawable.veterinary);
                Description.setText("A veterinary doctor is a medical professional who provides prevention, cure or alleviation of disease and injury in animals and especially domestic animals.");
                learnMore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gotoUrl("https://en.wikipedia.org/wiki/Veterinary_medicine");
                    }
                });
                break;
            case 4:
                occupationPic.setImageResource(R.drawable.surgeon);
                Description.setText(" A surgeon is a physician who treats disease, injury, or deformity via operative or manual methods to physically change body tissues");
                learnMore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gotoUrl("https://en.wikipedia.org/wiki/Surgery");
                    }
                });
                break;
            case 5:
                occupationPic.setImageResource(R.drawable.nurse);
                Description.setText("A nurse is a person whose job is to care for people who are ill or injured. They may also help doctors in treating the patients");
                learnMore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gotoUrl("https://en.wikipedia.org/wiki/Nursing");
                    }
                });
                break;

        }
    }


    //open ITActivity
    public void openProfessionals(){
        Intent intent = new Intent(this, Professionals.class);
        startActivity(intent);
    }

}