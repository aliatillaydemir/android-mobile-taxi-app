package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class AraClass extends AppCompatActivity {

    Button but;
    Spinner kutu;
    static int kontrol;



    private static final String[] path = {"5.gün", "6.gün", "7.gün", "8.gün", "9.gün", "10.gün", "11.gün", "12.gün",
            "13.gün", "14.gün", "15.gün", "16.gün", "17.gün", "18.gün", "19.gün", "20.gün"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ara_class);

        but= findViewById(R.id.arabuton);

        kutu=(Spinner)findViewById(R.id.kutucuk);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AraClass.this,
                android.R.layout.simple_spinner_item,path);

        kutu.setAdapter(adapter);

        kutu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getId() == R.id.kutucuk) {
                    switch (position) {

                        case 0:
                            kontrol=0;
                            break;

                        case 1:
                            kontrol=1;
                            break;

                        case 2:
                            kontrol=2;
                            break;

                        case 3:
                            kontrol=3;
                            break;

                        case 4:
                            kontrol=4;
                            break;

                        case 5:
                            kontrol=5;
                            break;

                        case 6:
                            kontrol=6;
                            break;

                        case 7:
                            kontrol=7;
                            break;

                        case 8:
                            kontrol=8;
                            break;

                        case 9:
                            kontrol=9;
                            break;

                        case 10:
                            kontrol=10;
                            break;

                        case 11:
                            kontrol=11;
                            break;

                        case 12:
                            kontrol=12;
                            break;

                        case 13:
                            kontrol=13;
                            break;

                        case 14:
                            kontrol=14;
                            break;

                        case 15:
                            kontrol=15;
                            break;
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                open();
            }
        });

    }

    public void open(){
        Intent intentee = new Intent(this, Activity4.class);
        startActivity(intentee);
    }




}