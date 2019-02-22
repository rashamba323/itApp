package com.example.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.Model.Pcost;
import com.example.itapp.ListActivity;
import com.example.itapp.R;
import com.example.itapp.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class ListAdapteter extends RecyclerView.Adapter<ListAdapteter.ListViewHolder> {

    Utils utils = new Utils();
    private List<Pcost> listPcosts = new ArrayList<>();

    public void setList(List<Pcost> list){
        this.listPcosts = list;
        notifyDataSetChanged();
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,
                parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

        holder.bind(listPcosts.get(position));
    }

    @Override
    public int getItemCount() {
        return listPcosts.size();
    }


    public void update(){
        notifyDataSetChanged();
    }


    class ListViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewPrice;
        LinearLayout itemId;

        Random random = new Random();
        private Context context;

        private  int[] colors = {
                0xffffa000,
                0xff0288d1,
                0xffd32f2f,
                0xffc2185b,
                0xff7b1fa2,
                0xffe65100
        };

        private ListViewHolder(View itemView) {
            super(itemView);

//            context = itemView.getContext();
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewPrice = itemView.findViewById(R.id.text_view_price);
            itemId = itemView.findViewById(R.id.item_id);

        }

        void bind(Pcost pcost){

       /*     Drawable background = textViewName.getBackground();
            Drawable wrap = DrawableCompat.wrap(background);
            DrawableCompat.setTint(wrap, colors[random.nextInt(colors.length)]);*/

            textViewName.setText(pcost.getName());
            textViewPrice.setText(String.valueOf(pcost.getPrice()));
            setTypeColor();

            if(pcost.getType() == "P")
                textViewName.setTextColor(itemView.getResources().getColor(R.color.color_indirect));
            else
                textViewName.setTextColor(itemView.getResources().getColor(R.color.color_direct));
        }
        void setTypeColor(){
            itemId.setBackgroundColor(888888);
        }
    }

    private void setItems(Collection<Pcost> pcosts){
        listPcosts.addAll(pcosts);
        Log.e("SET_ITEMS"," SET!");
        notifyDataSetChanged();
    }
}
