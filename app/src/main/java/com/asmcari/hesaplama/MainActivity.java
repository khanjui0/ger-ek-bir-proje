package com.asmcari.hesaplama;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Insets;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

    private static final int ANA_RENK = 0xFF1E6B5C;

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout kok = new FrameLayout(this);
        kok.setBackgroundColor(ANA_RENK);

        webView = new WebView(this);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        // Girilen rakamlar localStorage'da tutulur, uygulama kapansa da kaybolmaz.
        settings.setDomStorageEnabled(true);
        // confirm() pencerelerinin çalışması için gerekli.
        webView.setWebChromeClient(new WebChromeClient());
        // Sadece uygulamanın kendi sayfası yüklenir (internet izni yok), köprü güvenli.
        webView.addJavascriptInterface(new Kopru(), "Android");

        kok.addView(webView, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        setContentView(kok);
        sistemCubuklariniAyarla(kok);

        webView.loadUrl("file:///android_asset/index.html");
    }

    // Android 15+ uygulamayı kenardan kenara çizer; içerik durum çubuğu ve klavyenin altında kalmasın.
    private void sistemCubuklariniAyarla(FrameLayout kok) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getWindow().setDecorFitsSystemWindows(false);
            kok.setOnApplyWindowInsetsListener((v, insets) -> {
                Insets bosluk = insets.getInsets(WindowInsets.Type.systemBars()
                        | WindowInsets.Type.displayCutout()
                        | WindowInsets.Type.ime());
                v.setPadding(bosluk.left, bosluk.top, bosluk.right, bosluk.bottom);
                return WindowInsets.CONSUMED;
            });
            WindowInsetsController kontrol = getWindow().getInsetsController();
            if (kontrol != null) {
                kontrol.setSystemBarsAppearance(0, WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
                        | WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS);
            }
        } else {
            getWindow().setStatusBarColor(ANA_RENK);
            getWindow().setNavigationBarColor(ANA_RENK);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        webView.evaluateJavascript("window.kaydet && window.kaydet()", null);
    }

    private class Kopru {
        @JavascriptInterface
        public void paylas(String metin) {
            Intent gonder = new Intent(Intent.ACTION_SEND);
            gonder.setType("text/plain");
            gonder.putExtra(Intent.EXTRA_TEXT, metin);
            startActivity(Intent.createChooser(gonder, "Sonucu paylaş"));
        }
    }
}
