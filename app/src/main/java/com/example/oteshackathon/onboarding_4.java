package com.example.oteshackathon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class onboarding_4 extends AppCompatActivity {


    public TextView t4;
















    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_4);






        Button b1;
        b1 = findViewById(R.id.btn_get_started);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(onboarding_4.this,MainActivity2.class));
                savePresData();
                finish();
            }
        });










        Button button=findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whatsapp();

            }
        });
    }

    private void savePresData() {
        SharedPreferences pref=getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putBoolean("isIntroOpened",true);
        editor.commit();
    }


    public void whatsapp(){
        Intent intent= getPackageManager().getLaunchIntentForPackage("com.whatsapp");
        startActivity(intent);
    }







}
