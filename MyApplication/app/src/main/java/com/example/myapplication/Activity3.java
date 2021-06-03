package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class Activity3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private Spinner spinner2;

    Button btn;

    TextView txt_showc;
    TextView txt_showc2;
    TextView txt_showc3;
    TextView txt_showc4;
    TextView txt_showc5;

    FirebaseDatabase firebaseDatabse = FirebaseDatabase.getInstance("https://yazlab-fda20-default-rtdb.firebaseio.com/");
    DatabaseReference databaseReferenceRead;


    private static final String[] paths = {"5.gün", "6.gün", "7.gün", "8.gün", "9.gün", "10.gün", "11.gün", "12.gün",
            "13.gün", "14.gün", "15.gün", "16.gün", "17.gün", "18.gün", "19.gün", "20.gün"};

    private static final String[] paths2 = {"5.gün", "6.gün", "7.gün", "8.gün", "9.gün", "10.gün", "11.gün", "12.gün",
            "13.gün", "14.gün", "15.gün", "16.gün", "17.gün", "18.gün", "19.gün", "20.gün"};

    int birincitx;
    int ikincitx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        txt_showc = findViewById(R.id.txt_showc);
        txt_showc2 = findViewById(R.id.txt_showc2);
        txt_showc3 = findViewById(R.id.txt_showc3);
        txt_showc4 = findViewById(R.id.txt_showc4);
        txt_showc5 = findViewById(R.id.txt_showc5);

        btn=findViewById(R.id.btnumuz);

        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(Activity3.this,
                android.R.layout.simple_spinner_item,paths);

        spinner2 = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String>adapter2 = new ArrayAdapter<String>(Activity3.this,
                android.R.layout.simple_spinner_item,paths2);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        if (parent.getId() == R.id.spinner) {
            //do this

            switch (position) {


                case 0:
                    birincitx=0; //buralara gün için index tut. butona basma kısmında onlar işlenip sonuç verecek.
                    break;
                case 1:
                    birincitx=100;
                    break;
                case 2:
                    birincitx=200;
                    break;
                case 3:
                    birincitx=300;
                    break;
                case 4:
                    birincitx=400;
                    break;
                case 5:
                    birincitx=500;
                    break;
                case 6:
                    birincitx=600;
                    break;
                case 7:
                    birincitx=700;
                    break;
                case 8:
                    birincitx=800;
                    break;
                case 9:
                    birincitx=900;
                    break;
                case 10:
                    birincitx=1000;
                    break;
                case 11:
                    birincitx=1100;
                    break;
                case 12:
                    birincitx=1200;
                    break;
                case 13:
                    birincitx=1300;
                    break;
                case 14:
                    birincitx=1400;
                    break;
                case 15:
                    birincitx=1500;
                    break;

            }
        }

        if (parent.getId() == R.id.spinner2){
            //do this

            switch (position) {
                case 0:
                    ikincitx=100; //buralara gün için index tut. butona basma kısmında onlar işlenip sonuç verecek.
                    break;
                case 1:
                    ikincitx=200;
                    break;
                case 2:
                    ikincitx=300;
                    break;
                case 3:
                    ikincitx=400;
                    break;
                case 4:
                    ikincitx=500;
                    break;
                case 5:
                    ikincitx=600;
                    break;
                case 6:
                    ikincitx=700;
                    break;
                case 7:
                    ikincitx=800;
                    break;
                case 8:
                    ikincitx=900;
                    break;
                case 9:
                    ikincitx=1000;
                    break;
                case 10:
                    ikincitx=1100;
                    break;
                case 11:
                    ikincitx=1200;
                    break;
                case 12:
                    ikincitx=1300;
                    break;
                case 13:
                    ikincitx=1400;
                    break;
                case 14:
                    ikincitx=1500;
                    break;
                case 15:
                    ikincitx=1600;
                    break;

            }
        }



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }

    private void show()
        {
            ArrayList<String> distance = new ArrayList<>();
            ArrayList<String> liste = new ArrayList<>();

            databaseReferenceRead = firebaseDatabse.getReference();


            ValueEventListener valueEventListener = new ValueEventListener(){


                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        distance.add(dataSnapshot.child("trip_distance").getValue().toString());
                    }

                    for (int i=birincitx;i<ikincitx;i++)
                    {
                        if(distance.get(i).equals(".00"))
                            break;
                            liste.add(distance.get(i));

                    }

                    Collections.sort(liste);

                    txt_showc.setText("en kısa 1.yol: "+String.valueOf(liste.get(0)));
                    txt_showc2.setText(String.valueOf("en kısa 2.yol: "+liste.get(1)));
                    txt_showc3.setText(String.valueOf("en kısa 3.yol: "+liste.get(2)));
                    txt_showc4.setText(String.valueOf("en kısa 4.yol: "+liste.get(3)));
                    txt_showc5.setText(String.valueOf("en kısa 5.yol: "+liste.get(4)));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            };


            databaseReferenceRead.addValueEventListener(valueEventListener);
        }



}