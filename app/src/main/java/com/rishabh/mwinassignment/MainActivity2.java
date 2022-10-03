package com.rishabh.mwinassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity2 extends AppCompatActivity {

    private WebView webView;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        message = intent.getStringExtra("url");

        CustomWebViewClient client = new CustomWebViewClient(this);

        webView = findViewById(R.id.webView);
        webView.setWebViewClient(client);

        //getSettings sets the javascript of website

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(message);

//        alert(webView.getUrl());
    }

//    public void alert(String url){
//        if(!url.contains(message)){
//            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
//            builder.setMessage("You are going outside domain URL");
//            builder.setTitle("Alert!!");
//
//            AlertDialog alertDialog = builder.create();
//            alertDialog.show();
//        }
//    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK && this.webView.canGoBack()){
            this.webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

// this is to show the clicked links on same activity

class CustomWebViewClient extends WebViewClient {

    private Activity activity;
    public CustomWebViewClient(Activity activity){
        this.activity = activity;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url){
        return false;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest request){
        return false;
    }
}