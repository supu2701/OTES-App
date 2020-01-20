package com.example.oteshackathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup_pageinfo extends AppCompatActivity {

    public Button signup;


    public EditText textInputEmail,textInputUsername,textInputPassword,textInputMobilenumber;


    public FirebaseAuth fAuth;


    public ProgressBar progressBar;


    public TextView t1;


    public void put(){
        t1 = (TextView)findViewById(R.id.textView16);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(signup_pageinfo.this,login_page.class);
                startActivity(toy);
            }
        });
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_pageinfo);




        TextView textView = findViewById(R.id.textView16);
        String text = "Already have an account? Login";
        SpannableString ss = new SpannableString(text);
        ForegroundColorSpan fcsBlack = new ForegroundColorSpan(Color.BLACK);
        ForegroundColorSpan fcsWhite = new ForegroundColorSpan(Color.WHITE);
        ss.setSpan(fcsWhite,0,24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(fcsBlack,25,30,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);






        textInputEmail = (EditText) findViewById(R.id.editText3);
        textInputUsername = (EditText) findViewById(R.id.editText4);
        textInputPassword = (EditText) findViewById(R.id.editText5);
        textInputMobilenumber = (EditText) findViewById(R.id.editText6);
        signup = (Button) findViewById(R.id.button6);
        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar2);


        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }






        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {






                String email = textInputEmail.getText().toString().trim();
                String password = textInputPassword.getText().toString().trim();
                String username = textInputUsername.getText().toString().trim();
                String mobilenumber = textInputMobilenumber.getText().toString().trim();



                if(TextUtils.isEmpty(email)){
                    textInputEmail.setError("Email is Required.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    textInputPassword.setError("Password is Required.");
                    return;
                }
                if(TextUtils.isEmpty(username)){
                    textInputUsername.setError("Username is Required");
                }

                if(password.length()<6){
                    textInputPassword.setError("Password must be >= 6 characters");
                    return;
                }
                if(mobilenumber.length()!= 10){
                    textInputMobilenumber.setError("Incorrect format");
                }

                progressBar.setVisibility(View.VISIBLE);
                //register the user in firebase....

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if(task.isSuccessful()){
                            Toast.makeText(signup_pageinfo.this,"User Created",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        }

                        else{
                            Toast.makeText(signup_pageinfo.this,"Error Occured"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });


            }
        });







        put();



    }
}
