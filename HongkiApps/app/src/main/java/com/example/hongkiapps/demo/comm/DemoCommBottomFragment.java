package com.example.hongkiapps.demo.comm;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.hongkiapps.R;

public class DemoCommBottomFragment extends Fragment implements DemoCommListener {
    private static final String TAG = DemoCommBottomFragment.class.getSimpleName();

    private StringBuilder mLogBuilder;
    private DemoCommCaster mCaster;
    private ViewHolder mViewHolder;

    // --------------------------------------------------------------------------------
    // Constructors
    // --------------------------------------------------------------------------------
    public static DemoCommBottomFragment newInstance() {
        return new DemoCommBottomFragment();
    }

    // --------------------------------------------------------------------------------
    // Initializers
    // --------------------------------------------------------------------------------
    private void initialize() {
        mLogBuilder = new StringBuilder();
    }

    private void initOnActivityCreated() {
        final Activity activity = getActivity();
        if(activity == null) return;

        mCaster = (DemoCommCaster)activity;
        mCaster.addCommunicateListener(this);
    }

    // --------------------------------------------------------------------------------
    // Override Methods
    // --------------------------------------------------------------------------------
    @Override
    public String toString() {
        return TAG;
    }

    // ----------------------------------------
    // On lifecycle changed.
    // ----------------------------------------
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        Log.v(TAG, "onCreate().");
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewHolder = new ViewHolder(
                (ViewGroup)inflater.inflate(R.layout.fragment_demo_communicate_bottom, container, false));
        mViewHolder.actionButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if(mCaster == null) return;
                mCaster.requestToAction(
                        mViewHolder.actionButton.getText().toString(), DemoCommBottomFragment.this);
            }
        });

        Log.v(TAG, "onCreateView().");
        return mViewHolder.rootPane;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initOnActivityCreated();
        Log.v(TAG, "onActivityCreated().");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCaster.removeCommunicateListener(this);
        Log.v(TAG, "onDestroy().");
    }

    // ----------------------------------------
    // Implements DemoCommListener.
    // ----------------------------------------
    @Override
    public void onActionExecuted(String message, Object caller) {
        if(caller == this) return;
        mLogBuilder.insert(0, "\n ");
        mLogBuilder.insert(0, message + " : " + caller.toString());
        mViewHolder.logTextView.setText(mLogBuilder.toString());
        Log.v(TAG, "onActionExecuted().");
    }

    // --------------------------------------------------------------------------------
    // Inner Classes
    // --------------------------------------------------------------------------------
    private static class ViewHolder {
        ViewGroup rootPane;
        TextView logTextView;
        Button actionButton;

        ViewHolder(ViewGroup rootPane) {
            super();
            this.rootPane = rootPane;
            this.logTextView = rootPane.findViewById(R.id.fragmentDemoCommunicateBottom_logTextView);
            this.actionButton = rootPane.findViewById(R.id.fragmentDemoCommunicateBottom_actionButton);
        }
    }
}