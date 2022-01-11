package com.example.genshinmaterialscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class Details extends AppCompatActivity {
    Button details;
    ExpandableRelativeLayout mycontent;
    private TextView CharName,CharDescription;
    private ImageView CharImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        CharName = (TextView) findViewById(R.id.Name);
        CharDescription = (TextView) findViewById(R.id.basic);
        CharImg = (ImageView) findViewById(R.id.Image);

        // Receive data
        Intent intent = getIntent();
        String Name = intent.getExtras().getString("Title");
        String Code = intent.getExtras().getString("Code");
        String Description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Image");

        // Setting values
        CharName.setText(Name);
        CharDescription.setText(Description);
        CharImg.setImageResource(image);
    }

    public void show(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.details1:
                mycontent = (ExpandableRelativeLayout) findViewById(R.id.mycontent);
                mycontent.toggle();
                break;
            case R.id.details2:
                mycontent = (ExpandableRelativeLayout) findViewById(R.id.mycontent2);
                mycontent.toggle();
                break;
            case R.id.moreDetails:
                Intent intent = new Intent(this, com.example.genshinmaterialscalculator.Webview.class);
                startActivity(intent);

                /*Intent intent = new Intent(mContext, Details.class);

                // passing data to the book activity
                intent.putExtra("Title", mData.get(position).getTitle());
                intent.putExtra("Description", mData.get(position).getDescription());
                intent.putExtra("Image", mData.get(position).getThumbnail());
                // start the activity
                mContext.startActivity(intent);*/
                break;
        }

    }
}