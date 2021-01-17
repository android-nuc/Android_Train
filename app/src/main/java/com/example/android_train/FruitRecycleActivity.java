package com.example.android_train;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.android_train.adapter.FruitRecycleAdapter;
import com.example.android_train.bean.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 65667
 */
public class FruitRecycleActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_recycle);

        RecyclerView recyclerView;
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        init();// 初始化水果数据

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        FruitRecycleAdapter fruitRecycleAdapter = new FruitRecycleAdapter(fruitList);
        recyclerView.setAdapter(fruitRecycleAdapter);

    }

    private void init() {
        for (int i=0; i<10; i++) {
            Fruit fruit1 = new Fruit("Apple", R.drawable.apple);
            fruitList.add(fruit1);
            Fruit fruit2 = new Fruit("Banana", R.drawable.banana);
            fruitList.add(fruit2);
            Fruit fruit3 = new Fruit("Cherry", R.drawable.cherry);
            fruitList.add(fruit3);
            Fruit fruit4 = new Fruit("Orange", R.drawable.orange);
            fruitList.add(fruit4);
        }
    }
}