package com.example.tuan06;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.telephony.gsm.GsmCellLocation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

public class ShoeAdapter extends BaseAdapter {
    private int idLayout;
    private List<Shoe> lsShoe;
    private Context context;

    private FrgList.SendDataShoe sendData;



    public ShoeAdapter(int idLayout, List<Shoe> lsShoe, Context context, FrgList.SendDataShoe sendData) {
        this.idLayout = idLayout;
        this.lsShoe = lsShoe;
        this.context = context;
        this.sendData = sendData;

    }



    @Override
    public int getCount() {
        if(lsShoe.size() != 0 && !lsShoe.isEmpty()){
            return  lsShoe.size();
        }
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

        TextView tvName = view.findViewById(R.id.name_item);
        TextView tvDes = view.findViewById(R.id.description_item);
        ImageView img = view.findViewById(R.id.img_item);

        Shoe s = lsShoe.get(i);

        if(lsShoe != null && !lsShoe.isEmpty()){
            tvName.setText(s.getName());
            tvDes.setText(s.getDescription());

            img.setImageResource(s.getImg());
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickShoe(s);
            }
        });

        return view;
    }


    public void clickShoe(Shoe shoe){

        sendData.sendToDetail(shoe);


    }
}
