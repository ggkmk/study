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
import android.widget.Toast;

import com.example.minki.eait.Common.Common;
import com.example.minki.eait.Common.User_Number;
import com.example.minki.eait.DTO.CartDTO;
import com.example.minki.eait.DTO.UserDTO;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    private RecyclerView cart_recycler;
    private LinearLayoutManager manager;
    private Button cancel;
    private TextView price_total;
    private Button add_oreder;

    private CartDTO dto;
    private ArrayList<CartDTO> list;
    private Cart_Adapter adapter;

    String name;
    int int_price;
    int int_price2;
    String total_price;
    String price;
    String count;
    String phone_Number;
    String user_Name;

    boolean check = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        //Log.d("전화번호 확인", User_Number.User_Number);
        phone_Number = User_Number.User_Number;
        user_Name = Common.currentUsers.getName();
        Log.d("이름 확인", ""+user_Name);

        Intent intent = new Intent(getIntent());
        name = intent.getStringExtra("name");
        price = intent.getStringExtra("price");
        count = intent.getStringExtra("count");

        //Log.d("카트에서도 수량확인", count);
        cancel = (Button) findViewById(R.id.cancel);
        add_oreder = (Button) findViewById(R.id.add_oreder);

        price_total = (TextView) findViewById(R.id.price_total);
        int_price = Integer.parseInt(price)*Integer.parseInt(count);
        int_price2 += int_price;
        //int_price += int_price;
        total_price = String.valueOf(int_price2);
        price_total.setText(total_price);

        cart_recycler = (RecyclerView) findViewById(R.id.cart_recycler);
        cart_recycler.setHasFixedSize(true);
        manager = new LinearLayoutManager(this);
        cart_recycler.setLayoutManager(manager);

        dto = new CartDTO();
        list = new ArrayList<CartDTO>();

        if (list.isEmpty() && com.example.minki.eait.Common.Cart.cart == null) {

            dto = new CartDTO();
            dto.setCart_Name(name);
            dto.setCart_Price(price);
            dto.setCart_Count(count);
            list.add(dto);
            adapter = new Cart_Adapter(list);
            cart_recycler.setAdapter(adapter);
            //Log.d("카트 확인", com.example.minki.eait.Common.Cart.cart.get(0).getCart_Name());

        }

        if(com.example.minki.eait.Common.Cart.cart != null) {
            list = com.example.minki.eait.Common.Cart.cart;
            for (int i=0; list.size()>=i;i++) {
                dto = new CartDTO();
                dto.setCart_Name(name);
                dto.setCart_Price(price);
                dto.setCart_Count(count);
                list.add(dto);
            }
            adapter = new Cart_Adapter(list);
            cart_recycler.setAdapter(adapter);
        }

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        add_oreder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.minki.eait.Common.Cart.cart = list;
                Intent intent = new Intent(Cart.this, Home.class);
                startActivity(intent);

            }
        });

    }
}
