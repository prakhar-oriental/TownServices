package com.example.townservices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginActivity2 extends AppCompatActivity {
    EditText loginEmail,loginPassword;
    Button loginButton;
    String loginemailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    FirebaseUser logincurrentUser1;
    FirebaseAuth loginfirebaseAuth1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        loginfirebaseAuth1 = FirebaseAuth.getInstance();
        loginEmail = findViewById(R.id.loginemail);
        loginPassword = findViewById(R.id.loginpassword);
        loginButton = findViewById(R.id.loginbutton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(loginEmail.getText().toString()) && TextUtils.isEmpty(loginPassword.getText().toString()))
                {
                    Toast.makeText(loginActivity2.this, "fill all details properly", Toast.LENGTH_SHORT).show();
                }else if(!loginEmail.getText().toString().matches(loginemailPattern))
                {
                    Toast.makeText(loginActivity2.this, "enter valid email", Toast.LENGTH_SHORT).show();
                }else if(loginPassword.getText().toString().length()<6)
                {
                    Toast.makeText(loginActivity2.this, "Password length should be greater than 6", Toast.LENGTH_SHORT).show();
                }else{
                      loginfirebaseAuth1.signInWithEmailAndPassword(loginEmail.getText().toString(),loginPassword.getText().toString())
                              .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                  @Override
                                  public void onComplete(@NonNull Task<AuthResult> task) {
                                      if(task.isSuccessful())
                                      {
                                          startActivity(new Intent(loginActivity2.this,Activity1.class));
                                          finish();
                                      }
                                  }
                              }).addOnFailureListener(new OnFailureListener() {
                          @Override
                          public void onFailure(@NonNull Exception e) {
                              Toast.makeText(loginActivity2.this, "error"+e.getMessage(), Toast.LENGTH_SHORT).show();
                          }
                      });
                }
            }
        });
    }


}