package com.example.minki.eait;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.minki.eait.DTO.CartDTO;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    private RecyclerView cart_recycler;
    private LinearLayoutManager manager;
    private Button cancel;
    private TextView price_total;

    private CartDTO dto;
    private ArrayList<CartDTO> list;
    private Cart_Adapter adapter;

    String name;
    int int_price;
    int int_price2;
    String total_price;
    String price;
    String count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent intent = new Intent(getIntent());
        name = intent.getStringExtra("name");
        price = intent.getStringExtra("price");
        count = intent.getStringExtra("count");

        //Log.d("카트에서도 수량확인", count);
        cancel = (Button) findViewById(R.id.cancel);

        price_total = (TextView) findViewById(R.id.price_total);
        int_price = Integer.parseInt(price)*Integer.parseInt(count);
        int_price2 += int_price;
        //int_price += int_price;
        total_price = String.valueOf(int_price);
        price_total.setText(total_price);

        cart_recycler = (RecyclerView) findViewById(R.id.cart_recycler);
        cart_recycler.setHasFixedSize(true);
        manager = new LinearLayoutManager(this);
        cart_recycler.setLayoutManager(manager);

        dto = new CartDTO();
        list = new ArrayList<CartDTO>();
        adapter = new Cart_Adapter(list);

        dto.setCart_Name(name);
        dto.setCart_Price(price);
        dto.setCart_Count(count);
        list.add(dto);

        cart_recycler.setAdapter(adapter);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
