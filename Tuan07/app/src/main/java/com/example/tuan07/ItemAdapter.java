package com.example.tuan07;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends BaseAdapter {
    private Context context;
    private List<Item> lsItem;
    private int idLayout;
    private SqliteHelper db;

    public ItemAdapter(Context context, List<Item> lsItem, int idLayout, SqliteHelper db) {
        this.context = context;
        this.lsItem = lsItem;
        this.idLayout = idLayout;
        this.db = db;
    }

    @Override
    public int getCount() {
        if(lsItem.size() != 0 && !lsItem.isEmpty() )
            return lsItem.size();
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = (View) LayoutInflater.from(viewGroup.getContext()).inflate(idLayout,viewGroup,false);
        }

        TextView tvName = (TextView) view.findViewById(R.id.tvName);

         Item item = lsItem.get(i);

         EditText txt = view.findViewById(R.id.txt);


        Button btnUpdate = view.findViewById(R.id.btnUpdate);

        Button btnDelete = view.findViewById(R.id.btnDelete);





        if(lsItem != null && !lsItem.isEmpty()){
            tvName.setText(item.getId() +". " + item.getName());
            btnDelete.se

        }



        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickUpdate(item, txt);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickDelete(item);
            }
        });


        return view;
    }

    public void clickUpdate(Item item,EditText txt){


        String name = txt.getText().toString().trim();

        item.setName(name);
        db.updateItem(item);



    }
    public void clickDelete(Item item){
        db.deleteItem(item);

    }


}
