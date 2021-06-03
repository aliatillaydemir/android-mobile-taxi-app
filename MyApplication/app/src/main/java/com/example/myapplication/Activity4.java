package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Activity4 extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap mapApi;
    SupportMapFragment mapFragment;


    AraClass cl = new AraClass();
    double enbuyuk=0;
    static double d1x,d2y,d1y,d2x;
    static int sayac=0;
    int lati;
    int langi;

    FirebaseDatabase fireDatabase = FirebaseDatabase.getInstance("https://yazlab-fda20-default-rtdb.firebaseio.com/");
    DatabaseReference databaseRefRead;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);


        databaseRefRead = fireDatabase.getReference();

        ArrayList<String> trip_dist = new ArrayList<>();
        ArrayList<String> pul = new ArrayList<>();
        ArrayList<String> dol = new ArrayList<>();
        ArrayList<String> lat = new ArrayList<>();
        ArrayList<String> lang = new ArrayList<>();
        List<Double> ds = new ArrayList<Double>();

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    trip_dist.add(dataSnapshot.child("trip_distance").getValue().toString());
                    pul.add(dataSnapshot.child("PULocationID").getValue().toString());
                    dol.add(dataSnapshot.child("DOLocationID").getValue().toString());
                    lat.add(dataSnapshot.child("latitude").getValue().toString());
                    lang.add(dataSnapshot.child("longitude").getValue().toString());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

/*
        double[] dizi = new double[trip_dist.size()];
        int syc=0;

        for (String d : trip_dist) {
            // Apply formatting to the string if necessary
            ds.add(Double.parseDouble(d));
            dizi[syc]=ds.get(syc);
            syc++;
        }

        for(int i=cl.kontrol*100;i<(cl.kontrol*100)+100;i++)       // en buyuk mesafe hangi indexte bulunur.
        {
            if(dizi[i]>enbuyuk) {
                //enbuyuk= Double.parseDouble(trip_dist.get(i));
                sayac = i;
            }
        }

        lati=(Integer.parseInt(pul.get(sayac)))-2;
        langi=(Integer.parseInt(dol.get(sayac)))-2;

        d1x=Double.parseDouble(lat.get(lati));
        d1y=Double.parseDouble(lang.get(lati));

        d2x=Double.parseDouble(lat.get(langi));
        d2y=Double.parseDouble(lang.get(langi));

*/
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {


        mapApi = googleMap;


        LatLng sehir1 = new LatLng(0 + 40.6781247, 0 + -73.79166546);
        LatLng sehir2 = new LatLng(0 + 40.60750422, 0 + -74.15944329);


  //      LatLng sehir1 = new LatLng(0 + d1x, 0 + d1y);
//        LatLng sehir2 = new LatLng(0 + d2x, 0 + d2y);


        mapApi.addMarker(new MarkerOptions().position(sehir1).title("ilk sehir"));
        mapApi.addMarker(new MarkerOptions().position(sehir2).title("ikinci sehir"));
        mapApi.moveCamera(CameraUpdateFactory.newLatLng(sehir1));
        Polyline polyline1 = googleMap.addPolyline(new PolylineOptions()
                .clickable(true)
                .add(
                        sehir1,
                        sehir2
                        // new LatLng(-34.747, 145.592),
                        // new LatLng(-34.364, 147.891),
                        // new LatLng(-33.501, 150.217),
                        // new LatLng(-32.306, 149.248),
                        // new LatLng(-32.491, 147.309)));
                ));
        // Position the map's camera near Alice Springs in the center of Australia,
        // and set the zoom factor so most of Australia shows on the screen.
        //  googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-23.684, 133.903), 4));

        // Set listeners for click events.
        // googleMap.setOnPolylineClickListener(this);
        // googleMap.setOnPolygonClickListener(this);



    }
}
