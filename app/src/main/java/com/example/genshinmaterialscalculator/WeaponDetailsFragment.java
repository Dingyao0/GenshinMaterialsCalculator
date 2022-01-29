package com.example.genshinmaterialscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeaponDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeaponDetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageButton button1, button2,button3,button4;
    private View layout;
    private ExpandableRelativeLayout mycontent;


    public WeaponDetailsFragment() {
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
    public static WeaponDetailsFragment newInstance(String param1, String param2) {
        WeaponDetailsFragment fragment = new WeaponDetailsFragment();
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
        View view = inflater.inflate(R.layout.weaponsdetails, container, false);
        TextView Name = view.findViewById(R.id.WeaponName);
        TextView IDescription = view.findViewById(R.id.IDescriptionText);
        TextView SDescription = view.findViewById(R.id.SDescriptionText);
        TextView Damage = view.findViewById(R.id.WeaponDmg);
        TextView SubStatValue = view.findViewById(R.id.WeaponStats);
        ImageView SubStat = view.findViewById(R.id.WeaponSubStat);
        ImageView stars = view.findViewById(R.id.Stars);
        ImageView Image = view.findViewById(R.id.WeaponImg);

        layout = (View) view.findViewById(R.id.detailsBG);

        String sTitle = getArguments().getString("title");
        String WeaponSpecial = getArguments().getString("WeaponSpecial");
        String WeaponInGame = getArguments().getString("WeaponInGame");
        String WeaponDamage = getArguments().getString("WeaponDamage");
        String WeaponSubStatValue = getArguments().getString("WeaponSubStatValue");
        int WeaponSubStat = getArguments().getInt("WeaponSubStat");
        int WeaponImg = getArguments().getInt("WeaponImg");
        String Code = getArguments().getString("Code");
        String Rarity = getArguments().getString("Rarity");


        button1 = view.findViewById(R.id.details1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mycontent = (ExpandableRelativeLayout) view.findViewById(R.id.special);
                mycontent.toggle();
            }
        });
        button2 = view.findViewById(R.id.details2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mycontent = (ExpandableRelativeLayout) view.findViewById(R.id.inGame);
                mycontent.toggle();
            }
        });
        button3 = view.findViewById(R.id.moreDetails);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Webview.class);
                intent.putExtra("key", Code);
                intent.putExtra("type", "Weapons");
                startActivity(intent);
            }
        });
        button4 = view.findViewById(R.id.calculator);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CalculatorFragment.class);
                intent.putExtra("Name", sTitle);
                Fragment newFragment = new CalculatorFragment();
                // consider using Java coding conventions (upper first char class names!!!)
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.detailsBG, newFragment);
                transaction.addToBackStack(null);
                // Commit the transaction
                transaction.commit();
            }
        });

        if (Rarity.equals("1-star")) {
            layout.setBackgroundResource(R.drawable.onestar);
            stars.setImageResource(R.drawable.one);
        } else if (Rarity.equals("2-star")) {
            layout.setBackgroundResource(R.drawable.twostar);
            stars.setImageResource(R.drawable.two);
        } else if (Rarity.equals("3-star")) {
            layout.setBackgroundResource(R.drawable.threestar);
            stars.setImageResource(R.drawable.three);
        } else if (Rarity.equals("4-star")) {
            layout.setBackgroundResource(R.drawable.fourstar);
            stars.setImageResource(R.drawable.four);
        } else if (Rarity.equals("5-star")) {
            layout.setBackgroundResource(R.drawable.fivestar);
            stars.setImageResource(R.drawable.five);
        }

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