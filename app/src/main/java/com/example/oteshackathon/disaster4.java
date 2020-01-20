package com.example.oteshackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class disaster4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disaster4);
        Button b1 = (Button)findViewById(R.id.buttonvidland);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BrowserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://youtu.be/0l3ifBTMTvk"));
                startActivity(BrowserIntent);
            }
        });
    }
}
