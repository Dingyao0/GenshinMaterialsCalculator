package com.example.genshinmaterialscalculator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by Aws on 28/01/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Weapons> mData;


    public RecyclerViewAdapter(Context mContext, List<Weapons> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.list_recycleritem, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tv_book_title.setText(mData.get(position).getName());
        holder.img_book_thumbnail.setImageResource(mData.get(position).getImage());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, Details.class);

                // passing data to the book activity
                intent.putExtra("Name", mData.get(position).getName());
                intent.putExtra("Code", mData.get(position).getCode());
                intent.putExtra("Rarity", mData.get(position).getRarity());
                intent.putExtra("Type",mData.get(position).getType());
                intent.putExtra("Attack",mData.get(position).getAttackValue());
                intent.putExtra("SubStat",mData.get(position).getSubStat());
                intent.putExtra("Substat value",mData.get(position).getSubStatValue());
                intent.putExtra("InGame", mData.get(position).getIDescription());
                intent.putExtra("Special", mData.get(position).getSDescription());
                intent.putExtra("Image", mData.get(position).getImage());
                // start the activity
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_book_title;
        ImageView img_book_thumbnail;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_book_title = (TextView) itemView.findViewById(R.id.book_title_id);
            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.book_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);

        }
    }

}