package com.example.tuan05;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class DetailDonut extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_donut);
        overridePendingTransition(R.anim.right_to_left,R.anim.left_to_right);
        showDetailDonut();
    }


    public void showDetailDonut(){
        Intent intent = getIntent();
        String donutJson = intent.getStringExtra("donut");

        Gson gson = new Gson();
        Donut donut = gson.fromJson(donutJson,Donut.class);

        TextView tvName = (TextView) findViewById(R.id.tvDetailName);
        TextView tvGia = (TextView) findViewById(R.id.tvDetailGia);
        TextView tvMoTa = (TextView) findViewById(R.id.tvDetailMoTa);
        ImageView imgDonut = (ImageView) findViewById(R.id.imgDetailDonut);


        tvName.setText(donut.getName());
        tvGia.setText("$"+donut.getGia());
        tvMoTa.setText(donut.getMoTa());
        imgDonut.setImageResource(donut.getImg());




    }



}
