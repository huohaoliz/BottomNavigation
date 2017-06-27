package com.example.linktestproject;

import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.linktestproject.adapter.TablayoutAdapter;
import com.example.linktestproject.fragments.FindFragment;
import com.example.linktestproject.fragments.HomepageFragment;
import com.example.linktestproject.fragments.MineFragment;
import com.example.linktestproject.fragments.SubscriptionFragment;

import java.util.ArrayList;
import java.util.List;

public class TablayoutActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment>mFragments;
    private TablayoutAdapter mAdapter;
    private List<String>mTitles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        getSupportActionBar().hide();
        initView();
        initData();
        setData();
        setListener();
    }

    private void setListener() {

    }

    private void setData() {
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        for (int i = 0; i <mTabLayout.getTabCount() ; i++) {
            TabLayout.Tab tab=mTabLayout.getTabAt(i);
            Drawable drawable=null;
            switch(i){
                case 0:
                    //图片资源我们同样要使用选择器,选择器我们不能使用state_checked属性,而应该使用state_selected属性
                    drawable=getResources().getDrawable(R.drawable.hometablayout);
                    //Call requires API level 21 (current min is 15): android.content.res.Resources#getDrawable more..
//                    drawable=getResources().getDrawable(R.drawable.hometablayout,null);

                break;
                case 1:
                    drawable=getResources().getDrawable(R.drawable.subtablayout);
                    break;
                case 2:
                    drawable=getResources().getDrawable(R.drawable.findtablayout);
                    break;
                case 3:
                    drawable=getResources().getDrawable(R.drawable.minetablayout);
                    break;
            }
                tab.setIcon(drawable);
        }

    }

    private void initData() {
        mTitles=new ArrayList<>();
        mTitles.add("首页");
        mTitles.add("订阅");
        mTitles.add("发现");
        mTitles.add("我的");
        mFragments=new ArrayList<>();
        for (int i = 0; i <mTitles.size(); i++) {
            if(i==0){
                mFragments.add(new HomepageFragment());
            }else if(i==1){
                mFragments.add(new SubscriptionFragment());
            }else if(i==2){
                mFragments.add(new FindFragment());
            }else  if(i==3){
                mFragments.add(new MineFragment());
            }
        }
         mAdapter=new TablayoutAdapter(getSupportFragmentManager(),mFragments,mTitles);
         mAdapter.notifyDataSetChanged();

    }

    private void initView() {
        mTabLayout= (TabLayout) findViewById(R.id.tl_tablayout_navigation);
        mViewPager= (ViewPager) findViewById(R.id.vp_tablayout_show);
    }
}
