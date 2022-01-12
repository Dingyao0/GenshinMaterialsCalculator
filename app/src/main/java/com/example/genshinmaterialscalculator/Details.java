package com.example.genshinmaterialscalculator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class Details extends AppCompatActivity {
    Button details;
    ExpandableRelativeLayout mycontent;
    private TextView CharName, CharDetails, CharInGame, CharSpecial;
    private ImageView CharImg;
    private View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        layout = (View) findViewById(R.id.detailsBG);

        CharName = (TextView) findViewById(R.id.Name);
        CharDetails = (TextView) findViewById(R.id.details);
        CharSpecial = (TextView) findViewById(R.id.SDescriptionText);
        CharInGame = (TextView) findViewById(R.id.IDescriptionText);

        CharImg = (ImageView) findViewById(R.id.Image);

        // Receive data
        Intent intent = getIntent();
        String Name = intent.getExtras().getString("Name");
        String Rarity = intent.getExtras().getString("Rarity");
        String Details = intent.getExtras().getString("Details");
        String Special = intent.getExtras().getString("Special");
        String InGame = intent.getExtras().getString("InGame");
        int image = intent.getExtras().getInt("Image");

        Log.d("hi", Rarity);
        if (Rarity.equals("1-star")) {
            layout.setBackgroundColor(getColor(R.color.purple_200));
        }
        // Setting values
        CharName.setText(Name);
        CharDetails.setText(Details);
        CharSpecial.setText(Special);
        CharInGame.setText(InGame);
        CharImg.setImageResource(image);

    }

    public void show(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.details1:
                mycontent = (ExpandableRelativeLayout) findViewById(R.id.special);
                mycontent.toggle();
                break;
            case R.id.details2:
                mycontent = (ExpandableRelativeLayout) findViewById(R.id.inGame);
                mycontent.toggle();
                break;
            case R.id.moreDetails:
                Intent intent = new Intent(this, com.example.genshinmaterialscalculator.Webview.class);
                startActivity(intent);

                break;
        }

    }
}