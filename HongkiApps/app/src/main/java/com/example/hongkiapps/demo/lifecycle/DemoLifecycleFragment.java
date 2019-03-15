package com.example.hongkiapps.demo.lifecycle;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hongkiapps.R;

public class DemoLifecycleFragment extends Fragment {
    private static final String TAG = DemoLifecycleFragment.class.getSimpleName();

    private StringBuilder mLogBuilder;
    private ViewHolder mViewHolder;

    public DemoLifecycleFragment() {
        super();
        this.mLogBuilder = new StringBuilder();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        printLog("onAttach().");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        printLog("onCreate().");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewHolder = new ViewHolder((ViewGroup)inflater.inflate(R.layout.fragment_demo_lifecycle, container, false));
        printLog("onCreateView().");
        return mViewHolder.rootPane;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        printLog("onActivityCreated().");
    }

    @Override
    public void onStart() {
        super.onStart();
        printLog("onStart().");
    }

    @Override
    public void onResume() {
        super.onResume();
        printLog("onResume().");
    }

    @Override
    public void onPause() {
        super.onPause();
        printLog("onPause().");
    }

    @Override
    public void onStop() {
        super.onStop();
        printLog("onStop().");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        printLog("onDestroyView().");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        printLog("onDestroy().");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        printLog("onDetach().");
    }

    private void printLog(String log) {
        mLogBuilder
                .append(log)
                .append("\n");
        if(mViewHolder != null) {
            mViewHolder.logTextView.setText(mLogBuilder.toString());
        }
        Log.v(TAG, log);
    }

    private static class ViewHolder {
        ViewGroup rootPane;
        TextView logTextView;

        ViewHolder(ViewGroup rootPane) {
            super();
            this.rootPane = rootPane;
            this.logTextView = rootPane.findViewById(R.id.fragmentDemoLifecycle_logTextView);
        }
    }
}