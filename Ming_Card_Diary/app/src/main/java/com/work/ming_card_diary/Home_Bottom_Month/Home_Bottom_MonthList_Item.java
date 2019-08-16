package com.work.ming_card_diary.Home_Bottom_Month;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.bumptech.glide.load.engine.Resource;
import com.work.ming_card_diary.Data.MonthData;
import com.work.ming_card_diary.R;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home_Bottom_MonthList_Item extends RecyclerView.Adapter<Home_Bottom_MonthList_Item.ViewHolder> {

    private ArrayList<MonthData> monthList = new ArrayList<MonthData>();

    public Home_Bottom_MonthList_Item(ArrayList<MonthData> getMonth) {
        this.monthList = getMonth;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Button monthListItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            monthListItem = (Button) itemView.findViewById(R.id.bottom_monthlist_item);
        }
    }

    @NonNull
    @Override
    public Home_Bottom_MonthList_Item.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_main_bottom_monthlist_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Home_Bottom_MonthList_Item.ViewHolder viewHolder, int position) {
        ConstraintLayout.LayoutParams layparam = (ConstraintLayout.LayoutParams) viewHolder.monthListItem.getLayoutParams();
        viewHolder.monthListItem.setText(monthList.get(position).getMonth());
        if (!monthList.get(position).getMonth().equals("12월")) {
            layparam.rightMargin = 5;
            viewHolder.monthListItem.setLayoutParams(layparam);
        } else if (monthList.get(position).getMonth().equals("12월")) {
            layparam.rightMargin = 0;
            viewHolder.monthListItem.setLayoutParams(layparam);
        }
    }

    @Override
    public int getItemCount() {
        return monthList.size();
    }


}
