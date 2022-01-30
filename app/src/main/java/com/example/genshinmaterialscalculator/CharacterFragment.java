package com.example.genshinmaterialscalculator;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
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

public class CharacterFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView mRecyclerView;
    private CharRecyclerViewAdapter adapter;
    private SearchView searchView;
    List<Character> filteredList = new ArrayList<>();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public CharacterFragment() {
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
//        setHasOptionsMenu(true);
        searchView = rootView.findViewById(R.id.search_view);
        bindCharacters();
        DatabaseHandler db = new DatabaseHandler(this.getActivity());
        ArrayList<Character> characterList = (ArrayList<Character>) db.getAllCharacter();
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_id);
        adapter = new CharRecyclerViewAdapter(this.getActivity(), characterList);
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

    private void bindCharacters() {


//        lstWeapons = new ArrayList<>();
        DatabaseHandler db = new DatabaseHandler(this.getActivity());
        List<Character> characterList = db.getAllCharacter();
        Log.d("Insert Data : ", "Inserting ..");
//        db.addCharacter(new Character("name", "fire", "sword", "12", "12", "12", "attack", "12", "12",
//                "12", R.drawable.w_2313, "code", "rarity", "sdescriptionasd",
//                "idesc", "regio", 1, 1, 1,
//                1, 1));
//        db.addCharacter(new Character("Amber", "fire", "Bow", "793", "19", "50", "attack", "12", "12",
//                "12", R.drawable.w_2313, "amber", "4-star", "sdescriptionasd",
//                "Always energetic and full of life, Amber's the best — albeit only — Outrider of the Knights of Favonius.", "regio", 1, 1, 1,
//                1, 1));
//
//        db.addCharacter(new Character("Arataki Itto", "fire", "Claymore", "1001", "18", "75", "attack", "12", "12",
//                "12", R.drawable.w_2313, "itto", "5-star", "sdescriptionasd",
//                " The first and greatest head of the Arataki Gang, famed throughout Inazuma City's Hanamizaka... Wait, what? You've never heard of them? Are you trying to be funny here?", "regio", 1, 1, 1,
//                1, 1));
//
//        db.addCharacter(new Character("Eula", "fire", "Claymore", "1030", "27", "58", "attack", "12", "12",
//                "12", R.drawable.w_2313, "eula", "5-star", "sdescriptionasd",
//                " The Spindrift Knight, a scion of the old aristocracy, and the Captain of the Knights of Favonius Reconnaissance Company. The reason for which a descendant of the ancient nobles might join the Knights remains a great mystery in Mondstadt to this very day.", "regio", 1, 1, 1,
//                1, 1));
//
//        db.addCharacter(new Character("Hu Tao", "fire", "Polearm", "1211", "8", "68", "attack", "12", "12",
//                "12", R.drawable.w_2313, "hutao", "5-star", "sdescriptionasd",
//                " The 77th Director of the Wangsheng Funeral Parlor. She took over the business at a rather young age.", "regio", 1, 1, 1,
//                1, 1));
//
//        db.addCharacter(new Character("Kaedehara Kazuha", "fire", "Sword", "1039", "23", "63", "attack", "12", "12",
//                "12", R.drawable.w_2313, "kazuha", "5-star", "sdescriptionasd",
//                " A wandering samurai from Inazuma who is currently with Liyue's Crux Fleet. A gentle and carefree soul whose heart hides a great many burdens from the past.", "regio", 1, 1, 1,
//                1, 1));
//
//        db.addCharacter(new Character("Raiden Shogun", "fire", "Polearm", "1005", "26", "61", "attack", "12", "12",
//                "12", R.drawable.w_2313, "shougun", "5-star", "sdescriptionasd",
//                " Her Excellency, the Almighty Narukami Ogosho, who promised the people of Inazuma an unchanging Eternity.", "regio", 1, 1, 1,
//                1, 1));
//
//        db.addCharacter(new Character("Rosaria", "fire", "Polearm", "1030", "20", "60", "attack", "12", "12",
//                "12", R.drawable.w_2313, "rosaria", "4-star", "sdescriptionasd",
//                " A sister of the church, though you wouldn't know it if it weren't for her attire. Known for her sharp, cold words and manner, she often works alone..", "regio", 1, 1, 1,
//                1, 1));
//
//        db.addCharacter(new Character("Sangonomiya Kokomi", "fire", "Catalyst", "1049", "18", "51", "attack", "12", "12",
//                "12", R.drawable.w_2313, "kokomi", "5-star", "sdescriptionasd",
//                " The Divine Priestess of Watatsumi Island. All of the island's affairs are at this young lady's fingertips.", "regio", 1, 1, 1,
//                1, 1));

//        Log.d("hi", db.toString());

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

//        Log.d("Reading: ", "Reading all contacts..");
//
//        for (Character cn : characterList) {
////            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
////                    cn.getCode() + cn.getType() + cn.getAttackValue() + cn.getSubStat() + cn.getSubStatValue() + cn.getRarity() + cn.getSDescription() + cn.getIDescription() + cn.getAttackValue();
//            // Writing Contacts to log
//            int log = cn.getImage();
//            Log.d("Name: ", String.valueOf(log));
//        }
    }


}
