package com.example.genshinmaterialscalculator;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeaponFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class WeaponFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter adapter;
    private SearchView searchView;
    List<Weapon> filteredList = new ArrayList<>();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public WeaponFragment() {
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
    public static WeaponFragment newInstance(String param1, String param2) {
        WeaponFragment fragment = new WeaponFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_weapon, container, false);
        searchView = rootView.findViewById(R.id.search_view);
        bindWeapons();
        DatabaseHandler lstWeapons = new DatabaseHandler(this.getActivity());
        ArrayList<Weapon> weaponsList = (ArrayList<Weapon>) lstWeapons.getAllWeapons();
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_id);
        adapter = new RecyclerViewAdapter(this.getActivity(), weaponsList);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(), 2));
        mRecyclerView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });

        return rootView;
    }

    private void bindWeapons() {
        DatabaseHandler db = new DatabaseHandler(this.getActivity());
        List<Weapon> weaponsList = db.getAllWeapons();
        Log.d("Insert Data : ", "Inserting ..");
//        lstWeapons.addWeapon(new com.example.genshinmaterialscalculator.Weapon("Cool Steel", "w_1201", "Type : Sword",
//                "39\n",
//                R.drawable.atk,
//                "0\n", "3-star", "Increases DMG against opponents affected by Hydro or Cryo by 12%.", "A reliable steel-forged weapon that serves as a testament to the great adventures of its old master.", 1, 1, 1, R.drawable.w_1201));
//        lstWeapons.addWeapon(new com.example.genshinmaterialscalculator.Weapon("Blackcliff Longsword", "w_1301", "Type : Sword\n",
//                "44\n",
//                R.drawable.cd,
//                "8\n", "4-star", "After defeating an opponent, ATK is increased by 12% for 30s. This effect has a maximum of 3 stacks, and the duration of each stack is independent of the others.", "A sword made of a material known as \"blackcliff.\" It has a dark crimson glow on its black blade.", 1, 1, 1, R.drawable.w_1301));
//        lstWeapons.addWeapon(new com.example.genshinmaterialscalculator.Weapon("Aquila Favonia", "w_1401", "Type : Sword\n",
//                "48\n",
//                R.drawable.p_dmg,
//                "9\n", "5-star", "ATK is increased by 20%. Triggers on taking DMG: the soul of the Falcon of the West awakens, holding the banner of resistance aloft, regenerating HP equal to 100% of ATK and dealing 200% of ATK as DMG to surrounding opponents. This effect can only occur once every 15s.", "The soul of the Knights of Favonius. Millennia later, it still calls on the winds of swift justice to vanquish all evil — just like the last heroine who wielded it.", 1, 1, 1, R.drawable.w_1401));
//        lstWeapons.addWeapon(new com.example.genshinmaterialscalculator.Weapon("Fillet Blade", "w_1203", "Type : Sword\n",
//                "39\n",
//                R.drawable.atk,
//                "7.7\n", "3-star", "On hit, has a 50% chance to deal 240% ATK DMG to a single opponent. Can only occur once every 15s.", "A sharp filleting knife. The blade is long, thin, and incredibly sharp.", 1, 1, 1, R.drawable.w_1203));
//        lstWeapons.addWeapon(new com.example.genshinmaterialscalculator.Weapon("Luxurious Sea-Lord", "w_2313", "Type : Claymore\n",
//                "41\n",
//                R.drawable.atk,
//                "12\n", "4-star", "Increases Elemental Burst DMG by 12%. When Elemental Burst hits opponents, there is a 100% chance of summoning a huge onrush of tuna that deals 100% ATK as AoE DMG. This effect can occur once every 15s.", "The great king of the ocean. Having been air-dried, it makes for a fine weapon as well as emergency sustenance.", 1, 1, 1, R.drawable.w_2313));
//        lstWeapons.addWeapon(new com.example.genshinmaterialscalculator.Weapon("Engulfing Lightning", "w_3406", "Type : Polearm\n",
//                "46\n",
//                R.drawable.em,
//                "12\n", "5-star", "ATK increased by 28% of Energy Recharge over the base 100%. You can gain a maximum bonus of 80% ATK. Gain 30% Energy Recharge for 12s after using an Elemental Burst.  ", "A naginata used to \"cut grass.\" Any army that stands before this weapon will probably be likewise cut down...", 1, 1, 1, R.drawable.w_3406));
//        lstWeapons.addWeapon(new com.example.genshinmaterialscalculator.Weapon("Mitternachts Waltz", "w_4312", "Type : Bow\n",
//                "42\n",
//                R.drawable.p_dmg,
//                "11.3\n", "4-star", "Normal Attack hits on opponents increase Elemental Skill DMG by 20% for 5s. Elemental Skill hits on opponents increase Normal Attack DMG by 20% for 5s. ", "A bow painted the color of transgression and nights of illusion.", 1, 1, 1, R.drawable.w_4312));
//        lstWeapons.addWeapon(new com.example.genshinmaterialscalculator.Weapon("Apprentice's Notes", "w_5001", "Type : Catalyst\n",
//                "23\n",
//                R.drawable.none,
//                "", "1-star", "", "Notes left behind by a top student. Many useful spells are listed, and the handwriting is beautiful.", 1, 1, 1, R.drawable.w_5001));
//        lstWeapons.addWeapon(new com.example.genshinmaterialscalculator.Weapon("Pocket Grimoire", "w_5101", "Type : Catalyst\n",
//                "33\n",
//                R.drawable.none,
//                "", "2-star", "", "A carefully compiled notebook featuring the essentials needed to pass a magic exam.", 1, 1, 1, R.drawable.w_5101));

        Log.d("hi", db.toString());

//        for (int i = 0; i < weaponsList.size(); i++) {
//            lstWeapons.add(new com.example.genshinmaterialscalculator.Weapons(
//                    weaponsList.get(i).getName(), weaponsList.get(i).getCode(),
//                    weaponsList.get(i).getType(), weaponsList.get(i).getAttackValue(),
//                    weaponsList.get(i).getSubStat(), weaponsList.get(i).getSubStatValue(),
//                    weaponsList.get(i).getRarity(),
//                    weaponsList.get(i).getSDescription(), weaponsList.get(i).getIDescription(),
//                    weaponsList.get(i).getFirstMatID(), weaponsList.get(i).getSecondMatID(), weaponsList.get(i).getThirdMatID(),
//                    weaponsList.get(i).getImage()));
//        }

        Log.d("Reading: ", "Reading all contacts..");
        ArrayList<Weapon> weaponsArrayList = (ArrayList<Weapon>) db.getAllWeapons();

//        for (Weapon cn : weaponsArrayList) {
////            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
////                    cn.getCode() + cn.getType() + cn.getAttackValue() + cn.getSubStat() + cn.getSubStatValue() + cn.getRarity() + cn.getSDescription() + cn.getIDescription() + cn.getAttackValue();
//            // Writing Contacts to log
//            int log = cn.getImage();
//            Log.d("Name: ", String.valueOf(log));
//        }
    }


}
