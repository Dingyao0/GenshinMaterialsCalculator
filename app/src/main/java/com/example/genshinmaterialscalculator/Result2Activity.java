package com.example.genshinmaterialscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
    private int[] talentMora = {0, 12500, 17500, 25000, 30000, 37500, 120000, 260000, 450000, 700000};
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
    private String rarity;
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

        String unit = "";
        float cMora2;
        int MoraLen = (int) (Math.log10(tMora) + 1); //number of digits
        if (MoraLen > 6) {
            cMora2 = tMora/1000000;
            unit = "M";
            moraTxt.setText(""+cMora2+unit);
        } else if (MoraLen > 3){
            cMora2 = tMora/1000;
            unit = "K";
            moraTxt.setText(""+cMora2+unit);
        } else {
            moraTxt.setText(""+tMora);
        }

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

        // View stuff
        View layout = (View) findViewById(R.id.bg);
        ImageView banner = (ImageView) findViewById(R.id.banner);
        //end

        rarity = c.getRarity();

        this.setCharBg(c.getName());
        this.setBossPic(w.getName());

        if(rarity.equals("5-star")){
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
        } else if(rarity.equals("4-star")){
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

    }

    public void onClick(View view) {
        Intent i = new Intent(this, Result1Activity.class);
        i.putExtra("region", region);
        i.putExtra("ascension", ascension); // ("key", value/data)
        i.putExtra("element", element);
        i.putExtra("charId", charId);
        i.putExtra("talent1Lvl", talent1Lvl);
        i.putExtra("talent2Lvl", talent2Lvl);
        i.putExtra("talent3Lvl", talent3Lvl);
        startActivity(i);
    }

    protected void setCharBg(String character) {
        ImageView pic2 = (ImageView) findViewById(R.id.pic2);
        if (character.equals("Amber")) {
            pic2.setImageDrawable(getResources().getDrawable(R.drawable.amber_bg));
            return;
        }
        if (character.equals("Arataki Itto")) {
            pic2.setImageDrawable(getResources().getDrawable(R.drawable.arataki_itto_bg));
            return;
        }
        if (character.equals("Eula")) {
            pic2.setImageDrawable(getResources().getDrawable(R.drawable.eula_bg));
            return;
        }
        if (character.equals("Hu Tao")) {
            pic2.setImageDrawable(getResources().getDrawable(R.drawable.hutao_bg));
            return;
        }
        if (character.equals("Raiden Shogun")) {
            pic2.setImageDrawable(getResources().getDrawable(R.drawable.raiden_shogun_bg));
            return;
        }
        if (character.equals("Rosaria")) {
            pic2.setImageDrawable(getResources().getDrawable(R.drawable.rosaria_bg));
        }
        if (character.equals("Sangonomiya Kokomi")) {
            pic2.setImageDrawable(getResources().getDrawable(R.drawable.kokomi_bg));
        }
        if (character.equals("Kaedehara Kazuha")) {
            pic2.setImageDrawable(getResources().getDrawable(R.drawable.kaedehara_kazuha_bg));
        }
    }

    protected void setBossPic (String item) {
        ImageView pic = (ImageView) findViewById(R.id.pic);
        if (item.equals("Ashen Heart") || item.equals("Molten Moment") || item.equals("Hellfire Butterfly")) {
            pic.setImageDrawable(getResources().getDrawable(R.drawable.signora));
            return;
        }
        if (item.equals("Dvalin's Plume") || item.equals("Dvalin's Claw") || item.equals("Dvalin's Sigh")) {
            pic.setImageDrawable(getResources().getDrawable(R.drawable.dvalin));
            return;
        }
        if (item.equals("Tail of Boreas") || item.equals("Ring of Boreas") || item.equals("Spirit Locket of Boreas")) {
            pic.setImageDrawable(getResources().getDrawable(R.drawable.wolf));
            return;
        }
        if (item.equals("Tusk of Monoceros Caeli") || item.equals("Shard of a Foul Legacy") || item.equals("Shadow of the Warrior")) {
            pic.setImageDrawable(getResources().getDrawable(R.drawable.childe));
            return;
        }
        if (item.equals("Dragon Lord's Crown") || item.equals("Bloodjade Branch") || item.equals("Gilded Scale")) {
            pic.setImageDrawable(getResources().getDrawable(R.drawable.azhdaha));
            return;
        }

    }

}
