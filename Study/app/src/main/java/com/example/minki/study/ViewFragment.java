package com.example.minki.study;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ViewFragment extends Fragment {

    private TextView text_Id;
    MainActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity)getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.view, container, false);

        text_Id = (TextView) v.findViewById(R.id.text_Id);

        /*if (check == false) {
            text_Id.setText("리버푸우울~~");
            check = true;

        } else if(true) {
            String temp = activity.dto.getMessage();
            Toast.makeText(getContext(), "확인"+activity.dto.getMessage(), Toast.LENGTH_SHORT).show();
            text_Id.setText(temp);
        }*/

        /*if (test != null) {
            //String temp = activity.dto.getMessage();
            text_Id.setText(activity.dto.getMessage());
            Toast.makeText(getContext(), "확인"+activity.dto.getMessage(), Toast.LENGTH_SHORT).show();
        }*/

        Bundle bundle = getArguments();
        if (bundle != null) {
            String param = bundle.getString("msg");
            text_Id.setText(param);
            Toast.makeText(getContext(), "확인"+param, Toast.LENGTH_SHORT).show();
        }

        return v;
    }


}
