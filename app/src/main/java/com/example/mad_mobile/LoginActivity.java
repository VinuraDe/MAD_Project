package com.example.mad_mobile;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editemail, editpassword;
    private Button login;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedIntanceState){
        super.onCreate(savedIntanceState);
        setContentView(R.layout.activity_login);

        textView = findViewById(R.id.textView2);
        login =  findViewById(R.id.loginButton);
        editemail =  findViewById(R.id.userEmail);
        editpassword = findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        login.setOnClickListener((v)-> login());


    }

    private void login(){
        String useremail = editemail.getText().toString().trim();
        String password = editpassword.getText().toString().trim();

        if(useremail.isEmpty()){
            editemail.setError("Email is required");
            editemail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(useremail).matches()){
            editemail.setError("Enter a valid Email....!");
            editemail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editpassword.setError("Password is required");
            editpassword.requestFocus();
            return;
        }
        if (password.length() < 6){
            editpassword.setError("Minimum characters is 6");
            editpassword.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(useremail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));

                }else{
                    Toast.makeText(LoginActivity.this,"Failed to login!", Toast.LENGTH_LONG).show();
                }

            }
        });


    }


}