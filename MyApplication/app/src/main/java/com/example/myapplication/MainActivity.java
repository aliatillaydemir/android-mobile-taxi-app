package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buton1 = (Button) this.findViewById(R.id.button1);
        Button buton2 = (Button) this.findViewById(R.id.button2);
        Button buton3 = (Button) this.findViewById(R.id.button3);



        String tx1 = "1. butona basıldı";
        String tx2 = "2. butona basıldı";
        String tx3 = "3. butona basıldı";



        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, tx1, Toast.LENGTH_LONG).show();
                openActivity();
            }
        });

        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, tx2, Toast.LENGTH_LONG).show();
                openActivity2();
            }
        });

        buton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, tx3, Toast.LENGTH_LONG).show();
                openActivity3();
            }
        });

    }

    public void openActivity(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }


    public void openActivity2(){
        Intent inten = new Intent(this, Activity3.class);
        startActivity(inten);
    }

    public void openActivity3(){
        Intent intente = new Intent(this, AraClass.class);
        startActivity(intente);
    }

}