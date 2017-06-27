package com.example.navigationproject.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationproject.R;


public class SubscriptionFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("TAG","SubscriptionFragment---onCreateView");
        return inflater.inflate(R.layout.fragment_subscription, container, false);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG","SubscriptionFragment---onCreate");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("TAG","SubscriptionFragment---onAttach");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("TAG","SubscriptionFragment---onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("TAG","SubscriptionFragment---onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG","SubscriptionFragment---onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TAG","SubscriptionFragment---onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TAG","SubscriptionFragment---onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TAG","SubscriptionFragment---onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("TAG","SubscriptionFragment---onDetach");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("TAG","SubscriptionFragment---onDestroyView");
    }
}
