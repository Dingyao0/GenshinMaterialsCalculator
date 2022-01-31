package com.example.genshinmaterialscalculator;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharDetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ViewPager viewPager;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CharDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CharDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharDetailsFragment newInstance(String param1, String param2) {
        CharDetailsFragment fragment = new CharDetailsFragment();
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
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.viewpager, container, false);
        viewPager = rootview.findViewById(R.id.view_pager);
        DatabaseHandler db = new DatabaseHandler(this.getActivity());
        ArrayList<Character> charactersList = (ArrayList<Character>) db.getAllCharacter();
        prepareViewPager(viewPager, charactersList);
        return rootview;
    }

    private void prepareViewPager(ViewPager viewPager, ArrayList<Character> arrayList) {
        CharDetailsFragment.MainAdapter adapter = new CharDetailsFragment.MainAdapter(getFragmentManager());
        CharacterDetailsFragment fragment = new CharacterDetailsFragment();

        for (int i = 0; i < arrayList.size(); i++) {
            Bundle bundle = new Bundle();
            Log.d("IDDD",arrayList.get(i).getName()+" "+arrayList.get(i).getId());
            bundle.putString("title", arrayList.get(i).getName());
            bundle.putString("CharInGame", arrayList.get(i).getIDescription());
            bundle.putString("CharDamage", arrayList.get(i).getAttackValue());
            bundle.putString("Health", arrayList.get(i).getHp());
            bundle.putString("Shield", arrayList.get(i).getDef());
            bundle.putString("CharSubStatValue", arrayList.get(i).getSecondaryStatValue());
            bundle.putInt("CharImg", arrayList.get(i).getImage());
            bundle.putInt("CharSubStat", arrayList.get(i).getSecondaryStat());
            bundle.putString("Code", arrayList.get(i).getCode());
            bundle.putString("Rarity", arrayList.get(i).getRarity());
            fragment.setArguments(bundle);
            adapter.addFragment(fragment, arrayList.get(i).getName());
            fragment = new CharacterDetailsFragment();

        }
        Intent intent = getActivity().getIntent();
        int ID = intent.getExtras().getInt("ID");
        viewPager.setAdapter(adapter);
        Log.d("id", String.valueOf(ID));
        viewPager.setCurrentItem(ID - 1);
    }


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