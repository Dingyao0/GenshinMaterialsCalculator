package com.example.genshinmaterialscalculator;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class CharRecyclerViewAdapter extends RecyclerView.Adapter<CharRecyclerViewAdapter.MyViewHolder> implements Filterable {

    private ArrayList<Character> dataSet;
    private ArrayList<Character> FullList;
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

    public CharRecyclerViewAdapter(Context mContext,ArrayList<Character> itemList) {
        this.dataSet = itemList;
        this.mContext = mContext;
        FullList = new ArrayList<>(itemList);
    }

    @NonNull
    @Override
    public CharRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_recycleritem,
                parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CharRecyclerViewAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.imageView.setImageResource(dataSet.get(position).getImage());
        holder.tvName.setText(dataSet.get(position).getName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CharDetails.class);

                // passing data to the book activity
                intent.putExtra("ID", dataSet.get(position).getId());
                intent.putExtra("Name", dataSet.get(position).getName());
                intent.putExtra("Code", dataSet.get(position).getCode());
                intent.putExtra("Rarity", dataSet.get(position).getRarity());
                intent.putExtra("Attack", dataSet.get(position).getAttackValue());
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
        return dataSet.size();
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
            dataSet.clear();
            dataSet.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };

    private class MainAdapter extends FragmentPagerAdapter {

        ArrayList<String> arrayList = new ArrayList<>();
        List<Fragment> fragmentList = new ArrayList<>();

        public void addFragment(Fragment fragment, String title) {

            fragmentList.add(fragment);
        }

        public MainAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return arrayList.get(position);
        }
    }
}
