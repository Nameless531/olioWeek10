package com.example.olioweek10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    WebView web;
    EditText urlBar;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.canGoBackOrForward(10);
        urlBar = (EditText) findViewById(R.id.urlBar);
    }
    public void openWeb(View v) {
        if (String.valueOf(urlBar.getText()).equals("index.html")) {
            web.loadUrl("file:///android_asset/index.html");
        } else {
            url = "http://" + urlBar.getText();
            web.loadUrl(url);
        }
    }
    public void refresh(View v) {
        web.loadUrl(web.getUrl());
    }
    public void shoutOut(View v) {
        web.evaluateJavascript("javascript:shoutOut()", null);
    }
    public void initialize(View v) {
        web.evaluateJavascript("javascript:initialize()", null);
    }
    public void goBack(View v) {
        web.goBack();
    }
    public void goForward(View v) {
        web.goForward();
    }
}