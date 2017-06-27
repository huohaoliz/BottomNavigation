package com.example.linktestproject.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.linktestproject.R;

public class ClassifyFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("TAG","ClassifyFragment---onCreateView");
        return inflater.inflate(R.layout.fragment_classify, container, false);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG","ClassifyFragment---onCreate");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("TAG","ClassifyFragment---onAttach");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("TAG","ClassifyFragment---onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("TAG","ClassifyFragment---onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG","ClassifyFragment---onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TAG","ClassifyFragment---onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TAG","ClassifyFragment---onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TAG","ClassifyFragment---onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("TAG","ClassifyFragment---onDetach");
    }

}
