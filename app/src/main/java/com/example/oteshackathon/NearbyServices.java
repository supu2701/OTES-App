package com.example.oteshackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NearbyServices extends AppCompatActivity {

    Button policeStationButton,hospitalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_services);

        policeStationButton = findViewById(R.id.ns_police_station_button);
        hospitalButton = findViewById(R.id.ns_hospital_button);

        policeStationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NearbyServices.this,MapActivityPolice.class);
                startActivity(intent);
            }
        });

        hospitalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NearbyServices.this,MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}