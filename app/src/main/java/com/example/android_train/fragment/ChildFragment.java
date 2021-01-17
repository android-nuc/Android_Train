package com.example.android_train.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_train.R;
import com.example.android_train.adapter.FruitRecycleAdapter;
import com.example.android_train.bean.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 65667
 */
public class ChildFragment extends Fragment {
    
    private List<Fruit> fruitList = new ArrayList<>();

    public static ChildFragment newInstance(String title) {
        
        Bundle args = new Bundle();
        args.putString("title", title);
        ChildFragment fragment = new ChildFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_child, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_recycler);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        initFruits();
        FruitRecycleAdapter adapter = new FruitRecycleAdapter(fruitList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void initFruits(){
        for(int i = 0;i < 10;i ++){
            Fruit fruit_1 = new Fruit("Apple",R.drawable.apple);
            fruitList.add(fruit_1);
            Fruit fruit_2 = new Fruit("Banana",R.drawable.banana);
            fruitList.add(fruit_2);
            Fruit fruit_3 = new Fruit("Cherry",R.drawable.cherry);
            fruitList.add(fruit_3);
            Fruit fruit_4 = new Fruit("Orange",R.drawable.orange);
            fruitList.add(fruit_4);
        }
    }
}
