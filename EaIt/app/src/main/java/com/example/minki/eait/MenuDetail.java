package com.example.minki.eait;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.minki.eait.Common.Common;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class MenuDetail extends AppCompatActivity {

    private ImageView img_food;
    private TextView food_name;
    private TextView food_price;
    private TextView food_description;
    private FloatingActionButton btnCart;
    private ElegantNumberButton number_button;

    private String image;
    private String name;
    private String description;
    private int int_price;
    private String price;
    private String count;

    private String phone_number;
    FirebaseDatabase database;
    DatabaseReference user;
    DatabaseReference order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);

        Intent intent = new Intent(getIntent());
        image = intent.getStringExtra("Image");
        name = intent.getStringExtra("Name");
        description = intent.getStringExtra("Description");
        int_price = intent.getIntExtra("Price", 0);
        price = String.valueOf(int_price);

        database = FirebaseDatabase.getInstance();
        user = database.getReference("User");
        order = database.getReference("Order");

        img_food = (ImageView)findViewById(R.id.img_food);
        food_name = (TextView)findViewById(R.id.food_name);
        food_price = (TextView)findViewById(R.id.food_price);
        food_description = (TextView)findViewById(R.id.food_description);
        btnCart = (FloatingActionButton) findViewById(R.id.btnCart);
        number_button = (ElegantNumberButton)findViewById(R.id.number_button);

        number_button.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = number_button.getNumber();
            }
        });

        Picasso.with(this)
                .load(image)
                .into(img_food);

        food_name.setText(name);
        food_price.setText(price);
        food_description.setText(description);

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MenuDetail.this, Cart.class);
                intent.putExtra("name", name);
                intent.putExtra("price", price);
                intent.putExtra("count", count);
                startActivity(intent);
            }
        });


    }
}
