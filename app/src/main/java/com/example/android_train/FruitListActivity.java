package com.example.android_train;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android_train.adapter.FruitListAdapter;
import com.example.android_train.bean.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 65667
 */
public class FruitListActivity extends AppCompatActivity {

    private ListView listView;
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_list);

        listView = (ListView) findViewById(R.id.list_view);

        init();

        FruitListAdapter listAdapter = new FruitListAdapter(FruitListActivity.this, R.layout.fruit_item, fruitList);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(FruitListActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });

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