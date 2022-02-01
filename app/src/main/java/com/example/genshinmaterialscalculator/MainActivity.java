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

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    private MeowBottomNavigation bnv_Main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);

        if (firstStart == true) {
            firstTime();
        }

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
                        replace(new com.example.genshinmaterialscalculator.CalculatorFragment());
                        break;
                }
                return null;
            }
        });

    }

    private void firstTime() {
        DatabaseHandler db = new DatabaseHandler(this);
        new AlertDialog.Builder(this)
                .setTitle("Welcome!")
                .setMessage("Welcome to our app!")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//      Add Weapons
                        db.addWeapon(new com.example.genshinmaterialscalculator.Weapon("Cool Steel", "w_1201", "Type : Sword",
                                "39\n",
                                R.drawable.atk,
                                "0\n", "3-star", "Increases DMG against opponents affected by Hydro or Cryo by 12%.", "A reliable steel-forged weapon that serves as a testament to the great adventures of its old master.", 1, 1, 1, R.drawable.w_1201));
                        db.addWeapon(new com.example.genshinmaterialscalculator.Weapon("Blackcliff Longsword", "w_1301", "Type : Sword\n",
                                "44\n",
                                R.drawable.cd,
                                "8\n", "4-star", "After defeating an opponent, ATK is increased by 12% for 30s. This effect has a maximum of 3 stacks, and the duration of each stack is independent of the others.", "A sword made of a material known as \"blackcliff.\" It has a dark crimson glow on its black blade.", 1, 1, 1, R.drawable.w_1301));
                        db.addWeapon(new com.example.genshinmaterialscalculator.Weapon("Aquila Favonia", "w_1401", "Type : Sword\n",
                                "48\n",
                                R.drawable.p_dmg,
                                "9\n", "5-star", "ATK is increased by 20%. Triggers on taking DMG: the soul of the Falcon of the West awakens, holding the banner of resistance aloft, regenerating HP equal to 100% of ATK and dealing 200% of ATK as DMG to surrounding opponents. This effect can only occur once every 15s.", "The soul of the Knights of Favonius. Millennia later, it still calls on the winds of swift justice to vanquish all evil — just like the last heroine who wielded it.", 1, 1, 1, R.drawable.w_1401));
                        db.addWeapon(new com.example.genshinmaterialscalculator.Weapon("Fillet Blade", "w_1203", "Type : Sword\n",
                                "39\n",
                                R.drawable.atk,
                                "7.7\n", "3-star", "On hit, has a 50% chance to deal 240% ATK DMG to a single opponent. Can only occur once every 15s.", "A sharp filleting knife. The blade is long, thin, and incredibly sharp.", 1, 1, 1, R.drawable.w_1203));
                        db.addWeapon(new com.example.genshinmaterialscalculator.Weapon("Luxurious Sea-Lord", "w_2313", "Type : Claymore\n",
                                "41\n",
                                R.drawable.atk,
                                "12\n", "4-star", "Increases Elemental Burst DMG by 12%. When Elemental Burst hits opponents, there is a 100% chance of summoning a huge onrush of tuna that deals 100% ATK as AoE DMG. This effect can occur once every 15s.", "The great king of the ocean. Having been air-dried, it makes for a fine weapon as well as emergency sustenance.", 1, 1, 1, R.drawable.w_2313));
                        db.addWeapon(new com.example.genshinmaterialscalculator.Weapon("Engulfing Lightning", "w_3406", "Type : Polearm\n",
                                "46\n",
                                R.drawable.em,
                                "12\n", "5-star", "ATK increased by 28% of Energy Recharge over the base 100%. You can gain a maximum bonus of 80% ATK. Gain 30% Energy Recharge for 12s after using an Elemental Burst.  ", "A naginata used to \"cut grass.\" Any army that stands before this weapon will probably be likewise cut down...", 1, 1, 1, R.drawable.w_3406));
                        db.addWeapon(new com.example.genshinmaterialscalculator.Weapon("Mitternachts Waltz", "w_4312", "Type : Bow\n",
                                "42\n",
                                R.drawable.p_dmg,
                                "11.3\n", "4-star", "Normal Attack hits on opponents increase Elemental Skill DMG by 20% for 5s. Elemental Skill hits on opponents increase Normal Attack DMG by 20% for 5s. ", "A bow painted the color of transgression and nights of illusion.", 1, 1, 1, R.drawable.w_4312));
                        db.addWeapon(new com.example.genshinmaterialscalculator.Weapon("Apprentice's Notes", "w_5001", "Type : Catalyst\n",
                                "23\n",
                                R.drawable.none,
                                "", "1-star", "", "Notes left behind by a top student. Many useful spells are listed, and the handwriting is beautiful.", 1, 1, 1, R.drawable.w_5001));
                        db.addWeapon(new com.example.genshinmaterialscalculator.Weapon("Pocket Grimoire", "w_5101", "Type : Catalyst\n",
                                "33\n",
                                R.drawable.none,
                                "", "2-star", "", "A carefully compiled notebook featuring the essentials needed to pass a magic exam.", 1, 1, 1, R.drawable.w_5101));
                        Log.d("weapon type of first weapon", String.valueOf(db.getAllWeapons().get(1).getType()));

//      Add characters

                        db.addCharacter(new Character("Amber", "fire", "Bow", "793", "19", "50", R.drawable.atk_pct, "0", "12",
                                "12", R.drawable.amber, "amber", "4-star", "sdescriptionasd",
                                "Always energetic and full of life, Amber's the best — albeit only — Outrider of the Knights of Favonius.", "regio", R.drawable.w_2313, R.drawable.w_2313, R.drawable.w_2313, R.drawable.amberbanner,
                                1, 1, 1, 1, 1));

                        db.addCharacter(new Character("Arataki Itto", "fire", "Claymore", "1001", "18", "75", R.drawable.cr, "5", "12",
                                "12", R.drawable.itto, "itto", "5-star", "sdescriptionasd",
                                " The first and greatest head of the Arataki Gang, famed throughout Inazuma City's Hanamizaka... Wait, what? You've never heard of them? Are you trying to be funny here?", "regio", R.drawable.w_2313, R.drawable.w_2313, R.drawable.w_2313, R.drawable.ittobanner,
                                1, 1, 1, 1, 1));

                        db.addCharacter(new Character("Eula", "fire", "Claymore", "1030", "27", "58", R.drawable.cd, "50", "12",
                                "12", R.drawable.eula, "eula", "5-star", "sdescriptionasd",
                                " The Spindrift Knight, a scion of the old aristocracy, and the Captain of the Knights of Favonius Reconnaissance Company. The reason for which a descendant of the ancient nobles might join the Knights remains a great mystery in Mondstadt to this very day.", "regio", R.drawable.w_2313, R.drawable.w_2313, R.drawable.w_2313, R.drawable.eulabanner,
                                1, 1, 1, 1, 1));

                        db.addCharacter(new Character("Hu Tao", "fire", "Polearm", "1211", "8", "68", R.drawable.cd, "50", "12",
                                "12", R.drawable.hutao, "hutao", "5-star", "sdescriptionasd",
                                " The 77th Director of the Wangsheng Funeral Parlor. She took over the business at a rather young age.", "regio", R.drawable.w_2313, R.drawable.w_2313, R.drawable.w_2313, R.drawable.hutaobanner,
                                1, 1, 1, 1, 1));

                        db.addCharacter(new Character("Raiden Shogun", "fire", "Polearm", "1005", "26", "61", R.drawable.em, "0", "12",
                                "12", R.drawable.shougun, "shougun", "5-star", "sdescriptionasd",
                                " Her Excellency, the Almighty Narukami Ogosho, who promised the people of Inazuma an unchanging Eternity.", "regio", R.drawable.w_2313, R.drawable.w_2313, R.drawable.w_2313, R.drawable.raiden_shogun,
                                1, 1, 1, 1, 1));
                        db.addCharacter(new Character("Rosaria", "fire", "Polearm", "1030", "20", "60", R.drawable.atk_pct, "0", "12",
                                "12", R.drawable.rosaria, "rosaria", "4-star", "sdescriptionasd",
                                " A sister of the church, though you wouldn't know it if it weren't for her attire. Known for her sharp, cold words and manner, she often works alone..", "regio", R.drawable.w_2313, R.drawable.w_2313, R.drawable.w_2313, R.drawable.rosariabanner,
                                1, 1, 1, 1, 1));
                        db.addCharacter(new Character("Sangonomiya Kokomi", "fire", "Catalyst", "1049", "18", "51", R.drawable.atk_pct, "0", "12",
                                "12", R.drawable.kokomi, "kokomi", "5-star", "sdescriptionasd",
                                " The Divine Priestess of Watatsumi Island. All of the island's affairs are at this young lady's fingertips.", "regio", R.drawable.w_2313, R.drawable.w_2313, R.drawable.w_2313, R.drawable.kokomibanner,
                                1, 1, 1, 1, 1));

                        db.addCharacter(new Character("Kaedehara Kazuha", "fire", "Sword", "1039", "23", "63", R.drawable.atk_pct, "0", "12",
                                "12", R.drawable.kazuha, "kazuha", "5-star", "sdescriptionasd",
                                " A wandering samurai from Inazuma who is currently with Liyue's Crux Fleet. A gentle and carefree soul whose heart hides a great many burdens from the past.", "regio", R.drawable.w_2313, R.drawable.w_2313, R.drawable.w_2313, R.drawable.kazuhabanner,
                                1, 1, 1, 1, 1));

                        Log.d("character name", String.valueOf(db.getCharacterById(1).getName()));

                        db.addCharacterLocal(new CharacterLocal("name", "region"));
                        Log.d("characterlocal name", String.valueOf(db.getCharacterLocalById(1).getClName()));

                        db.addCharacterPrimary(new CharacterPrimary("name11", "name2", "name3", "name4", "whereee", R.drawable.w_2313));
                        Log.d("characterPrimary name1", String.valueOf(db.getCharacterPrimaryById(1).getCpName1()));

                        db.addCharacterSecondary(new CharacterSecondary("name12", "name2", "name3", "wherer", R.drawable.w_2313));
                        Log.d("characterSecondary name1", String.valueOf(db.getCharacterSecondaryById(1).getCseName1()));

                        db.addCharacterStone(new CharacterStone("stone", R.drawable.w_2313));
                        Log.d("characterStone name", String.valueOf(db.getCharacterStoneById(1).getCstName()));

                        db.addWeaponPrimary(new WeaponPrimary("weaqpp", "name2", "name3", "name4", "name5", R.drawable.w_2313));
                        Log.d("weap primary name1", String.valueOf(db.getWeaponPrimaryById(1).getWpName1()));

                        db.addWeaponSecondary(new WeaponSecondary("weapse", "name2", "name3", "where", R.drawable.w_2313));
                        Log.d("weap secondary name1", String.valueOf(db.getWeaponSecondaryById(1).getWsName1()));

                        db.addWeekly(new Weekly("weekly", R.drawable.w_2313));
                        Log.d("weekly name", String.valueOf(db.getWeeklyById(1).getName()));

                        db.addFavorite(2);
                        Log.d("list id first", Integer.toString(db.getAllFavouriteCharacterId().get(0)));
                        dialog.dismiss();
                    }
                })
                .create().show();
//        db.addFavorite(2);
//        Log.d("list id first", Integer.toString(db.getAllFavouriteCharacterId().get(0)));
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }


    private void replace(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.commit();
    }
}