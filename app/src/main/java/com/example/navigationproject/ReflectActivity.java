package com.example.navigationproject;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.navigationproject.fragments.FindFragment;
import com.example.navigationproject.fragments.HomepageFragment;
import com.example.navigationproject.fragments.MineFragment;
import com.example.navigationproject.fragments.SubscriptionFragment;

public class ReflectActivity extends AppCompatActivity {

    private RadioGroup mRadioGroup;
    private FragmentManager mManager;
    private Fragment mCurrentFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflect);
        initView();
        initData();
        setListener();
    }

    private void setListener() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                Class<? extends Fragment>clazz=null;
                switch(checkedId){
                    case R.id.rb_reflect_homepage:
                        clazz= HomepageFragment.class;
                        break;
                    case R.id.rb_reflect_subscription:
                        clazz= SubscriptionFragment.class;
                        break;
                    case R.id.rb_reflect_find:
                        clazz= FindFragment.class;
                        break;
                    case R.id.rb_reflect_mine:
                        clazz= MineFragment.class;
                        break;
                }
                 showAndHide(R.id.fl_reflect_show,clazz);
            }
        });

    }
    private void initData() {
        mManager=getSupportFragmentManager();
        //设置默认显示的
        mRadioGroup.check(R.id.rb_reflect_homepage);
        showAndHide(R.id.fl_reflect_show,HomepageFragment.class);
    }

    private void showAndHide(int contentId,Class<? extends Fragment>clazz) {
        //判断当前的fragment和需要替换的fragment是不是同一个
        if(mCurrentFragment!=null&&mCurrentFragment.getClass().getSimpleName().equals(clazz.getSimpleName())){
            return;
        }
        FragmentTransaction transaction=mManager.beginTransaction();
        Fragment fragment=null;
        //判断fragment有没有添加过
        try {
        Fragment  fragmentByTag=mManager.findFragmentByTag(clazz.getSimpleName());
        if(fragment!=null){
            //显示需要的fragment
            transaction.show(fragmentByTag);
            //隐藏当前的fragment
            transaction.hide(mCurrentFragment);
            //记录当前显示的fragment
            mCurrentFragment=fragmentByTag;
        }else{
            //通过无参的 公开的构造函数来创建fragment实例
            fragment=clazz.newInstance();  //需要try/catch声明异常
            //当前的fragment的没有添加过
            //把fragment添加到fragmentManager里面
            transaction.add(contentId,fragment,clazz.getSimpleName());
            //隐藏当前的fragment
            if(mCurrentFragment!=null){
                transaction.hide(mCurrentFragment);
            }
            //记录当前的fragment是哪个
            mCurrentFragment=fragment;
         }
         transaction.commit();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private void initView() {
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        mRadioGroup= (RadioGroup) findViewById(R.id.rg_reflect_navigation);
    }
}
