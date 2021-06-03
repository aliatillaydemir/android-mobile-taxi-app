package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;


public class Activity2 extends AppCompatActivity {

    Button btn_show;
    TextView txt_show;
    TextView txt2_show;
    TextView txt3_show;
    TextView txt4_show;
    TextView txt5_show;

    FirebaseDatabase firebaseDatabse = FirebaseDatabase.getInstance("https://yazlab-fda20-default-rtdb.firebaseio.com/");
    DatabaseReference databaseReferenceRead;


    private void init(){
        btn_show = findViewById(R.id.btn_show);

        txt_show = findViewById(R.id.txt_show);
        txt2_show = findViewById(R.id.txt2_show);
        txt3_show = findViewById(R.id.txt3_show);
        txt4_show = findViewById(R.id.txt4_show);
        txt5_show = findViewById(R.id.txt5_show);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        init();

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });
    }




    private void show() {

        ArrayList<String> mesafe = new ArrayList<>();
        ArrayList<String> gun = new ArrayList<>();
        ArrayList<String> gunson = new ArrayList<>();

        databaseReferenceRead = firebaseDatabse.getReference();


        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    mesafe.add(dataSnapshot.child("trip_distance").getValue().toString());
                    gun.add(dataSnapshot.child("tpep_pickup_datetime").getValue().toString());
                    gunson.add(dataSnapshot.child("tpep_dropoff_datetime").getValue().toString());
                }




                int sayac1=0,sayac2=0,sayac3=0,sayac4=0,sayac5=0;
                String dizimesafe[] = new String[mesafe.size()];




                for(int i=0;i<mesafe.size();i++){
                    dizimesafe[i]=mesafe.get(i);
                }




                 Collections.sort(mesafe, Collections.reverseOrder());

                 for (int i=0;i<mesafe.size();i++)
                 {
                     if(mesafe.get(0).equals(dizimesafe[i]))
                        sayac1=i;
                     if(mesafe.get(1).equals(dizimesafe[i]))
                         sayac2=i;
                     if(mesafe.get(2).equals(dizimesafe[i]))
                         sayac3=i;
                     if(mesafe.get(3).equals(dizimesafe[i]))
                         sayac4=i;
                     if(mesafe.get(4).equals(dizimesafe[i]))
                         sayac5=i;

                 }

                String s1=String.valueOf(sayac1);
                String s2=String.valueOf(sayac2);
                String s3=String.valueOf(sayac3);
                String s4=String.valueOf(sayac4);
                String s5=String.valueOf(sayac5);

                /*
                // txt2_show.setText(s1+" "+s2+" "+s3+" "+s4+" "+s5);
                 txt2_show.setText(mesafe.get(0)+" "+mesafe.get(1)+" "+mesafe.get(2)+" "+mesafe.get(3)+" "+mesafe.get(4));

                 txt_show.setText(gun.get(sayac1)+" -- "+gunson.get(sayac1)
                         +gun.get(sayac2)+" -- "+gunson.get(sayac2)+"*** "+gun.get(sayac3)+" -- "+gunson.get(sayac3)+"*** "+gun.get(sayac4)+" -- "+gunson.get(sayac4)+"*** "+gun.get(sayac5)+" -- "+gunson.get(sayac5));

                 */
                txt_show.setText(mesafe.get(0)+"mil"+"-->"+gun.get(sayac1)+ " ---- "+gunson.get(sayac1));
                txt2_show.setText(mesafe.get(1)+"mil"+"-->"+gun.get(sayac2)+" ---- "+gunson.get(sayac2));
                txt3_show.setText(mesafe.get(2)+"mil"+"-->"+gun.get(sayac3)+" ---- "+gunson.get(sayac3));
                txt4_show.setText(mesafe.get(3)+"mil"+"-->"+gun.get(sayac4)+" ---- "+gunson.get(sayac4));
                txt5_show.setText(mesafe.get(4)+"mil"+"-->"+gun.get(sayac5)+" ---- "+gunson.get(sayac5));



            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        databaseReferenceRead.addValueEventListener(valueEventListener);
    }



}