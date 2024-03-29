package com.example.tuan09_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("user");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickSignIn();
        clickRegister();

    }

    public void clickSignIn(){
        Button btnSignIn = findViewById(R.id.btnFinish);
        Intent intent = new Intent(this,SignIn.class);
        btnSignIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(intent);

            }
        });

    }
    public void clickRegister(){
        Button btnRegister = findViewById(R.id.btnMainRegister);
        Intent intent = new Intent(this,Register.class);
        btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(intent);

            }
        });

    }

    public void getUser(){

    }


}