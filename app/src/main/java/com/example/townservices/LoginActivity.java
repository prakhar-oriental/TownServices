package com.example.townservices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity {
EditText createEmail,createPassword;
Button createButton;
TextView already;
String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    FirebaseUser currentUser1;
    FirebaseAuth firebaseAuth1;
    //for google sign in
    SignInButton signInButton;
    private static final int RC_SIGN_IN =123;
    private static final String TAG = "open";
    private GoogleSignInClient GoogleSignInClient;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth1 = FirebaseAuth.getInstance();
       createEmail = findViewById(R.id.createemail);
       createPassword = findViewById(R.id.createpassword);
       createButton = findViewById(R.id.createbutton);
       already = findViewById(R.id.createAlready);
       //for google signin
        mAuth = FirebaseAuth.getInstance();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        GoogleSignInClient = GoogleSignIn.getClient(this, gso);
        signInButton = findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
       createButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(TextUtils.isEmpty(createEmail.getText().toString()) && TextUtils.isEmpty(createPassword.getText().toString()))
               {
                   Toast.makeText(LoginActivity.this, "fill all details properly", Toast.LENGTH_SHORT).show();
               }else if(!createEmail.getText().toString().matches(emailPattern))
               {
                   Toast.makeText(LoginActivity.this, "enter valid email", Toast.LENGTH_SHORT).show();
               }else if(createPassword.getText().toString().length()<6)
               {
                   Toast.makeText(LoginActivity.this, "Password length should be greater than 6", Toast.LENGTH_SHORT).show();
               }else
               {
                   firebaseAuth1.createUserWithEmailAndPassword(createEmail.getText().toString(),createPassword.getText().toString())
                         .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                             @Override
                             public void onComplete(@NonNull Task<AuthResult> task) {
                                 if(task.isSuccessful())
                                 {
                                     Toast.makeText(LoginActivity.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                                     startActivity(new Intent(LoginActivity.this,Activity1.class));
                                     finish();
                                 }

                             }
                         }).addOnFailureListener(new OnFailureListener() {
                       @Override
                       public void onFailure(@NonNull Exception e) {
                           Toast.makeText(LoginActivity.this, "Account not created"+e.getMessage(), Toast.LENGTH_SHORT).show();
                       }
                   });
               }
           }
       });
       already.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(LoginActivity.this,loginActivity2.class));
               finish();
           }
       });
    }


    @Override
    protected void onStart() {
        super.onStart();
        currentUser1 = firebaseAuth1.getCurrentUser();
        if(currentUser1!=null)
        {
            startActivity(new Intent(LoginActivity.this,Activity1.class));
            finish();
        }
    }
    //for google sign in
    private void signIn() {
        Intent signInIntent = GoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
            }
        }
    }
    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "SignIn is Done", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this,Activity1.class));
                            finish();


                        } else {
                            Toast.makeText(LoginActivity.this, "Sign is fail", Toast.LENGTH_SHORT).show();


                        }
                    }
                });
    }
}