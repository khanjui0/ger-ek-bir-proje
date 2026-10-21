package com.ortakhesap;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        // Girilen rakamlar localStorage'da tutulur, uygulama kapansa da kaybolmaz.
        settings.setDomStorageEnabled(true);
        // confirm() pencerelerinin çalışması için gerekli.
        webView.setWebChromeClient(new WebChromeClient());
        setContentView(webView);
        webView.loadUrl("file:///android_asset/index.html");
    }

    @Override
    protected void onPause() {
        super.onPause();
        webView.evaluateJavascript("window.kaydet && window.kaydet()", null);
    }
}
