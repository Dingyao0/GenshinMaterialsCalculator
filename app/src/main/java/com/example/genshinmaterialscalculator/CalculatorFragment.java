package com.example.genshinmaterialscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculatorFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // Variables TODO: Incoming intent
    private int charId = 1;
    //TODO: need getters for the below --Done
    private String Rarity;
    private int skill1;
    private int skill2;
    private int skill3;
    private int charImg;
    // end

    Character c;

    //to Send to results activity
    private String region; //also for calculation
    private int ascension;
    private String element;
    private int talent1Lvl;
    private int talent2Lvl;
    private int talent3Lvl;

    //Seekbar
    SeekBar seekBar1;
    TextView textView1;
    SeekBar seekBar2;
    TextView textView2;
    SeekBar seekBar3;
    TextView textView3;

    // Etc Views
    ImageButton calculate;
    RadioGroup radioGroup;
    RadioButton radioSexButton;
    ImageView skill1Img, skill2Img, skill3Img, charCImg;


    public CalculatorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalculatorFragment newInstance(String param1, String param2) {
        CalculatorFragment fragment = new CalculatorFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_calculator, container, false);

        //DB data and images
        DatabaseHandler dbHandler = new DatabaseHandler(this.getActivity());
        c = dbHandler.getCharacterById(charId);

        Rarity = c.getRarity();
        Log.d("Rarity: ", Rarity);
        skill1 = c.getSkill1();
        skill2 = c.getSkill2();
        skill3 = c.getSkill3();
        charImg = c.getImage();
        region = c.getRegion();
        element = c.getElement();

        //set img from db
        skill1Img = (ImageView) rootView.findViewById(R.id.skill1);
        skill2Img = (ImageView) rootView.findViewById(R.id.skill2);
        skill3Img = (ImageView) rootView.findViewById(R.id.skill3);
        charCImg = (ImageView) rootView.findViewById(R.id.card);

        skill1Img.setImageDrawable(getResources().getDrawable(skill1));
        skill2Img.setImageDrawable(getResources().getDrawable(skill2));
        skill3Img.setImageDrawable(getResources().getDrawable(skill3));
        charCImg.setImageDrawable(getResources().getDrawable(charImg));

        // intent
        String codeText = null;
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            codeText = extras.getString("Name");
            Log.d("hi",codeText);
        }

        // View stuff
        View layout = (View) rootView.findViewById(R.id.bg);
        ImageView banner = (ImageView) rootView.findViewById(R.id.banner);
        //end


        if(Rarity.equals("5-star")){
            switch(region) {
                case "Inazuma":
                    // code block
                    layout.setBackground(getResources().getDrawable(R.drawable.ina5star));
                    break;
                case "Liyue":
                    // code block
                    layout.setBackground(getResources().getDrawable(R.drawable.liy5star));
                    break;
                case "Mondstadt":
                    // code block
                    layout.setBackground(getResources().getDrawable(R.drawable.mon5star));
                    break;
            }
        } else if(Rarity.equals("4-star")){
            switch(region) {
                case "Inazuma":
                    // code block
                    layout.setBackground(getResources().getDrawable(R.drawable.ina4star));
                    break;
                case "Liyue":
                    // code block
                    layout.setBackground(getResources().getDrawable(R.drawable.liy4star));
                    break;
                case "Mondstadt":
                    // code block
                    layout.setBackground(getResources().getDrawable(R.drawable.mon4star));
                    break;
            }
        }

        switch (region) {
            case "Inazuma":
                banner.setImageDrawable(getResources().getDrawable(R.drawable.banner_ina));
                break;
            case "Liyue":
                // code block  TODO: make banner for liyue and change this
                banner.setImageDrawable(getResources().getDrawable(R.drawable.banner_ina));
                break;
            case "Mondstadt":
                // code block
                banner.setImageDrawable(getResources().getDrawable(R.drawable.banner_mon));
                break;
        }


        // Code for moving textView to the Seekbar
        seekBar1 = (SeekBar) rootView.findViewById(R.id.seekBar1);
        textView1 = (TextView) rootView.findViewById(R.id.textView1);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int val = (progress * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                textView1.setText("" + progress);
                textView1.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);
                talent1Lvl = progress;
                //textView.setY(100); just added a value set this properly using screen with height aspect ratio , if you do not set it by default it will be there below seek bar

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar2 = (SeekBar) rootView.findViewById(R.id.seekBar2);
        textView2 = (TextView) rootView.findViewById(R.id.textView2);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int val = (progress * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                textView2.setText("" + progress);
                textView2.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);
                talent2Lvl = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar3 = (SeekBar) rootView.findViewById(R.id.seekBar3);
        textView3 = (TextView) rootView.findViewById(R.id.textView3);
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int val = (progress * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                textView3.setText("" + progress);
                textView3.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);
                talent2Lvl = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        // END

//        //ascension spinner
//        Spinner ascensionSpinner = rootView.findViewById(R.id.spinner);
//        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(rootView.getContext(), R.array.ascension_list, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
//
//        ascensionSpinner.setAdapter(adapter);

        radioGroup=(RadioGroup)rootView.findViewById(R.id.radiogroup);
        calculate = rootView.findViewById(R.id.imageButton);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioSexButton = (RadioButton)rootView.findViewById(selectedId);

                String temp = (String) radioSexButton.getText();

                switch(temp) {
                    case "Ascension 1 (20/40)":
                        ascension = 2;
                        break;
                    case "Ascension 2 (40/50)":
                        ascension = 3;
                        break;
                    case "Ascension 3 (50/60)":
                        ascension = 4;
                        break;
                    case "Ascension 4 (60/70)":
                        ascension = 5;
                        break;
                    case "Ascension 5 (70/80)":
                        ascension = 6;
                        break;
                    case "Ascension 6 (80/90)":
                        ascension = 7;
                        break;
                }

                Intent i = new Intent(v.getContext(), Result1Activity.class);
                i.putExtra("region", region);
                i.putExtra("ascension", ascension); // ("key", value/data)
                i.putExtra("element", element);
                i.putExtra("charId", charId);
                i.putExtra("talent1Lvl", talent1Lvl);
                i.putExtra("talent2Lvl", talent2Lvl);
                i.putExtra("talent3Lvl", talent3Lvl);
                startActivity(i);
            }
        });

        return rootView;
    }

//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.imageButton:
//                Intent i = new Intent(v.getContext(), Result1Activity.class);
//                i.putExtra("region", region);
//                i.putExtra("ascension", ascension); // ("key", value/data)
//                i.putExtra("element", element);
//                i.putExtra("charName", charName);
//                i.putExtra("talent1Lvl", talent1Lvl);
//                i.putExtra("talent2Lvl", talent2Lvl);
//                i.putExtra("talent3Lvl", talent3Lvl);
//                startActivity(i);
//                break;
//        }
//        // TODO: receiving activity needs this:
//        //Bundle extras = getIntent().getExtras();
//        //if (extras != null) {
//        //    String value = extras.getString("key");
//        //    //The key argument here must match that used in the other activity
//        //}
//    }

}