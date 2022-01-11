package com.example.genshinmaterialscalculator;

import static android.widget.Toast.makeText;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageButton androidImageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidImageButton=(ImageButton)findViewById(R.id.btnFav1);
        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeText(MainActivity.this, "Btn1", Toast.LENGTH_SHORT).show();
            }
        });
        androidImageButton=(ImageButton)findViewById(R.id.btnFav2);
        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeText(MainActivity.this, "Btn2", Toast.LENGTH_SHORT).show();
            }
        });
        androidImageButton=(ImageButton)findViewById(R.id.btnFav3);
        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeText(MainActivity.this, "Btn3", Toast.LENGTH_SHORT).show();
            }
        });
    }
}