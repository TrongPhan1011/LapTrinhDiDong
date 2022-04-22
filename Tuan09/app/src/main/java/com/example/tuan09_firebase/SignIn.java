package com.example.tuan09_firebase;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {

    private EditText txtEmail,txtPass;
    private Button btnSignIn;
    private FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        auth = FirebaseAuth.getInstance();

        btnSignIn = findViewById(R.id.btnFinish);
        txtEmail = findViewById(R.id.txtSigninEmail);
        txtPass = findViewById(R.id.txtSigninPass);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickSignIn();
            }


        });

    }

    private void clickSignIn() {
        String pass = txtPass.getText().toString().trim();
        String email = txtEmail.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Vui long nhap email",Toast.LENGTH_LONG).show();
        }
        else if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Vui long nhap password",Toast.LENGTH_LONG).show();
        }
        else {
            auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>(){

                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Intent intent = new Intent(getApplicationContext(),Home.class);
                        startActivity(intent);
                    }
                }
            });
        }



    }
}
