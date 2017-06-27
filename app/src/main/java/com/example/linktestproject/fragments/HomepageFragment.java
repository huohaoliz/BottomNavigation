package com.example.linktestproject.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.*;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.linktestproject.R;
import com.example.linktestproject.adapter.HomepageAdapter;

import java.util.ArrayList;
import java.util.List;


public class HomepageFragment extends Fragment {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private List<Fragment>mFragments;
    private List<String>mTitles;
    private HomepageAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_homepage, container, false);
        initView(view);
        initData(view);
        setData();
        return view;
    }

    private void setData() {
        mViewPager.setAdapter(mAdapter);
        //设置Viewpager和Tablayout进行联动
        mTabLayout.setupWithViewPager(mViewPager);
//        //将标题设置可以左右摇动而不是移动
//        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        //设置预加载页数
//        mViewPager.setOffscreenPageLimit(3);

    }

    private void initData(View view) {
        //初始化导航标题,如果是title在json数据中,在初始化的时候可以使用异步任务加载的形式添加
        mTitles=new ArrayList<>();
        mTitles.add("热门");
        mTitles.add("分类");
        mTitles.add("榜单");
        //初始化Fragment
        mFragments=new ArrayList<>();
        for (int i = 0; i <mTitles.size() ; i++) {
            if(i==0){
                mFragments.add(new HotFragment());
            }else if(i==1){
                mFragments.add(new ClassifyFragment());
            }else if(i==2){
                mFragments.add(new ListingFragment());
            }
        }
        //getSupportFragmentManager()是Activity嵌套fragment时使用
        //getChildFragmentManager()是Fragment嵌套Fragment时使用
        mAdapter=new HomepageAdapter(getChildFragmentManager(),mFragments,mTitles);
        mAdapter.notifyDataSetChanged();
    }

    private void initView(View view) {
         mViewPager= (ViewPager) view.findViewById(R.id.vp_homepage_show);
        mTabLayout= (TabLayout) view.findViewById(R.id.tl_homepage_navigation);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG","HomeFragment---onCreate");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("TAG","HomeFragment---onAttach");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("TAG","HomeFragment---onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("TAG","HomeFragment---onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG","HomeFragment---onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TAG","HomeFragment---onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TAG","HomeFragment---onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TAG","HomeFragment---onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("TAG","HomeFragment---onDetach");
    }
}
