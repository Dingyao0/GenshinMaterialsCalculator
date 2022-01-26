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
        setContentView(R.layout.webview);
        WebView mywebview = (WebView) findViewById(R.id.webView);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            codeText = extras.getString("key");
            //The key argument here must match that used in the other activity
        }
        String code=codeText;
//        String url = "https://genshin.honeyhunterworld.com/"+code;
        String url = "https://genshin.honeyhunterworld.com/db/weapon/"+code+"/?lang=EN";

        Log.d("hi",url);
        mywebview.loadUrl(url);
    }
}
