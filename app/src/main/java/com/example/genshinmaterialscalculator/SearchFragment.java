package com.example.genshinmaterialscalculator;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter adapter;
    private SearchView searchView;
    List<Weapon> filteredList = new ArrayList<>();
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
        setHasOptionsMenu(true);
        searchView = rootView.findViewById(R.id.search_view);
        bindWeapons();
        DatabaseHandler lstWeapons = new DatabaseHandler(this.getActivity());
//        Log.d("Reading: ", "Reading all contacts..");
        ArrayList<Weapon> weaponsList = (ArrayList<Weapon>) lstWeapons.getAllWeapons();
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_id);
        com.example.genshinmaterialscalculator.RecyclerViewAdapter myAdapter = new com.example.genshinmaterialscalculator.RecyclerViewAdapter(this.getActivity(), weaponsList);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(), 3));
        mRecyclerView.setAdapter(myAdapter);        // Inflate the layout for this fragment
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                filter(newText);
//                return true;
//            }
//        });

        return rootView;
    }

//    private void filter(String newText) {
////        List<Weapons> filteredList= null;
//        DatabaseHandler lstWeapons = new DatabaseHandler(this.getActivity());
//        ArrayList<Weapons> weaponsList = (ArrayList<Weapons>) lstWeapons.getAllWeapons();
//        for (Weapons item : weaponsList) {
//            if (item.getName().toLowerCase().contains(newText.toLowerCase())) {
//                Log.d("hi",item.getName());
//                filteredList.add(item);
//            }
//        }
//        Log.d("hi", String.valueOf(filteredList));
//        recyclerViewAdapter.filterList(filteredList);
//        Log.d("hi", "hi7");
//    }


    private void bindWeapons() {
//        lstWeapons = new ArrayList<>();
        DatabaseHandler lstWeapons = new DatabaseHandler(this.getActivity());
        List<Weapon> weaponsList = lstWeapons.getAllWeapons();
        Log.d("Insert Data : ", "Inserting ..");
//        lstWeapons.addWeapon(new com.example.genshinmaterialscalculator.Weapons("Cool Steel", "w_1201", "Type : Sword",
//                "39\n",
//                R.drawable.substat,
//                "0\n", "Rarity: 3-star", "Increases DMG against opponents affected by Hydro or Cryo by 12%.", "A reliable steel-forged weapon that serves as a testament to the great adventures of its old master.", 1, 1, 1, R.drawable.w_1201));
//        lstWeapons.addWeapon(new com.example.genshinmaterialscalculator.Weapons("Blackcliff Longsword", "w_1301", "Type : Sword\n",
//                "44\n",
//                R.drawable.substat,
//                "8\n", "4-star", "After defeating an opponent, ATK is increased by 12% for 30s. This effect has a maximum of 3 stacks, and the duration of each stack is independent of the others.", "A sword made of a material known as \"blackcliff.\" It has a dark crimson glow on its black blade.", 1, 1, 1, R.drawable.w_1301));
//        lstWeapons.addWeapon(new com.example.genshinmaterialscalculator.Weapons("Aquila Favonia", "w_1401", "Type : Sword\n",
//                "48\n",
//                R.drawable.substat,
//                "9\n", "5-star", "ATK is increased by 20%. Triggers on taking DMG: the soul of the Falcon of the West awakens, holding the banner of resistance aloft, regenerating HP equal to 100% of ATK and dealing 200% of ATK as DMG to surrounding opponents. This effect can only occur once every 15s.", "The soul of the Knights of Favonius. Millennia later, it still calls on the winds of swift justice to vanquish all evil — just like the last heroine who wielded it.", 1, 1, 1, R.drawable.w_1401));
//        lstWeapons.addWeapon(new com.example.genshinmaterialscalculator.Weapons("Fillet Blade", "w_1203", "Type : Sword\n",
//                "39\n",
//                R.drawable.substat,
//                "7.7\n", "3-star", "On hit, has a 50% chance to deal 240% ATK DMG to a single opponent. Can only occur once every 15s.", "A sharp filleting knife. The blade is long, thin, and incredibly sharp.", 1, 1, 1, R.drawable.w_1203));

        Log.d("hi", lstWeapons.toString());

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
        ArrayList<Weapon> weaponsArrayList = (ArrayList<Weapon>) lstWeapons.getAllWeapons();

        for (Weapon cn : weaponsArrayList) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                    cn.getCode() + cn.getType() + cn.getAttackValue() + cn.getSubStat() + cn.getSubStatValue() + cn.getRarity() + cn.getSDescription() + cn.getIDescription() + cn.getAttackValue();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Add your menu entries here
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        android.widget.SearchView searchView = (android.widget.SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                Log.d("newText1", query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("newText", newText);
                adapter.getFilter().filter(newText);
                Log.d("newText2", newText);
                return false;
            }
        });
    }


}
