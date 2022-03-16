package com.example.tuan05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {

    private List<Donut> lsDonut;
    private Button btnPink;
    private Button btnFloating;
    private Button btnDonut;
    private EditText txtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(R.anim.right_to_left, R.anim.left_to_right);
        lsDonut = new ArrayList<Donut>();
        btnPink = (Button) findViewById(R.id.btnPinkDonut);
        btnPink.setOnClickListener(this);
        btnFloating = (Button) findViewById(R.id.btnFloating);
        btnFloating.setOnClickListener(this);
        btnDonut = (Button) findViewById(R.id.btnDonut);
        btnDonut.setOnClickListener(this);

        txtSearch =  findViewById(R.id.txtSearch);
        txtSearch.setOnKeyListener(this);


        int red = R.drawable.donut_red;
        int yellow = R.drawable.donut_yellow;
        int green = R.drawable.green_donut;
        int tasty = R.drawable.tasty_donut;
        lsDonut.add(new Donut(1, "Tasty Donut", "Spicy tasty donut family", tasty, 10.5, "pink"));
        lsDonut.add(new Donut(2, "Yellow Donut", "Spicy tasty donut family 2", yellow, 11.5, "floating"));
        lsDonut.add(new Donut(3, "Green Donut", "Spicy tasty donut family 3", green, 12.5, "floating"));
        lsDonut.add(new Donut(4, "Red Donut", "Spicy tasty donut family 4", red, 14.0, "red"));
        lsDonut.add(new Donut(5, "Tasty Donut", "Spicy tasty donut family 5", tasty, 10.5, "pink"));


        showListDonut();
    }


    public void showListDonut() {

        ListView listView = findViewById(R.id.lvDonut);

        DonutAdapter donutAdapter = new DonutAdapter(this, lsDonut, R.layout.item_donut);
        listView.setAdapter(donutAdapter);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnPinkDonut) {
            showPinkDonut();

        }
        if (view.getId() == R.id.btnFloating) {
            showFloatingDonut();
        }
        if (view.getId() == R.id.btnDonut) {
            showListDonut();
        }
    }


    public void showPinkDonut() {
        List<Donut> lsPinkDonut = new ArrayList<Donut>();
        ListView listView = findViewById(R.id.lvDonut);

        for (Donut donut : lsDonut) {
            if (donut.getLoaiDonut().equalsIgnoreCase("pink")) {
                lsPinkDonut.add(donut);
            }
        }
        DonutAdapter donutAdapter = new DonutAdapter(this, lsPinkDonut, R.layout.item_donut);
        listView.setAdapter(donutAdapter);
    }

    public void showFloatingDonut() {
        List<Donut> lsFloatingDonut = new ArrayList<Donut>();
        ListView listView = findViewById(R.id.lvDonut);

        for (Donut donut : lsDonut) {
            if (donut.getLoaiDonut().equalsIgnoreCase("floating")) {
                lsFloatingDonut.add(donut);
            }
        }
        DonutAdapter donutAdapter = new DonutAdapter(this, lsFloatingDonut, R.layout.item_donut);
        listView.setAdapter(donutAdapter);
    }


    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {

        if(view.getId() == R.id.txtSearch
                && keyEvent.getAction() == KeyEvent.ACTION_DOWN
                && i == KeyEvent.KEYCODE_ENTER
        ){
                showSearchDonut();


        }
        return false;
    }

    public void showSearchDonut(){
        String text = txtSearch.getText().toString();
        List<Donut> lsSearchDonut = new ArrayList<Donut>();
        ListView listView = findViewById(R.id.lvDonut);

        for (Donut donut : lsDonut) {
            if (donut.getName().contains(text)) {
                lsSearchDonut.add(donut);
            }
        }
        DonutAdapter donutAdapter = new DonutAdapter(this, lsSearchDonut, R.layout.item_donut);
        listView.setAdapter(donutAdapter);
    }

}