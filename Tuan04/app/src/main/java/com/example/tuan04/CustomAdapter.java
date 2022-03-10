package com.example.tuan04;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Info> listData;
    private int positionSelect = -1;

    public CustomAdapter(Context context, int idLayout, List<Info> listData) {
        this.context = context;
        this.idLayout = idLayout;
        this.listData = listData;
    }

    @Override
    public int getCount() {
        if (listData.size() != 0 && !listData.isEmpty()) {
            return listData.size();
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
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout,viewGroup,false);
        }

        TextView tvName = (TextView) view.findViewById(R.id.tvName);
        TextView tvShop = (TextView) view.findViewById(R.id.tvShop);
        ImageView imageView = (ImageView) view.findViewById(R.id.imgItem);
        final ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.item_layout);
        final Info info = listData.get(position);

        if (listData != null && !listData.isEmpty()) {
            tvName.setText(info.getName());
            tvShop.setText(info.getShop());
            int idIMG = info.getIdIMG();
            switch (idIMG) {
                case 1:
                    imageView.setImageResource(R.drawable.canaulau);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.do_choi_dang_mo_hinh);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.ga_bo_toi);
                    break;
                case 4:
                    imageView.setImageResource(R.drawable.canaulau);
                    break;
                case 5:
                    imageView.setImageResource(R.drawable.do_choi_dang_mo_hinh);
                    break;
                case 6:
                    imageView.setImageResource(R.drawable.canaulau);
                    break;
                case 7:
                    imageView.setImageResource(R.drawable.do_choi_dang_mo_hinh);
                    break;
                case 8:
                    imageView.setImageResource(R.drawable.ga_bo_toi);
                    break;
                default:
                    break;
            }
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, info.getName(), Toast.LENGTH_LONG).show();
                positionSelect = position;
                notifyDataSetChanged();
            }
        });

        if (positionSelect == position) {
            constraintLayout.setBackgroundColor(Color.WHITE);
        } else {
            constraintLayout.setBackgroundColor(Color.LTGRAY);
        }
        return view;
    }
}
