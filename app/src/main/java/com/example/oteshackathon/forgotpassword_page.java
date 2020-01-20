package com.example.oteshackathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotpassword_page extends AppCompatActivity {


    public EditText useremail;
    public Button resetpass;
    FirebaseAuth fAuth;
    ProgressBar progressBar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword_page);

        progressBar = findViewById(R.id.progressBar);
        useremail = findViewById(R.id.editText7);
        resetpass = findViewById(R.id.button4);
        fAuth = FirebaseAuth.getInstance();



        resetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                fAuth.sendPasswordResetEmail(useremail.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressBar.setVisibility(View.GONE);
                        if(task.isSuccessful()){
                            Toast.makeText(forgotpassword_page.this,"Password send to your email",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),login_page.class));


                        }
                        else{
                            Toast.makeText(forgotpassword_page.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();

                        }

                    }
                });
            }
        });

    }
}
