package com.example.tuan4_bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     private GridView gridView;
     private List<Item> lsItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.grid_view);
        lsItem = new ArrayList<Item>();

        int img1 = R.drawable.giacchuyen;
        int img2 = R.drawable.daynguon1;

        lsItem.add(new Item(1,"Dây chuyển đổi điện thoại","10,000đ",img1,20));
        lsItem.add(new Item(2,"Dây nguồn","15,000đ",img2,21));
        lsItem.add(new Item(3,"Dây chuyển đổi điện thoại","11,000đ",img1,10));
        lsItem.add(new Item(4,"Dây chuyển đổi điện thoại","10,000đ",img1,2));
        lsItem.add(new Item(5,"Dây nguồn","10,000đ",img2,20));
        lsItem.add(new Item(6,"Dây chuyển đổi điện thoại","10,000đ",img1,20));
        lsItem.add(new Item(7,"Dây chuyển đổi điện thoại","10,000đ",img1,20));
        lsItem.add(new Item(8,"Dây chuyển đổi điện thoại","10,000đ",img1,20));
        lsItem.add(new Item(9,"Dây chuyển đổi điện thoại","10,000đ",img1,20));
        lsItem.add(new Item(10,"Dây chuyển đổi điện thoại","10,000đ",img1,20));

        ItemAdapter itemAdapter = new ItemAdapter(this,lsItem,R.layout.item_gridview);
        gridView.setAdapter(itemAdapter);




    }
}