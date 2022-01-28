package com.example.genshinmaterialscalculator;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class Webview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String codeText = null;
        String typeText = null;
        setContentView(R.layout.webview);
        WebView mywebview = (WebView) findViewById(R.id.webView);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            codeText = extras.getString("key");
            typeText = extras.getString("type");
            //The key argument here must match that used in the other activity
        }
        String code = codeText;
        String type = typeText;
        if (type.equals("Character")) {
            String url = "https://genshin.honeyhunterworld.com/db/char/" + code + "/?lang=EN";
            Log.d("hi", url);
            mywebview.loadUrl(url);
        } else if (type.equals("Weapons")) {
            String url = "https://genshin.honeyhunterworld.com/db/weapon/" + code + "/?lang=EN";
            Log.d("hi", url);
            mywebview.loadUrl(url);
        }

    }
}
