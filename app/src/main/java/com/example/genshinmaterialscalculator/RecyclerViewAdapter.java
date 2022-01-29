package com.example.genshinmaterialscalculator;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> implements Filterable {

    private ArrayList<Weapon> dataSet;
    private ArrayList<Weapon> FullList;
    private Context mContext;


    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvName;
        CardView cardView;


        MyViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
            imageView = itemView.findViewById(R.id.cardViewImg);
            tvName = itemView.findViewById(R.id.CardViewText);
        }
    }

    public RecyclerViewAdapter(Context mContext,ArrayList<Weapon> itemList) {
        this.dataSet = itemList;
        this.mContext = mContext;
        FullList = new ArrayList<>(itemList);
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_recycleritem,
                parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(dataSet.get(position).getImage());
        holder.tvName.setText(dataSet.get(position).getName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, Details2.class);

                // passing data to the book activity
                intent.putExtra("ID", dataSet.get(position).getID());
                intent.putExtra("Name", dataSet.get(position).getName());
                intent.putExtra("Code", dataSet.get(position).getCode());
                intent.putExtra("Rarity", dataSet.get(position).getRarity());
                intent.putExtra("Type", dataSet.get(position).getType());
                intent.putExtra("Attack", dataSet.get(position).getAttackValue());
                intent.putExtra("SubStat", dataSet.get(position).getSubStat());
                intent.putExtra("Substat value", dataSet.get(position).getSubStatValue());
                intent.putExtra("InGame", dataSet.get(position).getIDescription());
                intent.putExtra("Special", dataSet.get(position).getSDescription());
                intent.putExtra("Image", dataSet.get(position).getImage());
                // start the activity
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d("Hi","count");
        return dataSet.size();
    }

    @Override
    public Filter getFilter() {
        return Searched_Filter;
    }

    private Filter Searched_Filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Weapon> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(FullList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Weapon item : FullList) {
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
            dataSet.clear();
            dataSet.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };
}
