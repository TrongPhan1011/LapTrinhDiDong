package com.example.tuan06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FrgList.SendDataShoe {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void sendToDetail(Shoe data) {
        Frg_Detail frgDetail = (Frg_Detail) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView3);
        frgDetail.showDetail(data);
    }
}