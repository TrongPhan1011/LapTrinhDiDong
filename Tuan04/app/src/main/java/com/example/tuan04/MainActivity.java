package com.example.tuan04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView listView;
    private List<Info> lsInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListView();
    }


    public void addListView(){


        listView = (ListView) findViewById(R.id.lvInfo);
        lsInfo = new ArrayList<>();
        lsInfo.add(new Info(1,"Ca nấu lẩu","Devang"));
        lsInfo.add(new Info(2,"Xe đồ chơi","Thế giới đồ chơi"));
        lsInfo.add(new Info(3,"Gà bơ tỏi","LTD Food"));
        lsInfo.add(new Info(4,"Ca nấu lẩu","Devang"));
        lsInfo.add(new Info(5,"Xe đồ chơi","Thế giới đồ chơi"));
        lsInfo.add(new Info(6,"Gà bơ tỏi","LTD Food"));
        lsInfo.add(new Info(7,"Ca nấu lẩu","Devang"));
        lsInfo.add(new Info(8,"Xe đồ chơi","Thế giới đồ chơi"));


        CustomAdapter adapter = new CustomAdapter(this, R.layout.custom_listview, lsInfo);
        listView.setAdapter(adapter);
    }
}