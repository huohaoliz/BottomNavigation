package com.example.linktestproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {


    }

    public void click(View view) {
        if(view!=null){
            switch(view.getId()){
                case R.id.bt_main_radio:
                    startActivity(new Intent(this,RadioGroupActivity.class));
                break;
                case R.id.bt_main_tablayout:
                    startActivity(new Intent(this,TablayoutActivity.class));
                    break;
                case  R.id.bt_main_reflect:
                    startActivity(new Intent(this,ReflectActivity.class));
                    break;
                case R.id.bt_main_tabhost:
                    startActivity(new Intent(this,TabHostActivity.class));
            }

        }
    }
}
