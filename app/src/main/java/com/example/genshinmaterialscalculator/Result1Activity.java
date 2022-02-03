package com.example.genshinmaterialscalculator;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result1Activity extends AppCompatActivity {

    //Variables for calculation
    private int ascension; //max 7
    private String element;
    private int charId;
    private int talent1Lvl;
    private int talent2Lvl;
    private int talent3Lvl;

    //calculation
    private int[] charMora = {24200, 160000, 316000, 547000, 866200, 1288600, 2093400};

    //Variables for results
    private int cMora;
    private int stone1;
    private int stone2;
    private int stone3;
    private int stone4;
    private int bossName;
    private int bossMatNum;
    private int localMatNum;
    private int[] charLvlMat = {0, 0, 0};

    //Miscellaneous Variables
    private String region;
    private String rarity;
    Character c;
    CharacterLocal cl;
    CharacterSecondary cs;
    CharacterStone cBoss;
    private int Stone1id;
    private int Stone2id;
    private int Stone3id;
    private int Stone4id;
    ImageView bossMatimg, charMat1Img, charMat2Img, charMat3Img, moraImg;
    TextView bossMattxt, charMat1, charMat2, charMat3;

    //Drawables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results1);

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
        }

        // db
        DatabaseHandler dbHandler = new DatabaseHandler(this);
        c = dbHandler.getCharacterById(charId);
        cl = dbHandler.getCharacterLocalById(c.getCharacterLocalId());
        cs = dbHandler.getCharacterSecondaryById(c.getCharacterSecondaryId());
        cBoss = dbHandler.getCharacterStoneById(c.getCharacterStoneId());
        rarity = c.getRarity();

        //Ascension calculation
        stone1 = 0;
        bossMatNum = 0;
        localMatNum = 0;
        if (ascension >= 2) {
            stone1 += 1;
            localMatNum += 3;
            charLvlMat[0] += 3;
            cMora += charMora[0];
            cMora += charMora[1];
        }
        if (ascension >= 3) {
            stone2 += 3;
            bossMatNum += 2;
            localMatNum += 10;
            charLvlMat[0] += 15;
            cMora += charMora[2];
        }
        if (ascension >= 4) {
            stone2 += 6;
            bossMatNum += 4;
            localMatNum += 20;
            charLvlMat[1] += 12;
            cMora += charMora[3];
        }
        if (ascension >= 5) {
            stone3 += 3;
            bossMatNum += 8;
            localMatNum += 30;
            charLvlMat[1] += 18;
            cMora += charMora[4];
        }
        if (ascension >= 6) {
            stone3 += 6;
            bossMatNum += 12;
            localMatNum += 45;
            charLvlMat[2] += 12;
            cMora += charMora[5];
        }
        if (ascension >= 7) {
            stone4 += 6;
            bossMatNum += 20;
            localMatNum += 60;
            charLvlMat[2] += 24;
            cMora += charMora[6];
        }
        //End of ascension calculation

        //char Mat text and image
        charMat1 = (TextView)findViewById(R.id.charMat1);
        charMat2 = (TextView)findViewById(R.id.charMat2);
        charMat3 = (TextView)findViewById(R.id.charMat3);
        charMat1Img = (ImageView)findViewById(R.id.charMat1Img);
        charMat2Img = (ImageView)findViewById(R.id.charMat2Img);
        charMat3Img = (ImageView)findViewById(R.id.charMat3Img);

        //set text and image
        charMat1.setText("x"+charLvlMat[0]);
        charMat2.setText("x"+charLvlMat[1]);
        charMat3.setText("x"+charLvlMat[2]);

        charMat1Img.setImageDrawable(getResources().getDrawable(cs.getCseImage1()));
        charMat2Img.setImageDrawable(getResources().getDrawable(cs.getCseImage2()));
        charMat3Img.setImageDrawable(getResources().getDrawable(cs.getCseImage3()));

        //Char Mora to text conversion
        String unit = "";
        float cMora2;
        TextView cMoraTxt = (TextView)findViewById(R.id.cMora);
        moraImg = (ImageView) findViewById(R.id.mora);
        moraImg.setImageDrawable(getResources().getDrawable(R.drawable.mora));
        int MoraLen = (int) (Math.log10(cMora) + 1); //number of digits
        if (MoraLen > 6) {
            cMora2 = cMora/1000000;
            unit = "M";
            cMoraTxt.setText(""+cMora2+unit);
        } else if (MoraLen > 3){
            cMora2 = cMora/1000;
            unit = "K";
            cMoraTxt.setText(""+cMora2+unit);
        } else {
            cMoraTxt.setText(""+cMora);
        }

        // LocalMat set text
        TextView localMatTxt = (TextView) findViewById(R.id.LocalMat);
        localMatTxt.setText("x"+localMatNum);

        // Stone setText
        TextView stone1txt = (TextView) findViewById(R.id.stone1);
        TextView stone2txt = (TextView) findViewById(R.id.stone2);
        TextView stone3txt = (TextView) findViewById(R.id.stone3);
        TextView stone4txt = (TextView) findViewById(R.id.stone4);
        ImageView stone1img = (ImageView) findViewById(R.id.stone1Img);
        ImageView stone2img = (ImageView) findViewById(R.id.stone2Img);
        ImageView stone3img = (ImageView) findViewById(R.id.stone3Img);
        ImageView stone4img = (ImageView) findViewById(R.id.stone4Img);

        stone1txt.setText("x"+stone1);
        stone2txt.setText("x"+stone2);
        stone3txt.setText("x"+stone3);
        stone4txt.setText("x"+stone4);

        //set drawable according to element
        this.getStoneByElement(element);

        stone1img.setImageDrawable(getResources().getDrawable(Stone1id));
        stone2img.setImageDrawable(getResources().getDrawable(Stone2id));
        stone3img.setImageDrawable(getResources().getDrawable(Stone3id));
        stone4img.setImageDrawable(getResources().getDrawable(Stone4id));

        // Boss Mat TODO: Change image to boss image
        bossMattxt = (TextView) findViewById(R.id.bossMat);
        bossMatimg = (ImageView) findViewById(R.id.bossMatImg);
        bossMattxt.setText("x"+bossMatNum);

        // View stuff
        View layout = (View) findViewById(R.id.bg);
        ImageView banner = (ImageView) findViewById(R.id.banner);
        //end

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
        Intent i = new Intent(this, Result2Activity.class);
        i.putExtra("region", region);
        i.putExtra("ascension", ascension); // ("key", value/data)
        i.putExtra("element", element);
        i.putExtra("charId", charId);
        i.putExtra("talent1Lvl", talent1Lvl);
        i.putExtra("talent2Lvl", talent2Lvl);
        i.putExtra("talent3Lvl", talent3Lvl);
        startActivity(i);
    }

    protected void getStoneByElement(String e) {
        switch (e) {
            case "Pyro":
                Stone1id = R.drawable.agnidus_agate_sliver;
                Stone2id = R.drawable.agnidus_agate_fragment;
                Stone3id = R.drawable.agnidus_agate_chunk;
                Stone4id = R.drawable.agnidus_agate_gemstone;
                return;
            case "Geo":
                Stone1id = R.drawable.prithiva_topaz_sliver;
                Stone2id = R.drawable.prithiva_topaz_fragment;
                Stone3id = R.drawable.prithiva_topaz_chunk;
                Stone4id = R.drawable.prithiva_topaz_gemstone;
                return;
            case "Hydro":
                Stone1id = R.drawable.varunada_lazurite_sliver;
                Stone2id = R.drawable.varunada_lazurite_fragment;
                Stone3id = R.drawable.varunada_lazurite_chunk;
                Stone4id = R.drawable.varunada_lazurite_gemstone;
                return;
            case "Electro":
                Stone1id = R.drawable.vajrada_amethyst_sliver;
                Stone2id = R.drawable.vajrada_amethyst_fragment;
                Stone3id = R.drawable.vajrada_amethyst_chunk;
                Stone4id = R.drawable.vajrada_amethyst_gemstone;
                return;
            case "Cryo":
                Stone1id = R.drawable.shivada_jade_sliver;
                Stone2id = R.drawable.shivada_jade_fragment;
                Stone3id = R.drawable.shivada_jade_chunk;
                Stone4id = R.drawable.shivada_jade_gemstone;
                return;
            case "Dendro":
                Stone1id = R.drawable.vayuda_turquoise_sliver;
                Stone2id = R.drawable.vayuda_turquoise_fragment;
                Stone3id = R.drawable.vayuda_turquoise_chunk;
                Stone4id = R.drawable.vayuda_turquoise_gemstone;
                return;
        }
    }


}
