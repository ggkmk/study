package com.example.minki.study;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.SupportActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditFragment extends Fragment {

    private EditText edit_Id;
    private Button button_Id;


    MainActivity activity;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        activity = (MainActivity) getActivity();

    }

    // 인플레이션은 onCreateView에서 한다.
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.edit, container, false);

        edit_Id = (EditText) v.findViewById(R.id.edit_Id) ;
        button_Id = (Button) v. findViewById(R.id.button_Id);

        button_Id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edit_Id.getText().toString();
                //activity.Message(text);

                //Toast.makeText(getContext(), "확인"+text, Toast.LENGTH_SHORT).show();
                //activity.getMessage(text);
                activity.dto.setMessage(text);
                //Toast.makeText(getContext(), "확인"+activity.dto.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}
