package com.example.genshinmaterialscalculator;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import java.nio.channels.Channel;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    private MeowBottomNavigation bnv_Main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        DatabaseHandler db = new DatabaseHandler(this);
//        Log.d("getCharacterByName: ", db.getCharacterByName("Arataki Itto").getName());

        bnv_Main = findViewById(R.id.bnv_Main);
        bnv_Main.add(new MeowBottomNavigation.Model(1, R.drawable.homeicon));
        bnv_Main.add(new MeowBottomNavigation.Model(2, R.drawable.weaponsicon));
        bnv_Main.add(new MeowBottomNavigation.Model(3, R.drawable.char_35));
        bnv_Main.add(new MeowBottomNavigation.Model(4, R.drawable.ic_baseline_calculate_24));

        bnv_Main.show(1, true);
        replace(new com.example.genshinmaterialscalculator.HomeFragment());
        bnv_Main.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()) {
                    case 1:
                        replace(new com.example.genshinmaterialscalculator.HomeFragment());
                        break;

                    case 2:
                        replace(new com.example.genshinmaterialscalculator.WeaponFragment());
                        break;

                    case 3:
                        replace(new com.example.genshinmaterialscalculator.CharacterFragment());
                        break;

                    case 4:
                        replace(new com.example.genshinmaterialscalculator.CalculatorFragment());
                        break;
                }
                return null;
            }
        });

    }



    private void replace(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.commit();
    }
}