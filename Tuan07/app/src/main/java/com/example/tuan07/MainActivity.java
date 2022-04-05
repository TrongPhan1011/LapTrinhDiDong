package com.example.tuan07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SqliteHelper db;
    List<Item> ls;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new SqliteHelper(this);




        ls = new ArrayList<Item>();
        ls = db.getAllItem();

        ListView listView = findViewById(R.id.lvItem);

        ItemAdapter adapter = new ItemAdapter(this, ls, R.layout.item,db);
        listView.setAdapter(adapter);

        handleAdd();

        handleCancel();


    }

    public  void showList(){
        ls = db.getAllItem();

        ListView listView = findViewById(R.id.lvItem);

        ItemAdapter adapter = new ItemAdapter(this, ls, R.layout.item,db);
        listView.setAdapter(adapter);

        handleAdd();
    }


    public void handleAdd(){
        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txt = findViewById(R.id.txt);
                String text = txt.getText().toString().trim();
                if(text!= null && text.length()!=0){
                        db.addItem(new Item(text));
                }
                showList();
                txt.setText("");
            }
        });

    }

    public void handleCancel(){
        Button btnAdd = findViewById(R.id.btnCancel);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txt = findViewById(R.id.txt);
                txt.setText("");
                showList();
            }
        });

    }






}