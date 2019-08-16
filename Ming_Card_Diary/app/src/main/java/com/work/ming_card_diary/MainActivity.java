package com.work.ming_card_diary;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.work.ming_card_diary.Data.MonthData;
import com.work.ming_card_diary.Home_Bottom_Month.Home_Bottom_MonthList_Item;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private GridLayoutManager monthListGridManager;
    private Home_Bottom_MonthList_Item monthListItemAdapter;
    private ArrayList<MonthData> monthListData;
    private MonthData monthData;

    @BindView(R.id.md_Diary_Month_List_Recyclerview)
    RecyclerView diaryMonthList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // bottom monthList Setting
        monthListData = new ArrayList<>();
        for (int i = 0; i<12; i++) {
            monthData = new MonthData();
            String month = i+1 + "월";
            monthData.setMonth(month);
            monthListData.add(monthData);
        }

        monthListGridManager = new GridLayoutManager(getApplicationContext(), 1, LinearLayoutManager.HORIZONTAL, false);
        monthListItemAdapter = new Home_Bottom_MonthList_Item(monthListData);
        diaryMonthList.setLayoutManager(monthListGridManager);
        diaryMonthList.setAdapter(monthListItemAdapter);
    }
}
