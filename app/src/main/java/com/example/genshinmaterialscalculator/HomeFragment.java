package com.example.genshinmaterialscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ImageButton androidImageButton;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        DatabaseHandler db = new DatabaseHandler(getActivity());
        List<Integer> favIds = db.getAllFavouriteCharacterId();
        List<Integer> bannerList = new ArrayList<Integer>();
        db.close();
        for (int i = 0; i < favIds.size(); i++) {
            Character character = db.getCharacterById(favIds.get(i));
            bannerList.add(character.getBannerImage());
        }

        if (!(favIds.isEmpty())) {

            androidImageButton = (ImageButton) rootView.findViewById(R.id.btnFav2);
            androidImageButton.setVisibility(View.INVISIBLE);
            androidImageButton = (ImageButton) rootView.findViewById(R.id.btnFav3);
            androidImageButton.setVisibility(View.INVISIBLE);

            androidImageButton = (ImageButton) rootView.findViewById(R.id.btnFav1);
            androidImageButton.setVisibility(View.VISIBLE);

            androidImageButton.setImageResource(bannerList.get(0));
            androidImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), CharDetails.class);
                    intent.putExtra("ID", favIds.get(0));
                    startActivity(intent);
                }
            });
            Log.d("favids", String.valueOf(favIds.get(0)));

            if (favIds.size() > 1) {

                androidImageButton = (ImageButton) rootView.findViewById(R.id.btnFav3);
                androidImageButton.setVisibility(View.INVISIBLE);


                androidImageButton = (ImageButton) rootView.findViewById(R.id.btnFav2);
                androidImageButton.setVisibility(View.VISIBLE);
                androidImageButton.setImageResource(bannerList.get(1));
                androidImageButton.setOnClickListener(new View.OnClickListener() {
                    //            @Override
//            public void onClick(View v) {
//                Toast.makeText(HomeFragment.this.getActivity(), "Btn2", Toast.LENGTH_SHORT).show();
//            }
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), CharDetails.class);
                        intent.putExtra("ID", favIds.get(1));
                        startActivity(intent);
                    }
                });
                if (favIds.size() > 2) {
                    androidImageButton = (ImageButton) rootView.findViewById(R.id.btnFav3);
                    androidImageButton.setVisibility(View.VISIBLE);
                    androidImageButton.setImageResource(bannerList.get(2));
                    androidImageButton.setOnClickListener(new View.OnClickListener() {
                        //            @Override
//            public void onClick(View v) {
//                Toast.makeText(HomeFragment.this.getActivity(), "Btn3", Toast.LENGTH_SHORT).show();
//            }
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getActivity(), CharDetails.class);
                            intent.putExtra("ID", favIds.get(2));
                            startActivity(intent);
                        }
                    });
                }
            }
        } else {
            androidImageButton = (ImageButton) rootView.findViewById(R.id.btnFav1);
            androidImageButton.setVisibility(View.INVISIBLE);
            androidImageButton = (ImageButton) rootView.findViewById(R.id.btnFav2);
            androidImageButton.setVisibility(View.INVISIBLE);
            androidImageButton = (ImageButton) rootView.findViewById(R.id.btnFav3);
            androidImageButton.setVisibility(View.INVISIBLE);
        }

        // Inflate the layout for this fragment
        return rootView;
    }
}