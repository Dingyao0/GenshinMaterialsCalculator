package com.example.genshinmaterialscalculator;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result2Activity extends AppCompatActivity {

    //Intent
    private String region;
    private int ascension; //max 7
    private String element;
    private int charId;
    private int talent1Lvl;
    private int talent2Lvl;
    private int talent3Lvl;

    //calculation
    private int[] talentMora = {0, 12500, 30000, 280000, 580000, 617500, 737500, 997500, 1447500};
    private int[] talentAmt1 = {0,3,0,0,0,0,0,0,0,0};
    private int[] talentAmt2 = {0,0,2,4,6,9,0,0,0,0};
    private int[] talentAmt3 = {0,0,0,0,0,0,4,6,12,16};
    private int[] charAmt1 = {0,6,0,0,0,0,0,0,0,0};
    private int[] charAmt2 = {0,0,3,4,6,9,0,0,0,0};
    private int[] charAmt3 = {0,0,0,0,0,0,4,6,9,12};
    private int[] bossMatC = {0,0,0,0,0,0,1,1,2,2};
    private int[] crownAmt = {0,0,0,0,0,0,0,0,0,1};

    //Results
    private int tMora;
    private String bookName; //database
    private int amoBook1;
    private int amoBook2;
    private int amoBook3;
    private int[] talentLvlMat = {0, 0, 0};
    private int crown = 0;
    private int bossMatAmt;

    //Misc
    private int[] talentLvl;
    ImageView bossImg, book1Img, book2Img, book3Img, moraImg, crownImg, char1Img, char2Img, char3Img, bossIcon;
    TextView bossTxt, book1Txt, book2Txt, book3Txt, moraTxt, crownTxt, char1Txt, char2Txt, char3Txt;
    Weekly w;
    Character c;
    CharacterSecondary cs;
    CharacterPrimary b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results2);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            region = extras.getString("region"); //bg
            ascension = extras.getInt("ascension"); //needed for calculation
            element = extras.getString("element"); //stone type
            charId = extras.getInt("charId"); //get talent books, get local mat, get boss mat
            talent1Lvl = extras.getInt("talent1Lvl"); //needed for calculation
            talent2Lvl = extras.getInt("talent2Lvl"); //needed for calculation
            talent3Lvl = extras.getInt("talent3Lvl"); //needed for calculation
            //The key argument here must match that used in the other activity
            talentLvl = new int[]{talent1Lvl, talent2Lvl, talent3Lvl};
        }

        //talent mat calculation
        for (int i = 0; i < talentLvl.length; i++) {
            for (int j = 0; j < talentLvl[i]; j++) {
                tMora += talentMora[j];
                amoBook1 += talentAmt1[j];
                amoBook2 += talentAmt2[j];
                amoBook3 += talentAmt3[j];
                talentLvlMat[0] += charAmt1[j];
                talentLvlMat[1] += charAmt2[j];
                talentLvlMat[2] += charAmt3[j];
                bossMatAmt += bossMatC[j];
                crown += crownAmt[j];
            }
        }

        moraImg = (ImageView) findViewById(R.id.mora);
        moraTxt = (TextView) findViewById(R.id.tMora);
        moraImg.setImageDrawable(getResources().getDrawable(R.drawable.mora));
        moraTxt.setText("x"+tMora);// TODO: change mora to float

        DatabaseHandler dbHandler = new DatabaseHandler(this);
        c = dbHandler.getCharacterById(charId);
        b = dbHandler.getCharacterPrimaryById(c.getCharacterPrimaryId());
        w = dbHandler.getWeeklyById(c.getWeeklyBossId());
        cs = dbHandler.getCharacterSecondaryById(c.getCharacterSecondaryId());

        //Weekly
        bossImg = (ImageView) findViewById(R.id.bossMatImg);
        bossTxt = (TextView) findViewById(R.id.bossMat);
        bossImg.setImageDrawable(getResources().getDrawable(w.getImage()));
        bossTxt.setText("x"+bossMatAmt);

        //Books
        book1Img = (ImageView) findViewById(R.id.book1Img);
        book2Img = (ImageView) findViewById(R.id.book2Img);
        book3Img = (ImageView) findViewById(R.id.book3Img);
        book1Txt = (TextView) findViewById(R.id.book1);
        book2Txt = (TextView) findViewById(R.id.book2);
        book3Txt = (TextView) findViewById(R.id.book3);

        book1Img.setImageDrawable(getResources().getDrawable(b.getCpImage1()));
        book2Img.setImageDrawable(getResources().getDrawable(b.getCpImage2()));
        book3Img.setImageDrawable(getResources().getDrawable(b.getCpImage3()));
        book1Txt.setText("x"+amoBook1);
        book2Txt.setText("x"+amoBook2);
        book3Txt.setText("x"+amoBook3);

        //Materials
        char1Img = (ImageView) findViewById(R.id.charMat1Img);
        char2Img = (ImageView) findViewById(R.id.charMat2Img);
        char3Img = (ImageView) findViewById(R.id.charMat3Img);
        char1Txt = (TextView) findViewById(R.id.charMat1);
        char2Txt = (TextView) findViewById(R.id.charMat2);
        char3Txt = (TextView) findViewById(R.id.charMat3);

        char1Img.setImageDrawable(getResources().getDrawable(cs.getCseImage1()));
        char2Img.setImageDrawable(getResources().getDrawable(cs.getCseImage2()));
        char3Img.setImageDrawable(getResources().getDrawable(cs.getCseImage3()));
        char1Txt.setText("x"+talentLvlMat[0]);
        char2Txt.setText("x"+talentLvlMat[1]);
        char3Txt.setText("x"+talentLvlMat[2]);

        //Crown
        crownImg = (ImageView) findViewById(R.id.crownImg);
        crownTxt = (TextView) findViewById(R.id.crownTxt);

        crownImg.setImageDrawable(getResources().getDrawable(R.drawable.crown_of_insight));
        crownTxt.setText("x"+crown);

    }



}
