package com.example.genshinmaterialscalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

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
        bindWeapons();
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_id);
        com.example.genshinmaterialscalculator.RecyclerViewAdapter myAdapter = new com.example.genshinmaterialscalculator.RecyclerViewAdapter(this.getActivity(), lstWeapons);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(), 3));
        mRecyclerView.setAdapter(myAdapter);        // Inflate the layout for this fragment
        return rootView;
    }


    private void bindWeapons() {

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
        lstWeapons.add(new com.example.genshinmaterialscalculator.Weapons("Cool Steel", "w_1201", "Type : Sword\n" +
                "Rarity : 3-star \n" +
                "Base Attack : 39\n" +
                "Secondary Stat : ATK\n" +
                "Secondary Stat Value : 0\n", "3-star", "Increases DMG against opponents affected by Hydro or Cryo by 12%.", "A reliable steel-forged weapon that serves as a testament to the great adventures of its old master.", 1, 1, 1, R.drawable.w_1201));
        lstWeapons.add(new com.example.genshinmaterialscalculator.Weapons("Blackcliff Longsword", "w_1301", "Type : Sword\n" +
                "Rarity : 4-star \n" +
                "Base Attack : 44\n" +
                "Secondary Stat : CRIT DMG\n" +
                "Secondary Stat Value : 8\n", "4-star", "After defeating an opponent, ATK is increased by 12% for 30s. This effect has a maximum of 3 stacks, and the duration of each stack is independent of the others.", "A sword made of a material known as \"blackcliff.\" It has a dark crimson glow on its black blade.", 1, 1, 1, R.drawable.w_1201));
        lstWeapons.add(new com.example.genshinmaterialscalculator.Weapons("Aquila Favonia", "w_1401", "Type : Sword\n" +
                "Rarity : 5-star \n" +
                "Base Attack : 48\n" +
                "Secondary Stat : Physical DMG Bonus\n" +
                "Secondary Stat Value : 9\n", "5-star", "ATK is increased by 20%. Triggers on taking DMG: the soul of the Falcon of the West awakens, holding the banner of resistance aloft, regenerating HP equal to 100% of ATK and dealing 200% of ATK as DMG to surrounding opponents. This effect can only occur once every 15s.", "The soul of the Knights of Favonius. Millennia later, it still calls on the winds of swift justice to vanquish all evil — just like the last heroine who wielded it.", 1, 1, 1, R.drawable.w_1201));
        lstWeapons.add(new com.example.genshinmaterialscalculator.Weapons("Fillet Blade", "w_1203", "Type : Sword\n" +
                "Rarity : 3-star \n" +
                "Base Attack : 39\n" +
                "Secondary Stat : ATK\n" +
                "Secondary Stat Value : 7.7\n", "3-star", "On hit, has a 50% chance to deal 240% ATK DMG to a single opponent. Can only occur once every 15s.", "A sharp filleting knife. The blade is long, thin, and incredibly sharp.", 1, 1, 1, R.drawable.w_1201));
    }
}