package com.example.genshinmaterialscalculator;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> implements Filterable {

    private ArrayList<Weapon> dataSet;
    private ArrayList<Weapon> FullList;


    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvName;

        MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cardViewImg);
            tvName = itemView.findViewById(R.id.CardViewText);

        }
    }

    public RecyclerAdapter(ArrayList<Weapon> itemList) {
        this.dataSet = itemList;
        FullList = new ArrayList<>(itemList);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_recycleritem,
                parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d("position", String.valueOf(position));
        Weapon currentItem = dataSet.get(position);
        holder.imageView.setImageResource(currentItem.getImage());
        holder.tvName.setText(currentItem.getName());
    }

    @Override
    public int getItemCount() {
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
            Log.d("hi", String.valueOf(results));
            for (Weapon cn : filteredList) {
                String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                        cn.getCode() + cn.getType() + cn.getAttackValue() + cn.getSubStat() + cn.getSubStatValue() + cn.getRarity() + cn.getSDescription() + cn.getIDescription() + cn.getAttackValue();
//                 Writing Contacts to log
                Log.d("Name: ", (log));
            }
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
