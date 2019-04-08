package com.example.minki.eait;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


public class Menu_Item extends Fragment {

    private TextView menu_name;
    //private ImageView menu_image;
    private Home home;
    private ImageView picassoImageView;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference category = database.getReference("Category");


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        home = (Home)getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.menu_item, container, false);

        menu_name = (TextView) v.findViewById(R.id.menu_name);
        picassoImageView = (ImageView) v.findViewById(R.id.menu_image);
        //menu_image = (ImageView) v.findViewById(R.id.menu_image);

        // Init firebase
        category.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot name : dataSnapshot.getChildren()) {

                    menu_name.setText(name.child("Name").getValue().toString());

                    // use piccaso
                    Picasso.with(home)
                            .load(name.child("Image").getValue().toString())
                            .into(picassoImageView);

                    //Log.d("확인데스네", "이름"+menu_name +"주소"+name.child("Image").getValue().toString());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

        return v;
    }
}
