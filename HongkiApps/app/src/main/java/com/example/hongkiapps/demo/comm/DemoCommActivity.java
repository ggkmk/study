package com.example.hongkiapps.demo.comm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;

import com.example.hongkiapps.R;

import java.util.HashSet;
import java.util.Set;

public class DemoCommActivity extends AppCompatActivity implements DemoCommCaster {
    private static final String TAG = DemoCommActivity.class.getSimpleName();

    private ViewHolder mViewHolder;
    private Set<DemoCommListener> mListenerSet;

    // --------------------------------------------------------------------------------
    // Initializers
    // --------------------------------------------------------------------------------
    private void initialize() {
        mViewHolder = new ViewHolder((ViewGroup)findViewById(R.id.activityDemoCommunicate_rootPane));
        mListenerSet = new HashSet<>();

        getSupportFragmentManager().beginTransaction()
                .add(mViewHolder.topPane.getId(), DemoCommTopFragment.newInstance())
                .add(mViewHolder.bottomPane.getId(), DemoCommBottomFragment.newInstance())
                .commit();
    }

    // --------------------------------------------------------------------------------
    // Override Methods
    // --------------------------------------------------------------------------------
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_communicate);
        initialize();
        Log.v(TAG, "onCreate().");
    }

    // ----------------------------------------
    // Implements DemoCommCaster.
    // ----------------------------------------
    @Override
    public void requestToAction(String message, Object caller) {
        for(DemoCommListener listener : mListenerSet) {
            listener.onActionExecuted(message, caller);
        }
    }

    @Override
    public void addCommunicateListener(DemoCommListener listener) {
        mListenerSet.add(listener);
    }

    @Override
    public void removeCommunicateListener(DemoCommListener listener) {
        mListenerSet.remove(listener);
    }

    // --------------------------------------------------------------------------------
    // Inner Classes.
    // --------------------------------------------------------------------------------
    private static final class ViewHolder {
        ViewGroup rootPane;
        ViewGroup topPane;
        ViewGroup bottomPane;

        ViewHolder(ViewGroup rootPane) {
            super();
            this.rootPane = rootPane;
            this.topPane = rootPane.findViewById(R.id.activityDemoCommunicate_topPane);
            this.bottomPane = rootPane.findViewById(R.id.activityDemoCommunicate_bottomPane);
        }
    }
}