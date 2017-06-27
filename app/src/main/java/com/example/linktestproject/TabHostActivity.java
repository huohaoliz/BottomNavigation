package com.example.linktestproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.linktestproject.fragments.FindFragment;
import com.example.linktestproject.fragments.HomepageFragment;
import com.example.linktestproject.fragments.MineFragment;
import com.example.linktestproject.fragments.SubscriptionFragment;

import java.util.ArrayList;
import java.util.List;

public class TabHostActivity extends AppCompatActivity {

    private Class []mFragments;
    private List<String>mTitles;
    private FragmentTabHost mTabHost;
    private LayoutInflater mInflater;
    private  TextView mTextView;
    private ImageView mImageView;
    private View mView;
    private int [] mImageViews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host);
        initView();
        initData();
        setData();
    }
    private void setData() {
        //为FragmentTabHost来填充Fragment
          mTabHost.setup(this,getSupportFragmentManager(),R.id.fl_tabhost_show);
        for (int i = 0; i <mTitles.size() ; i++) {
            TabHost.TabSpec  tabSpec=mTabHost.newTabSpec(mTitles.get(i)).setIndicator(getTabItemVIew(i));
            mTabHost.addTab(tabSpec,mFragments[i],null);
            //取消默认的Tab间的竖线显示,不加这一句会导致每个导航按钮之间存在一条竖直的分割线
            mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        }
    }
    private void initData() {
        mTitles=new ArrayList<>();
        mTitles.add("首页");
        mTitles.add("订阅");
        mTitles.add("发现");
        mTitles.add("我的");
        mFragments=new Class[]{HomepageFragment.class,SubscriptionFragment.class,FindFragment.class,MineFragment.class};
        mImageViews=new int[]{R.drawable.hometablayout,R.drawable.subtablayout,R.drawable.findtablayout,R.drawable.minetablayout};
    }
    private void initView() {
         ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
         mTabHost= (FragmentTabHost) findViewById(R.id.fth_tabhost_nativation);
         mInflater=LayoutInflater.from(this);
    }
    private View getTabItemVIew(int index){
        mView=mInflater.inflate(R.layout.tab_indicator,null);
        mImageView= (ImageView) mView.findViewById(R.id.iv_tab_navigation);
        mImageView.setImageResource(mImageViews[index]);
        mTextView= (TextView) mView.findViewById(R.id.tv_tab_navigation);
        mTextView.setText(mTitles.get(index));
        return mView;
    }
}
