package com.example.oteshackathon;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_page extends AppCompatActivity {
    String email;
    String password;

    public EditText mEmail, mPassword;
    public Button mLoginButton;
    public ProgressBar progressBar;
    public FirebaseAuth fAuth;



    public TextView t1;
    public TextView t2;











    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        t1 = findViewById(R.id.textView7);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login_page.this,signup_pageinfo.class));
            }
        });

        t2 = findViewById(R.id.textView6);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login_page.this,forgotpassword_page.class));
            }
        });

        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar3);
        fAuth = FirebaseAuth.getInstance();
        mLoginButton = findViewById(R.id.button3);


        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 email = mEmail.getText().toString().trim();
                 password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required.");
                    return;
                }

                if(password.length()<6){
                    mPassword.setError("Password must be >= 6 characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //authenticate the user

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if(task.isSuccessful()){
                            Toast.makeText(login_page.this,"Logged In Successfully.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),onboarding_1.class));
                        }
                        else{
                            Toast.makeText(login_page.this,"Some errors occured."+task.getException().getMessage(),Toast.LENGTH_SHORT).show();;
                        }
                    }
                });
            }
        });

















        TextView textView = findViewById(R.id.textView7);

        String text = "Do not have an account? SignUp";

        SpannableString ss = new SpannableString(text);


        ForegroundColorSpan fcsBlack = new ForegroundColorSpan(Color.BLACK);
        ForegroundColorSpan fcsWhite = new ForegroundColorSpan(Color.WHITE);

        ss.setSpan(fcsWhite,0,23,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(fcsBlack,24,30,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);



    }

}
