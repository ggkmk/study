package com.example.minki.study;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditFragment editFragment;
    private ViewFragment viewFragment;

    private FragmentManager manager;

    String temp = null;

    TempDTO dto = new TempDTO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        editFragment = (EditFragment) manager.findFragmentById(R.id.edit_fragment);
        viewFragment = (ViewFragment) manager.findFragmentById(R.id.view_fragment);



        //Toast.makeText(MainActivity.this, "확인"+ temp, Toast.LENGTH_SHORT).show();
        if (dto.getMessage() != null) {
            Bundle bundle = new Bundle(1);
            String message = dto.getMessage();
            bundle.putString("msg", message);



            ViewFragment view = new ViewFragment();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            view.setArguments(bundle);
            fragmentTransaction.replace(R.id.view_fragment, viewFragment).addToBackStack(null).commit();

        }

    }

    public void Message(String msg) {
        temp = msg;
        //Toast.makeText(MainActivity.this, "확인"+ temp, Toast.LENGTH_SHORT).show();
    }

/*    public void Message(String msg) {
        TempDTO dto = new TempDTO();
        temp = msg;
        dto.setMessage(temp);
    }

    public String send() {
        String send = dto.getMessage();
        return send;
    }*/

}
