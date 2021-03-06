package com.example.hongkiapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hongkiapps.demo.comm.DemoCommActivity;
import com.example.hongkiapps.demo.lifecycle.DemoLifecycleActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private ViewHolder mViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewHolder = new ViewHolder((ViewGroup)findViewById(R.id.activityMain_rootPane));
        mViewHolder.callLifecycleActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DemoLifecycleActivity.class));
            }
        });
        mViewHolder.callCommunicateFragmentsButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DemoCommActivity.class));
            }
        });
        Log.v(TAG, "onCreate().");
    }

    private static class ViewHolder {
        ViewGroup rootPane;
        Button callLifecycleActivityButton;
        Button callCommunicateFragmentsButton;

        ViewHolder(ViewGroup rootPane) {
            super();
            this.rootPane = rootPane;
            this.callLifecycleActivityButton = rootPane.findViewById(R.id.activityMain_callLifecycleActivityButton);
            this.callCommunicateFragmentsButton = rootPane.findViewById(R.id.activityMain_communicateFragmentsButton);
        }
    }
}
