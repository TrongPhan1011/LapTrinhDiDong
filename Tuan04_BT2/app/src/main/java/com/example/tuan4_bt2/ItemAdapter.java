package com.example.tuan4_bt2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class ItemAdapter extends BaseAdapter {

    private Context context;
    private List<Item> lsItem;
    private int idLayout;
    private int positionSelect = -1;

    public ItemAdapter(Context context, List<Item> lsItem, int idLayout) {
        this.context = context;
        this.lsItem = lsItem;
        this.idLayout = idLayout;
    }

    @Override
    public int getCount() {

        if(lsItem.size() != 0 || !lsItem.isEmpty())
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
    public View getView(int position, View view, ViewGroup viewp) {
        if(view == null){
            view  =  LayoutInflater.from(viewp.getContext()).inflate(idLayout, viewp,false);
        }

        TextView tvName = (TextView) view.findViewById(R.id.tvName);
        TextView tvGia = (TextView) view.findViewById(R.id.tvGia);
        TextView tvDanhGia = (TextView) view.findViewById(R.id.tvDanhGia);
        ImageView img = (ImageView) view.findViewById(R.id.imgItem);

        final ConstraintLayout constraintLayout = view.findViewById(R.id.item_layout);
        final Item item = lsItem.get(position);



        if (lsItem != null && !lsItem.isEmpty()) {
        tvName.setText(item.getName());
        tvGia.setText(item.getGiaSP());
        tvDanhGia.setText(item.getDanhGia()+"");
        img.setImageResource(item.getImgLink());
//            int idItem =  item.getId();
//            switch (idItem) {
//                case 1:
//                    img.setImageResource(R.drawable.daynguon1);
//                    break;
//                case 2:
//                    img.setImageResource(R.drawable.daynguon1);
//                    break;
//                case 3:
//                    img.setImageResource(R.drawable.daynguon1);
//                    break;
//                case 4:
//                    img.setImageResource(R.drawable.daynguon1);
//                    break;
//                default:
//                    break;
//
//            }
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,item.getName(),Toast.LENGTH_LONG).show();
                positionSelect = position;
                notifyDataSetChanged();
            }
        });

        if (positionSelect == position){
            constraintLayout.setBackgroundColor(Color.WHITE);

        }
        else
            constraintLayout.setBackgroundColor(Color.LTGRAY);





        return view;
    }
}
