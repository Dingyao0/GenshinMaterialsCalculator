package com.example.genshinmaterialscalculator;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class Result1Activity extends AppCompatActivity {

    //Variables for calculation
    private int ascension; //max 7
    private String element;
    private String charName;

    //calculation
    private int[] mora = {24200, 160000, 316000, 547000, 866200, 1288600, 2093400};
    private int[] talentMora = {0, 12500, 30000, 280000, 580000, 617500, 737500, 997500, 1447500};


    //Variables for results
    private int reqMora;
    private String bookName;
    private int amoBook1;
    private int amoBook2;
    private int amoBook3;
    private int stone1;
    private int stone2;
    private int stone3;
    private int stone4;
    private int bossMatNum;
    private int localMatNum;
    private int[] charLvlMat = {0, 0, 0};
    private int crown = 0;

    //Miscellaneous Variables
    private String region;

    //Drawables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result1);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String region = extras.getString("region"); //bg
            int ascension = extras.getInt("ascension"); //needed for calculation
            String element = extras.getString("element"); //stone type
            String charName = extras.getString("charName"); //get talent books, get local mat, get boss mat
            int talent1Lvl = extras.getInt("talent1Lvl"); //needed for calculation
            int talent2Lvl = extras.getInt("talent2Lvl"); //needed for calculation
            int talent3Lvl = extras.getInt("talent3Lvl"); //needed for calculation
            //The key argument here must match that used in the other activity
        }

        //Ascension calculation
        stone1 = 0;
        bossMatNum = 0;
        localMatNum = 0;
        if (ascension >= 2) {
            stone1 += 1;
            localMatNum += 3;
            charLvlMat[0] += 3;
        }
        if (ascension >= 3) {
            stone2 += 3;
            bossMatNum += 2;
            localMatNum += 10;
            charLvlMat[0] += 15;

        }
        if (ascension >= 4) {
            stone2 += 6;
            bossMatNum += 4;
            localMatNum += 20;
            charLvlMat[1] += 12;
        }
        if (ascension >= 5) {
            stone3 += 3;
            bossMatNum += 8;
            localMatNum += 30;
            charLvlMat[1] += 18;
        }
        if (ascension >= 6) {
            stone3 += 6;
            bossMatNum += 12;
            localMatNum += 45;
            charLvlMat[2] += 12;
        }
        if (ascension >= 7) {
            stone4 += 6;
            bossMatNum += 20;
            localMatNum += 60;
            charLvlMat[2] += 24;
            crown += 1;
        }
        //End of ascension calculation
    }


}
