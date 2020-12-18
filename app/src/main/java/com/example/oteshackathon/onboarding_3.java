package com.example.oteshackathon;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class onboarding_3 extends AppCompatActivity {


    float x1,x2,y1,y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_3);
        Button b1 = findViewById(R.id.button5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(onboarding_3.this,onboarding_4.class);
                startActivity(intent);
                finish();
            }
        });
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
                    Intent i= new Intent(onboarding_3.this,onboarding_2.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);

                }else if(x1 > x2){//left swipe


                    Intent i= new Intent(onboarding_3.this,onboarding_4.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                }
                break;
        }
        return false;
    }
}

