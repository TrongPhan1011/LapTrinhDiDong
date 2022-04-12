package com.example.tuan08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    List<Item> ls;

    ItemDAO itemDAO;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemDAO = ItemDatabase.getInstance(this).itemDAO();




        ls = new ArrayList<Item>();
        showList();

        handleAdd();

        handleCancel();

    }

    public  void showList(){
        ls = itemDAO.getAllItem();
        if(ls != null && ls.size() != 0){
            ListView listView = findViewById(R.id.lvItem);

            ItemAdapter adapter = new ItemAdapter(this, ls, R.layout.item);
            listView.setAdapter(adapter);

            handleAdd();
        }
    }


    public void handleAdd(){
        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txt = findViewById(R.id.txt);
                String text = txt.getText().toString().trim();
                if(text!= null && text.length()!=0){
                    itemDAO.addItem(new Item(text));
                    showList();
                    txt.setText("");
                }

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