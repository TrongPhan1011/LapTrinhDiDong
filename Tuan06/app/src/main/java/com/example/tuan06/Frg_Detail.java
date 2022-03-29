package com.example.tuan06;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;


public class Frg_Detail extends Fragment {

    private TextView tvName;
    private TextView tvDes;
    private ImageView img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frg__detail, container, false);
        tvName = view.findViewById(R.id.detail_name);
         tvDes = view.findViewById(R.id.detail_description);
         img = view.findViewById(R.id.detail_img);

        return view;
        // Inflate the layout for this fragment

    }

    public void showDetail(Shoe shoe){
        if(shoe != null) {
            tvName.setText(shoe.getName());
            tvDes.setText(shoe.getDescription());
            img.setImageResource(shoe.getImg());
        }




    }
}