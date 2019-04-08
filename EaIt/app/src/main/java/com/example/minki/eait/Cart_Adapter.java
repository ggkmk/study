package com.example.minki.eait;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.minki.eait.DTO.CartDTO;

import java.util.ArrayList;

public class Cart_Adapter extends RecyclerView.Adapter<Cart_Adapter.MyViewHolder> {

    private ArrayList<CartDTO> mList;
    private int int_total;
    private int int_price;
    private int int_getTotal;
    private String total;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        protected TextView cart_Name;
        protected TextView cart_Count;
        protected TextView cart_Price;
        protected TextView cart_Total;

        public MyViewHolder(@NonNull View view) {
            super(view);
            this.cart_Name = view.findViewById(R.id.cart_name);
            this.cart_Count = view.findViewById(R.id.cart_count);
            this.cart_Price = view.findViewById(R.id.cart_price);
            this.cart_Total = view.findViewById(R.id.cart_total);
        }
    }

    public Cart_Adapter(ArrayList<CartDTO> list) {
        this.mList = list;
    }

    @NonNull
    @Override
    public Cart_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_item, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Cart_Adapter.MyViewHolder holder, int position) {

        holder.cart_Name.setText(mList.get(position).getCart_Name());

        holder.cart_Price.setText(mList.get(position).getCart_Price());

        holder.cart_Count.setText(mList.get(position).getCart_Count());

        int_price = Integer.parseInt(mList.get(position).getCart_Price());

        int_total = Integer.parseInt(mList.get(position).getCart_Count());

        int_getTotal = int_price * int_total;
        total = String.valueOf(int_getTotal);

        holder.cart_Total.setText(total);

    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}
