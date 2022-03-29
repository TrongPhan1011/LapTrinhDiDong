package com.example.tuan06;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class FrgList extends Fragment {

    private List<Shoe> lsShoe;

    private SendDataShoe sendData;

    public interface SendDataShoe{
        public void sendToDetail(Shoe data);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        sendData = (SendDataShoe) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frg_list, container, false);


        showShoe(view);
        // Inflate the layout for this fragment
        return view;
    }


    public void showShoe(View view){
        lsShoe = new ArrayList<Shoe>();
        int img1 = R.drawable.shoes_rm_preview;
        int img = R.drawable.shoes_rm_preview_b;
        lsShoe.add(new Shoe(1,"Shoe 1",img,"description demo 1"));
        lsShoe.add(new Shoe(2,"Shoe 2",img1,"description demo 2"));
        lsShoe.add(new Shoe(3,"Shoe 3",img,"description demo 3"));


        ListView lv = view.findViewById(R.id.lv_Shoe);
        ShoeAdapter shoeAdapter = new ShoeAdapter(R.layout.item_shoe,lsShoe,getActivity(),sendData);
        lv.setAdapter(shoeAdapter);

    }






}