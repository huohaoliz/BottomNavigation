package com.example.linktestproject;


import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.linktestproject.fragments.FindFragment;
import com.example.linktestproject.fragments.HomepageFragment;
import com.example.linktestproject.fragments.MineFragment;
import com.example.linktestproject.fragments.SubscriptionFragment;

public class RadioGroupActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup mRadioGroup;
    private Fragment[] mFragments;
    private FrameLayout mLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_group);
        getSupportActionBar().hide();
        initView();
        initFragment();
        setListener();
    }

    private void setListener() {
        //对RadioGroup设置监听事件(监听点击选择)
        mRadioGroup.setOnCheckedChangeListener(this);

    }

    private void initFragment() {
        //初始化要显示的Fragment数组
        mFragments=new Fragment[4];
        mFragments[0]=new HomepageFragment();
        mFragments[1]=new SubscriptionFragment();
        mFragments[2]=new FindFragment();
        mFragments[3]=new MineFragment();
        //获取Fragment管理器
        FragmentManager manager=getSupportFragmentManager();
        //获取事物(使用v4包下)
        FragmentTransaction transaction=manager.beginTransaction();
        //默认选中HomepageFragment替换Framelayout
        transaction.replace(R.id.fl_radio_show,mFragments[0]);
        //提交事物
        transaction.commit();
        //默认点击首页
        mRadioGroup.check(R.id.rb_radio_homepage);
    }

    private void initView() {
        mRadioGroup= (RadioGroup) findViewById(R.id.rg_radio_navigation);
        mLayout= (FrameLayout) findViewById(R.id.fl_radio_show);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        //写法与默认点击页面的相同
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction  transaction=manager.beginTransaction();
        switch(checkedId){
            case R.id.rb_radio_homepage:
                transaction.replace(R.id.fl_radio_show,mFragments[0]);
            break;
            case R.id.rb_radio_subscription:
                transaction.replace(R.id.fl_radio_show,mFragments[1]);
                break;
            case R.id.rb_radio_find:
                transaction.replace(R.id.fl_radio_show,mFragments[2]);
                break;
            case R.id.rb_radio_mine:
                transaction.replace(R.id.fl_radio_show,mFragments[3]);
                break;
        }
        transaction.commit();
    }
}
