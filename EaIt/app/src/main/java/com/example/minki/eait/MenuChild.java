package com.example.minki.eait;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.minki.eait.DTO.Child;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MenuChild extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference child;

    RecyclerView recycler_Childmenu;
    RecyclerView.LayoutManager layoutManager;

    private ArrayList<Child> mList;
    private ChildMenu_Adapter adapter;
    private Child dto;

    String menu_SetName;
    String menu_SetImage;
    String menu_Key;
    String menu_SetDescription;
    int menu_SetPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_child);

        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        //Toast.makeText(MenuChild.this, "확인~~"+key, Toast.LENGTH_LONG).show();

        // Init firebase
        database = FirebaseDatabase.getInstance();
        switch (key) {
            case "01":
                child = database.getReference("Child01");
                break;
            case"02":
                child = database.getReference("Child02");
                break;
        }

        //child = database.getReference("Child01");

        // Load menu
        recycler_Childmenu = (RecyclerView) findViewById(R.id.recycler_ChildMenu);
        recycler_Childmenu.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycler_Childmenu.setLayoutManager(layoutManager);

        mList = new ArrayList<Child>();

        child.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot bring : dataSnapshot.getChildren()) {
                    dto = new Child();
                    menu_SetName = bring.child("Name").getValue().toString();
                    menu_SetImage = bring.child("Image").getValue().toString();
                    menu_SetDescription = bring.child("Description").getValue().toString();
                    menu_SetPrice = Integer.parseInt(bring.child("Price").getValue().toString());
                    //Log.d("111111111 ", menu_SetDescription);
                    //Log.d("222222222 ", ""+menu_SetPrice);
                    menu_Key = bring.getKey().toString();
                    dto.setName(menu_SetName);
                    dto.setImage(menu_SetImage);
                    dto.setDescription(menu_SetDescription);
                    dto.setPrice(menu_SetPrice);
                    dto.setKey(menu_Key);
                    //Log.d("또 확인111 ", menu_SetName);
                    //Log.d("또 확인2222 ", menu_SetImage);
                    mList.add(dto);

                }
                Log.d("들어오나 확인33 ", "test");
                adapter = new ChildMenu_Adapter(mList);
                recycler_Childmenu.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}

        });

    }
}
