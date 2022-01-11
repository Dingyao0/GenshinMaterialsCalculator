package com.example.genshinmaterialscalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ArrayList<com.example.genshinmaterialscalculator.Weapons> lstWeapons = new ArrayList<>();
    private RecyclerView mRecyclerView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        bindBooks();
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_id);
        com.example.genshinmaterialscalculator.RecyclerViewAdapter myAdapter = new com.example.genshinmaterialscalculator.RecyclerViewAdapter(this.getActivity(), lstWeapons);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(), 3));
        mRecyclerView.setAdapter(myAdapter);        // Inflate the layout for this fragment
        return rootView;
    }


    private void bindBooks() {
//        lstWeapons = new ArrayList<>();
        lstWeapons.add(new com.example.genshinmaterialscalculator.Weapons("Cool Steel", "w_1201", "Type : Sword\n" +
                "Rarity : 1-star \n" +
                "Base Attack : 23\n" +
                "Secondary Stat : 7.7\n" +
                "Secondary Stat Value : 0\n", R.drawable.w_1201));
        lstWeapons.add(new com.example.genshinmaterialscalculator.Weapons("Cool Steel2", "w_1201", "Description book2", R.drawable.w_1201));
        lstWeapons.add(new com.example.genshinmaterialscalculator.Weapons("Maria Semples", "w_1201", "Description book3", R.drawable.w_1201));
        lstWeapons.add(new com.example.genshinmaterialscalculator.Weapons("The Martian", "w_1201", "Description book4", R.drawable.w_1201));
        lstWeapons.add(new com.example.genshinmaterialscalculator.Weapons("He Died with...", "w_1201", "Description book5", R.drawable.w_1201));
    }
}