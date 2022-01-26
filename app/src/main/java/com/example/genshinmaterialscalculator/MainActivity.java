package com.example.genshinmaterialscalculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    private MeowBottomNavigation bnv_Main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DatabaseHandler db = new DatabaseHandler(this);
//        //db.deleteDatabase();
//        db.addWeapon(new Weapons("Cool_Steel", "w_1201", "Sword\n",
//                "23\n", "ATK\n", "7.7\n",
//                "1-star", "Increases DMG against opponents affected by Hydro or Cryo by 12%.\n",
//                "A reliable steel-forged weapon that serves as a testament to the great adventures of its old master.\n",
//                1, 1, 1, 1));//R.drawable.w_1201
//
//        Log.d("string value of first object", String.valueOf(db.getAllWeapons().get(0).getType()));


        bnv_Main = findViewById(R.id.bnv_Main);
        bnv_Main.add(new MeowBottomNavigation.Model(1, R.drawable.home));
        bnv_Main.add(new MeowBottomNavigation.Model(2, R.drawable.search));
        bnv_Main.add(new MeowBottomNavigation.Model(3, R.drawable.bookmark));
        bnv_Main.add(new MeowBottomNavigation.Model(4, R.drawable.person));

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
                        replace(new CalculatorFragment());
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