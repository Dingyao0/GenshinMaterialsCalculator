package com.example.genshinmaterialscalculator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aws on 28/01/2018.
 */

public class CharRecyclerViewAdapter extends RecyclerView.Adapter<CharRecyclerViewAdapter.MyViewHolder> implements Filterable {

    private Context mContext;
    private List<Character> mData;
    private ArrayList<Character> FullList;



    public CharRecyclerViewAdapter(Context mContext, List<Character> mData) {
        this.mContext = mContext;
        this.mData = mData;
        FullList = new ArrayList<>(mData);

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

                Intent intent = new Intent(mContext, CharDetails.class);

                // passing data to the book activity
                intent.putExtra("ID", mData.get(position).getId());
                intent.putExtra("Name", mData.get(position).getName());
                intent.putExtra("Code", mData.get(position).getCode());
                intent.putExtra("Rarity", mData.get(position).getRarity());
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

            tv_book_title = (TextView) itemView.findViewById(R.id.CardViewText);
            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.cardViewImg);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);

        }
    }

    public void filterList(List<Character> filteredList){
        Log.d("bye", String.valueOf(mData));
        mData=filteredList;
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        return Searched_Filter;
    }

    private Filter Searched_Filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Character> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(FullList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Character item : FullList) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mData.clear();
            mData.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };


}