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

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);

        if (firstStart == true) {
            firstTime();
        }

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

                        db.addCharacter(new Character("Amber", "Pyro", "Bow", "793", "19", "50", R.drawable.atk_pct, "0", "12",
                                "12", R.drawable.amber, "amber", "4-star", "sdescriptionasd",
                                "Always energetic and full of life, Amber's the best — albeit only — Outrider of the Knights of Favonius.", "Mondstadt", R.drawable.sharpshooter, R.drawable.explosive_puppet, R.drawable.fiery_rain, R.drawable.amberbanner,
                                1, 1, 1, 1, 1));

                        db.addCharacter(new Character("Arataki Itto", "Geo", "Claymore", "1001", "18", "75", R.drawable.cr, "5", "12",
                                "12", R.drawable.itto, "itto", "5-star", "sdescriptionasd",
                                " The first and greatest head of the Arataki Gang, famed throughout Inazuma City's Hanamizaka... Wait, what? You've never heard of them? Are you trying to be funny here?", "Inazuma", R.drawable.fight_club_legend, R.drawable.masatsu_zetsugi_akaushi_burst, R.drawable.royal_descent_behold_itto_the_evil, R.drawable.ittobanner,
                                4, 4, 4, 4, 4));

                        db.addCharacter(new Character("Eula", "Cryo", "Claymore", "1030", "27", "58", R.drawable.cd, "50", "12",
                                "12", R.drawable.eula, "eula", "5-star", "sdescriptionasd",
                                " The Spindrift Knight, a scion of the old aristocracy, and the Captain of the Knights of Favonius Reconnaissance Company. The reason for which a descendant of the ancient nobles might join the Knights remains a great mystery in Mondstadt to this very day.", "Mondstadt", R.drawable.favonius_bladework_edel, R.drawable.icetide_vortex, R.drawable.glacial_illumination, R.drawable.eulabanner,
                                2, 2, 2, 2, 2));

                        db.addCharacter(new Character("Hu Tao", "Pyro", "Polearm", "1211", "8", "68", R.drawable.cd, "50", "12",
                                "12", R.drawable.hutao, "hutao", "5-star", "sdescriptionasd",
                                " The 77th Director of the Wangsheng Funeral Parlor. She took over the business at a rather young age.", "Liyue", R.drawable.secret_spear_of_wangsheng, R.drawable.guide_to_afterlife, R.drawable.spirit_soother, R.drawable.hutaobanner,
                                3, 3, 3, 3, 3));

                        db.addCharacter(new Character("Raiden Shogun", "Electro", "Polearm", "1005", "26", "61", R.drawable.em, "0", "12",
                                "12", R.drawable.shougun, "shougun", "5-star", "sdescriptionasd",
                                " Her Excellency, the Almighty Narukami Ogosho, who promised the people of Inazuma an unchanging Eternity.", "Inazuma", R.drawable.origin, R.drawable.transcendence_baleful_omen, R.drawable.secret_art_musou_shinsetsu, R.drawable.raiden_shogun,
                                5, 5, 5, 5, 5));

                        db.addCharacter(new Character("Rosaria", "Cryo", "Polearm", "1030", "20", "60", R.drawable.atk_pct, "0", "12",
                                "12", R.drawable.rosaria, "rosaria", "4-star", "sdescriptionasd",
                                " A sister of the church, though you wouldn't know it if it weren't for her attire. Known for her sharp, cold words and manner, she often works alone..", "Mondstadt", R.drawable.spear_of_the_church, R.drawable.ravaging_confession, R.drawable.rites_of_termination, R.drawable.rosariabanner,
                                6, 6, 6, 6, 6));

                        db.addCharacter(new Character("Sangonomiya Kokomi", "Hydro", "Catalyst", "1049", "18", "51", R.drawable.atk_pct, "0", "12",
                                "12", R.drawable.kokomi, "kokomi", "5-star", "sdescriptionasd",
                                " The Divine Priestess of Watatsumi Island. All of the island's affairs are at this young lady's fingertips.", "Inazuma",R.drawable.the_shape_of_water, R.drawable.kurage_oath, R.drawable.nereid_ascension, R.drawable.kokomibanner,
                                7, 7, 7, 7, 7));

                        db.addCharacter(new Character("Kaedehara Kazuha", "Anemo", "Sword", "1039", "23", "63", R.drawable.atk_pct, "0", "12",
                                "12", R.drawable.kazuha, "kazuha", "5-star", "sdescriptionasd",
                                " A wandering samurai from Inazuma who is currently with Liyue's Crux Fleet. A gentle and carefree soul whose heart hides a great many burdens from the past.", "Inazuma", R.drawable.garyuu_bladework, R.drawable.chihayaburu, R.drawable.kazuha_slash, R.drawable.kazuhabanner,
                                8, 8, 3, 8, 8));

                        Log.d("character name", String.valueOf(db.getCharacterById(1).getName()));


                        db.addCharacterLocal(new CharacterLocal("Small Lamp Grass", "Mondstadt", R.drawable.small_lamp_grass));
                        db.addCharacterLocal(new CharacterLocal("Dandelion Seed","Mondstadt", R.drawable.dandelion_seed));
                        db.addCharacterLocal(new CharacterLocal("Silk Flower", "Li Yue", R.drawable.silk_flower));
                        db.addCharacterLocal(new CharacterLocal("Onikabuto","Inazuma", R.drawable.onikabuto));
                        db.addCharacterLocal(new CharacterLocal("Valberry","Mondstadt", R.drawable.valberry));
                        db.addCharacterLocal(new CharacterLocal("Amakumo Fruit","Inazuma",R.drawable.amakumo_fruit));
                        db.addCharacterLocal(new CharacterLocal("Sango Pearl","Inazuma",R.drawable.sango_pearl));
                        db.addCharacterLocal(new CharacterLocal("Sea Ganoderma", "Inazuma", R.drawable.sea_ganoderma));
                        Log.d("characterLocal name1", String.valueOf(db.getCharacterLocalById(1).getClName()));

                        db.addCharacterPrimary(new CharacterPrimary("Teachings Of Freedom", "Guide To Freedom", "Philosophies Of Freedom", "domain", R.drawable.teachings_of_freedom, R.drawable.guide_to_freedom, R.drawable.philosophies_of_freedom));
                        db.addCharacterPrimary(new CharacterPrimary("Teachings Of Resistance", "Guide To Resistance", "Philosophies Of Resistance", "domain", R.drawable.teachings_of_resistance, R.drawable.guide_to_resistance, R.drawable.philosophies_of_resistance));
                        db.addCharacterPrimary(new CharacterPrimary("Teachings Of Diligence", "Guide To Diligence", "Philosophies Of Diligence", "domain", R.drawable.teachings_of_diligence, R.drawable.guide_to_diligence, R.drawable.philosophies_of_diligence));
                        db.addCharacterPrimary(new CharacterPrimary("Teachings Of Elegance", "Guide To Elegance", "Philosophies Of Elegance", "domain", R.drawable.teachings_of_elegance, R.drawable.guide_to_elegance, R.drawable.philosophies_of_elegance));
                        db.addCharacterPrimary(new CharacterPrimary("Teachings Of Ballad", "Guide To Ballad", "Philosophies Of Ballad", "domain", R.drawable.teachings_of_ballad, R.drawable.guide_to_ballad, R.drawable.philosophies_of_ballad));
                        db.addCharacterPrimary(new CharacterPrimary("Teachings Of Light", "Guide To Light", "Philosophies Of Light", "domain", R.drawable.teachings_of_light, R.drawable.guide_to_light, R.drawable.philosophies_of_light));
                        db.addCharacterPrimary(new CharacterPrimary("Teachings Of Transience", "Guide To Transience", "Philosophies Of Transience", "domain", R.drawable.teachings_of_transience, R.drawable.guide_to_transience, R.drawable.philosophies_of_transience));
                        Log.d("characterPrimary name1", String.valueOf(db.getCharacterPrimaryById(1).getCpName1()));

                        db.addCharacterSecondary(new CharacterSecondary("Firm Arrowhead", "Sharp Arrowhead", "Weathered Arrowhead", "wherer", R.drawable.firm_arrowhead, R.drawable.sharp_arrowhead, R.drawable.weathered_arrowhead));
                        db.addCharacterSecondary(new CharacterSecondary("Damaged Mask", "Stained Mask", "Ominous Mask", "wherer", R.drawable.damaged_mask, R.drawable.stained_mask, R.drawable.ominous_mask));
                        db.addCharacterSecondary(new CharacterSecondary("Whopperflower Nectar","Shimmering Nectar","Energy Nectar","wherer",R.drawable.whopperflower_nectar, R.drawable.shimmering_nectar, R.drawable.energy_nectar));
                        db.addCharacterSecondary(new CharacterSecondary("Slime Secretion","Slime Condensate","Slime concentrate","wherer", R.drawable.slime_secretions, R.drawable.slime_condensate, R.drawable.slime_concentrate));
                        db.addCharacterSecondary(new CharacterSecondary("Recruit's Insignia","Sergeant's Insignia","Lieutenant's Insignia","wherer", R.drawable.recruit_insignia, R.drawable.sergeant_insignia, R.drawable.lieutenant_insignia));
                        db.addCharacterSecondary(new CharacterSecondary("Old Handguard","Kageuchi Handguard","Famed Handguard","wherer", R.drawable.old_handguard, R.drawable.kageuchi_handguard, R.drawable.famed_handguard));
                        db.addCharacterSecondary(new CharacterSecondary("Spectral Husk","Spectral Heart","Spectral Nucleus","wherer",R.drawable.spectral_husk, R.drawable.spectral_heart, R.drawable.spectral_nucleus));
                        db.addCharacterSecondary(new CharacterSecondary("Treasure Hoarder Insignia","Silver Raven Insignia","Golden Raven Insignia","wherer", R.drawable.treasure_hoarder_insignia, R.drawable.silver_raven_insignia, R.drawable.golden_raven_insignia));
                        Log.d("characterSecondary name1", String.valueOf(db.getCharacterSecondaryById(1).getCseName1()));

                        db.addCharacterStone(new CharacterStone("Everflame Seed", R.drawable.everflame_seed));
                        db.addCharacterStone(new CharacterStone("Crystalline Bloom", R.drawable.crystalline_bloom));
                        db.addCharacterStone(new CharacterStone("Juvenile Jade", R.drawable.juvenile_jade));
                        db.addCharacterStone(new CharacterStone("Riftborn Regalia", R.drawable.riftborn_regalia));
                        db.addCharacterStone(new CharacterStone("Storm Beads", R.drawable.storm_beads));
                        db.addCharacterStone(new CharacterStone("Hoarfrost Core", R.drawable.hoarfrost_core));
                        db.addCharacterStone(new CharacterStone("Dew Of Repudiation", R.drawable.dew_of_repudiation));
                        db.addCharacterStone(new CharacterStone("Marionette Core", R.drawable.marionette_core));
                        Log.d("characterStone name", String.valueOf(db.getCharacterStoneById(1).getCstName()));


                        db.addWeaponPrimary(new WeaponPrimary("weaqpp", "name2", "name3", "name4", "name5", R.drawable.tile_of_decarabians_tower, R.drawable.debris_of_decarabians_city, R.drawable.fragment_of_decarabians_epic, R.drawable.scattered_piece_of_decarabians_dream));
                        Log.d("weap primary name1", String.valueOf(db.getWeaponPrimaryById(1).getWpName1()));

                        db.addWeaponSecondary(new WeaponSecondary("weapse", "name2", "name3", "where", R.drawable.firm_arrowhead, R.drawable.sharp_arrowhead, R.drawable.weathered_arrowhead));
                        Log.d("weap secondary name1", String.valueOf(db.getWeaponSecondaryById(1).getWsName1()));

                        db.addWeekly(new Weekly("Dvalin's Sigh", R.drawable.dvalins_sigh));
                        db.addWeekly(new Weekly("Dragon Lord's Crown",R.drawable.dragon_lords_crown));
                        db.addWeekly(new Weekly("Shard Of A Foul Legacy", R.drawable.shard_of_a_foul_legacy));
                        db.addWeekly(new Weekly("Ashen Heart", R.drawable.ashen_heart));
                        db.addWeekly(new Weekly("Molten Moment", R.drawable.molten_moment));
                        db.addWeekly(new Weekly("Shadow of the Warrior", R.drawable.shadow_of_the_warrior));
                        db.addWeekly(new Weekly("Hellfire Butterfly", R.drawable.hellfire_butterfly));
                        db.addWeekly(new Weekly("Gilded Scale", R.drawable.gilded_scale));
                        Log.d("weekly name", String.valueOf(db.getWeeklyById(1).getName()));

//                        db.addFavorite(2);
//                        Log.d("list id first", Integer.toString(db.getAllFavouriteCharacterId().get(0)));
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