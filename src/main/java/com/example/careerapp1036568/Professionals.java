package com.example.careerapp1036568;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Professionals extends AppCompatActivity {
    ListView listView;
    //arays with information to be displayed
    String pName[] = {"Mary Maina", "James Gachie", "Gloria Kasivu", "Henry Ochieng'", "Hamilia Gureo"};
    String pField[] = {"Medicine", "Finance", "Medicine", "Law", "Arts"};
    String pNumber[] = {"0712339872", "041545236", "485236751", "178523665","1235217786"};
    int pImage[] = {R.drawable.lawyer, R.drawable.nurse, R.drawable.veterinary, R.drawable.forensic, R.drawable.dentist};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professionals);
        //code for changing screen Title
        getSupportActionBar().setTitle("Talk to a Professional");

        listView = findViewById(R.id.listViewProfs);

        //creating an adapter class
        MyAdapter adapter = new MyAdapter(this, pName, pField, pImage, pNumber);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(Professionals.this, "Calling "+pNumber[position], Toast.LENGTH_SHORT).show();
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse(pNumber[position]));
                    if ( ActivityCompat.checkSelfPermission(Professionals.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivity(callIntent);
                }
                if (position ==  1) {
                    Toast.makeText(Professionals.this, "Calling "+pNumber[position], Toast.LENGTH_SHORT).show();
                }
                if (position ==  2) {
                    Toast.makeText(Professionals.this, "Calling "+pNumber[position], Toast.LENGTH_SHORT).show();
                }
                if (position ==  3) {
                    Toast.makeText(Professionals.this, "Calling "+pNumber[position], Toast.LENGTH_SHORT).show();
                }
                if (position ==  4) {
                    Toast.makeText(Professionals.this, "Calling "+pNumber[position], Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //adapter class
    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String nameProf[];
        String fieldProf[];
        int imageProf[];

        MyAdapter(Context c, String[] nameP, String[] fieldP, int[] imageP, String[] pNumber) {
            super(c, R.layout.row, R.id.profName, nameP);
            this.context = c;
            this.nameProf = nameP;
            this.fieldProf = fieldP;
            this.imageProf = imageP;
        }

        @NonNull
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.imageProf);
            TextView myName = row.findViewById(R.id.profName);
            TextView myField = row.findViewById(R.id.profField);

            // setting the resources on teh views
            images.setImageResource(imageProf[position]);
            myName.setText(nameProf[position]);
            myField.setText(fieldProf[position]);

            return row;
        }
    }
}