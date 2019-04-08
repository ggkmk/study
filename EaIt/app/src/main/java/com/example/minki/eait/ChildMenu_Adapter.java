package com.example.minki.eait;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.minki.eait.DTO.Child;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ChildMenu_Adapter extends RecyclerView.Adapter<ChildMenu_Adapter.MyViewHolder> {

    private ArrayList<Child> mList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        protected TextView menu_name;
        protected ImageView menu_image;
        protected RelativeLayout menu_key;

        public MyViewHolder(View view) {
            super(view);
            this.menu_name = (TextView) view.findViewById(R.id.child_menu_name);
            this.menu_image = (ImageView) view.findViewById(R.id.child_menu_image);
            this.menu_key = (RelativeLayout) view.findViewById(R.id.child_menu_key);
        }
    }

    public ChildMenu_Adapter(ArrayList<Child> list) {

        this.mList = list;

    }

    @NonNull
    @Override
    public ChildMenu_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.childmenu_item, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(view);
        context = parent.getContext();

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.menu_name.setText(mList.get(position).getName());

        Picasso.with(context)
                .load(mList.get(position).getImage())
                .into(holder.menu_image);

        holder.menu_key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("위치확인", "" + mList.get(position).getKey().toString());
                Intent intent = new Intent(context, MenuDetail.class);
                intent.putExtra("Image", mList.get(position).getImage());
                intent.putExtra("Name", mList.get(position).getName());
                intent.putExtra("Price", mList.get(position).getPrice());
                intent.putExtra("Description", mList.get(position).getDescription());
                //String key = mList.get(position).getKey().toString();
                //intent.putExtra("key",  key);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}
