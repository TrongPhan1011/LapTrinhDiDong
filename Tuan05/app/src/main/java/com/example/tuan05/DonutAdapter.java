package com.example.tuan05;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.gson.Gson;

import java.util.List;

public class DonutAdapter extends BaseAdapter {
    private Context context;
    private int positionSelect = -1;
    private List<Donut> lsDonut;
    private int idLayout;



    public DonutAdapter(Context context, List<Donut> lsDonut, int idLayout) {
        this.context = context;
        this.lsDonut = lsDonut;
        this.idLayout = idLayout;
    }

    @Override
    public int getCount() {

        if(lsDonut.size() != 0 && !lsDonut.isEmpty() )
            return lsDonut.size();
        return 1;
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
    public View getView(int position, View view, ViewGroup viewGroup) {

        if(view == null){
            view = (View) LayoutInflater.from(viewGroup.getContext()).inflate(idLayout,viewGroup,false);
        }

        TextView tvName = (TextView) view.findViewById(R.id.tvName);
        TextView tvMoTa = (TextView) view.findViewById(R.id.tvMota);
        TextView tvGia = (TextView) view.findViewById(R.id.tvGia);
        ImageView img = (ImageView) view.findViewById(R.id.imgDonut);
        Donut donut = lsDonut.get(position);





        if(lsDonut != null && !lsDonut.isEmpty()){
            tvName.setText(donut.getName());
            tvMoTa.setText(donut.getMoTa());
            tvGia.setText("$"+donut.getGia());
            img.setImageResource(donut.getImg());
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickDonut(donut);

            }
        });


        return view;
    }


    public void clickDonut(Donut donut){
        Intent intent = new Intent(context, DetailDonut.class);
        Gson gson = new Gson();
        String donutJson = gson.toJson(donut);
        intent.putExtra("donut",donutJson);




//        context.sendBroadcast(intent);

        context.startActivity(intent);
    }
}
