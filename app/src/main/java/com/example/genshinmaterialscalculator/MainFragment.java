package com.example.genshinmaterialscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ExpandableRelativeLayout mycontent;


    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
        View view = inflater.inflate(R.layout.details, container, false);
        TextView Name = view.findViewById(R.id.WeaponName);
        TextView IDescription = view.findViewById(R.id.IDescriptionText);
        TextView SDescription = view.findViewById(R.id.SDescriptionText);
        TextView Damage = view.findViewById(R.id.WeaponDmg);
        TextView SubStatValue = view.findViewById(R.id.WeaponStats);
        ImageView SubStat = view.findViewById(R.id.WeaponSubStat);
        ImageView Image = view.findViewById(R.id.WeaponImg);

        String sTitle = getArguments().getString("title");
        String WeaponSpecial = getArguments().getString("WeaponSpecial");
        String WeaponInGame = getArguments().getString("WeaponInGame");
        String WeaponDamage = getArguments().getString("WeaponDamage");
        String WeaponSubStatValue = getArguments().getString("WeaponSubStatValue");
        int WeaponSubStat = getArguments().getInt("WeaponSubStat");
        int WeaponImg = getArguments().getInt("WeaponImg");

        Name.setText(sTitle);
        IDescription.setText(WeaponInGame);
        SDescription.setText(WeaponSpecial);
        Damage.setText(WeaponDamage);
        SubStatValue.setText(WeaponSubStatValue);
        SubStat.setImageResource(WeaponSubStat);
        Image.setImageResource(WeaponImg);
        return view;
    }

}