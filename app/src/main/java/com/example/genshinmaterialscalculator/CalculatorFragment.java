package com.example.genshinmaterialscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculatorFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // Variables
    private String CharName = "Arataki Itto";
    private String Rarity = "4-star";
    //TODO: need getters for the below
    private int skill1 = R.drawable.itto_1;
    private int skill2 = R.drawable.itto_2;
    private int skill3 = R.drawable.itto_3;
    private int charImg = R.drawable.itto;
    // end
    private String region = "Liyue";

    //Seekbar
    SeekBar seekBar1;
    TextView textView1;
    SeekBar seekBar2;
    TextView textView2;
    SeekBar seekBar3;
    TextView textView3;

    // Etc Views
    ImageButton calculate;


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

        //put code here

        // intent
        String codeText = null;
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            codeText = extras.getString("Name");
            Log.d("hi",codeText);
        }

        // View stuff
        View layout = (View) rootView.findViewById(R.id.bg);
        View banner = (View) rootView.findViewById(R.id.banner);
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
                banner.setBackground(getResources().getDrawable(R.drawable.banner_ina));
                break;
            case "Liyue":
                // code block  TODO: make banner for liyue and change this
                banner.setBackground(getResources().getDrawable(R.drawable.banner_ina));
                break;
            case "Mondstadt":
                // code block
                banner.setBackground(getResources().getDrawable(R.drawable.banner_mon));
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
                //textView.setY(100); just added a value set this properly using screen with height aspect ratio , if you do not set it by default it will be there below seek bar

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

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        // END

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton:
                Intent i = new Intent(v.getContext(), Result1Activity.class);
                i.putExtra("key", 1); // ("key", value/data)
                startActivity(i);
                break;
        }
        // TODO: receiving activity needs this:
        //Bundle extras = getIntent().getExtras();
        //if (extras != null) {
        //    String value = extras.getString("key");
        //    //The key argument here must match that used in the other activity
        //}
    }
}