package com.example.oteshackathon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

public class onboarding_4 extends AppCompatActivity {
    float x1,x2,y1,y2;


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
    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(x1 <x2){//right swipe
                    break;

                }else if(x1 > x2){//left swipe


                    break;
                }
                break;
        }
        return false;
    }






}
