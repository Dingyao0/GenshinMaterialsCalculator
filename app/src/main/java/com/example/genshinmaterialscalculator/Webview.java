package com.example.genshinmaterialscalculator;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class Webview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        WebView mywebview = (WebView) findViewById(R.id.webView);

        String url = "https://genshin.honeyhunterworld.com/db/weapon/w_1101/?lang=EN";
        Log.d("hi",url);
        mywebview.loadUrl(url);
    }
}
