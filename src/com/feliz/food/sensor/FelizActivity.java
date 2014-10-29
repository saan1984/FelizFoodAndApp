package com.feliz.food.sensor;

import android.app.Activity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebChromeClient;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.net.http.SslError;
import org.apache.commons.codec.binary.Base64;
import java.util.Map;
import java.util.HashMap;

public class FelizActivity extends Activity {

    private WebView webView = null;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient() {});
        String up = "SYSTEM" +":" +"Abcd1234";
        String authEncoded = new String(Base64.encodeBase64(up.getBytes()));
        String authHeader = "Basic " +authEncoded;
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", authHeader);
        webView.loadUrl("http://blri4w1012.blrl.sap.corp:8000/FoodReco",headers);
    }
}
