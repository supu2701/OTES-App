package com.example.oteshackathon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private static final int PERMISSIONS_REQUEST = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button b1,b2,b3,b4,b5;
        b1=findViewById(R.id.firstaid);
        b2=findViewById(R.id.precautionary);
        b3=findViewById(R.id.nearby);
        b4=findViewById(R.id.alert);
        b5=findViewById(R.id.emergency);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,NearbyServices.class);
                startActivity(intent);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,EmergencyCalls.class);
                startActivity(intent);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,socialPlatform.class);
                startActivity(intent);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,FirstAid.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,disaster3.class);
                startActivity(intent);
            }
        });
    }
}
