package com.example.minki.eait;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.minki.eait.DTO.Category;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Menu_Adapter extends RecyclerView.Adapter<Menu_Adapter.MyViewHolder> {

    private ArrayList<Category> mList;
    private Context context;
    private Home home;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        protected TextView menu_name;
        protected ImageView menu_image;
        protected RelativeLayout menu_key;

        public MyViewHolder(View view) {
            super(view);
            this.menu_name = (TextView) view.findViewById(R.id.menu_name);
            this.menu_image = (ImageView) view.findViewById(R.id.menu_image);
            this.menu_key = (RelativeLayout) view.findViewById(R.id.menu_key);
        }
    }


    public Menu_Adapter(ArrayList<Category> list) {
        this.mList = list;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public Menu_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {

        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_item, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(view);
        context = parent.getContext();

        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        holder.menu_name.setText(mList.get(position).getName());

        Picasso.with(context)
                .load(mList.get(position).getImage())
                .into(holder.menu_image);

        //int key = Integer.parseInt(mList.get(position).getKey().toString());
        //Log.d("키 확인", " "+key);
        //holder.menu_key.setId(key);

        holder.menu_key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("위치확인", "" + mList.get(position).getKey().toString());
                Intent intent = new Intent(context, MenuChild.class);
                String key = mList.get(position).getKey().toString();
                intent.putExtra("key",  key);
                context.startActivity(intent);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}
