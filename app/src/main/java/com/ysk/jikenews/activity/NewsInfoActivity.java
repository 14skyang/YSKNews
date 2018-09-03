package com.ysk.jikenews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;

import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import com.ysk.jikenews.BaseActivity;
import com.ysk.jikenews.R;

public class NewsInfoActivity extends BaseActivity implements View.OnClickListener{

    private View backImage;
    private String TAG = "NewsInfoActivity";
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_info);
        initSystemBar(true);
        backImage = findViewById(R.id.tool_bar_back);//返回按键
        webView = findViewById(R.id.web_view);
        //设置标题栏Toolbar

        //Toolbar toolbar = findViewById(R.id.tool_bar);
       // setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("");
        }

        backImage.setOnClickListener(this);

//        webView.setWebViewClient(new WebViewClient() {
//            @Override
//            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//                handler.proceed();
//            }
//        });
        Intent intent = getIntent();//接收来自NewsAdapter的传来的url
        String url = intent.getStringExtra("url");
        //Log.d(TAG, "我的Url"+url);
        webView.loadUrl(url);//打开url指向的网页
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tool_bar_back:
                finish();
        }
    }
}

