package com.example.hongkiapps.demo.lifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hongkiapps.R;

public class DemoLifecycleActivity extends AppCompatActivity {
    private static final String TAG = DemoLifecycleActivity.class.getSimpleName();

    private StringBuilder mLogBuilder;
    private ViewHolder mViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_lifcyccle);
        mLogBuilder = new StringBuilder();
        mViewHolder = new ViewHolder((ViewGroup)findViewById(R.id.activityDemoLifecycle_rootPane));
        printLog("onCreate().");
    }

    @Override
    protected void onStart() {
        super.onStart();
        printLog("onStart().");
    }

    @Override
    protected void onResume() {
        super.onResume();
        printLog("onResume().");
    }

    @Override
    protected void onPause() {
        super.onPause();
        printLog("onPause().");
    }

    @Override
    protected void onStop() {
        super.onStop();
        printLog("onStop().");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        printLog("onDestroy().");
    }

    private void printLog(String log) {
        mViewHolder.logTextView.setText(mLogBuilder
                .append(log)
                .append("\n")
                .toString());
        Log.v(TAG, log);
    }

    private static class ViewHolder {
        ViewGroup rootPane;
        TextView logTextView;

        ViewHolder(ViewGroup rootPane) {
            super();
            this.rootPane = rootPane;
            this.logTextView = rootPane.findViewById(R.id.activityDemoLifecycle_logTextView);
        }
    }
}