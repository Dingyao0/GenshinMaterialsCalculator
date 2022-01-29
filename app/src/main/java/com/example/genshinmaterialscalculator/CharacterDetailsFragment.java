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

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharacterDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterDetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageButton button1, button2;
    private Button button3;
    private View layout;
    private ExpandableRelativeLayout mycontent;


    public CharacterDetailsFragment() {
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
        View view = inflater.inflate(R.layout.characterdetails, container, false);
        TextView Name = view.findViewById(R.id.CharName);
        TextView IDescription = view.findViewById(R.id.IDescriptionText);
        TextView Damage = view.findViewById(R.id.CharDmg);
        TextView SubStatValue = view.findViewById(R.id.CharStats);
        TextView Health = view.findViewById(R.id.health);
        TextView Shield = view.findViewById(R.id.shield);
        ImageView stars = view.findViewById(R.id.Stars);
//        ImageView SubStat = view.findViewById(R.id.CharSubStat);
        ImageView Image = view.findViewById(R.id.WeaponImg);
        layout = (View) view.findViewById(R.id.detailsBG);

        String sTitle = getArguments().getString("title");
        String CharInGame = getArguments().getString("CharInGame");
        String CharDamage = getArguments().getString("CharDamage");
        String CharSubStatValue = getArguments().getString("CharSubStatValue");
//        int WeaponSubStat = getArguments().getInt("WeaponSubStat");
        int CharImg = getArguments().getInt("CharImg");
        String Code = getArguments().getString("Code");
        String HealthText = getArguments().getString("Health");
        String ShieldText = getArguments().getString("Shield");
        String Rarity = getArguments().getString("Rarity");

        button1 = view.findViewById(R.id.details1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mycontent = (ExpandableRelativeLayout) view.findViewById(R.id.special);
                mycontent.toggle();
            }
        });
        button3 = view.findViewById(R.id.moreDetails);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Webview.class);
                intent.putExtra("key", Code);
                intent.putExtra("type", "Character");
                startActivity(intent);
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
        IDescription.setText(CharInGame);
        Damage.setText(CharDamage);
        SubStatValue.setText(CharSubStatValue);
        Health.setText(HealthText);
        Shield.setText(ShieldText);
//        SubStat.setImageResource(WeaponSubStat);
        Image.setImageResource(CharImg);
        return view;
    }


}