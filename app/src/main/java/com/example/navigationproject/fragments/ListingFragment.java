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

public class ListingFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("TAG","ListingFragment---onCreateView");
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG","ListingFragment---onCreate");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("TAG","ListingFragment---onAttach");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("TAG","ListingFragment---onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("TAG","ListingFragment---onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG","ListingFragment---onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TAG","ListingFragment---onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TAG","ListingFragment---onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TAG","ListingFragment---onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("TAG","ListingFragment---onDetach");
    }


}
