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
    private ArrayList<Weapon> lstWeapons = new ArrayList<>();
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

        //DatabaseHandler db = new DatabaseHandler(getActivity());
//        List<Weapons> weaponsList = db.getAllWeapons();

//        for (int i = 0; i < weaponsList.size(); i++) {
//          lstWeapons.add(new com.example.genshinmaterialscalculator.Weapons(
//                  weaponsList.get(i).getName(), weaponsList.get(i).getCode(),
//                  weaponsList.get(i).getType(), weaponsList.get(i).getAttackValue(),
//                  weaponsList.get(i).getSubStat(), weaponsList.get(i).getSubStatValue(),
//                  weaponsList.get(i).getRarity(),
//                  weaponsList.get(i).getSDescription(), weaponsList.get(i).getIDescription(),
//                  weaponsList.get(i).getFirstMatID(), weaponsList.get(i).getSecondMatID(), weaponsList.get(i).getThirdMatID(),
//                  weaponsList.get(i).getImage()));
//        }



//        lstWeapons = new ArrayList<>();
        lstWeapons.add(new Weapon("Cool Steel", "w_1201", "Type : Sword\n",
                "Base Attack : 23\n", "Secondary Stat : 7.7\n", "Secondary Stat Value : 0\n",
                "1-star", "Increases DMG against opponents affected by Hydro or Cryo by 12%.\n",
                "A reliable steel-forged weapon that serves as a testament to the great adventures of its old master.\n",
                1, 1, 1, R.drawable.w_1201));

        lstWeapons.add(new Weapon("Cool Steel", "w_1201", "Type : Sword\n",
                "Base Attack : 23\n", "Secondary Stat : 7.7\n", "Secondary Stat Value : 0\n",
                "1-star", "Increases DMG against opponents affected by Hydro or Cryo by 12%.\n",
                "A reliable steel-forged weapon that serves as a testament to the great adventures of its old master.\n",
                1, 1, 1, R.drawable.w_1201));
        lstWeapons.add(new Weapon("Cool Steel", "w_1201", "Type : Sword\n",
                "Base Attack : 23\n", "Secondary Stat : 7.7\n", "Secondary Stat Value : 0\n",
                "1-star", "Increases DMG against opponents affected by Hydro or Cryo by 12%.\n",
                "A reliable steel-forged weapon that serves as a testament to the great adventures of its old master.\n",
                1, 1, 1, R.drawable.w_1201));
        lstWeapons.add(new Weapon("Cool Steel", "w_1201", "Type : Sword\n",
                "Base Attack : 23\n", "Secondary Stat : 7.7\n", "Secondary Stat Value : 0\n",
                "1-star", "Increases DMG against opponents affected by Hydro or Cryo by 12%.\n",
                "A reliable steel-forged weapon that serves as a testament to the great adventures of its old master.\n",
                1, 1, 1, R.drawable.w_1201));
    }
}