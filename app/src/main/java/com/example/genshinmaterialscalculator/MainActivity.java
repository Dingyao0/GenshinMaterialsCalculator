package com.example.genshinmaterialscalculator;

import android.os.Bundle;
import android.util.Log;

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

        DatabaseHandler db = new DatabaseHandler(this);
        //db.deleteDatabase();

        db.addWeapon(new Weapon("Cool_Steel", "w_1201", "Sword\n",
                "23\n", 1, "7.7\n",
                "1-star", "Increases DMG against opponents affected by Hydro or Cryo by 12%.\n",
                "A reliable steel-forged weapon that serves as a testament to the great adventures of its old master.\n",
                1, 1, 1, 1));
        Log.d("weapon type of first weapon", String.valueOf(db.getAllWeapons().get(1).getType()));

        db.addCharacter(new Character("name", "fire", "sword", "12","12", "12","attack", "12", "12",
                "12", 1, "code", "rarity", "sdescriptionasd",
                "idesc", "regio", 1, 1, 1,1,1,1,
        1, 1));
        Log.d("character name", String.valueOf(db.getCharacterById(1).getName()));
        Log.d("character name from search", String.valueOf(db.getCharacterSearchResult("nam").get(0).getName()));


        db.addCharacterLocal(new CharacterLocal("name", "region"));
        Log.d("characterlocal name", String.valueOf(db.getCharacterLocalById(1).getClName()));

        db.addCharacterPrimary(new CharacterPrimary("name11","name2","name3","name4","whereee",1));
        Log.d("characterPrimary name1", String.valueOf(db.getCharacterPrimaryById(1).getCpName1()));

        db.addCharacterSecondary(new CharacterSecondary("name12","name2","name3","wherer",1));
        Log.d("characterSecondary name1", String.valueOf(db.getCharacterSecondaryById(1).getCseName1()));

        db.addCharacterStone(new CharacterStone("stone",1));
        Log.d("characterStone name", String.valueOf(db.getCharacterStoneById(1).getCstName()));

        db.addWeaponPrimary(new WeaponPrimary("weaqpp","name2","name3","name4","name5",1));
        Log.d("weap primary name1", String.valueOf(db.getWeaponPrimaryById(1).getWpName1()));

        db.addWeaponSecondary(new WeaponSecondary("weapse","name2","name3","where",1));
        Log.d("weap secondary name1", String.valueOf(db.getWeaponSecondaryById(1).getWsName1()));

        db.addWeekly(new Weekly("weekly",1));
        Log.d("weekly name", String.valueOf(db.getWeeklyById(1).getName()));

        db.addFavorite(2);
        Log.d("list id first", Integer.toString(db.getAllFavouriteCharacterId().get(0)));


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
                        replace(new com.example.genshinmaterialscalculator.SearchFragment());
                        break;

                    case 3:
                        replace(new com.example.genshinmaterialscalculator.BookmarkFragment());
                        break;

                    case 4:
                        replace(new com.example.genshinmaterialscalculator.ProfileFragment());
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