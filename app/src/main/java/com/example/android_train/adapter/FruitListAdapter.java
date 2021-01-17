package com.example.android_train.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android_train.R;
import com.example.android_train.bean.Fruit;

import java.util.List;

/**
 * @author 65667
 */
public class FruitListAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    public FruitListAdapter(Context context, int resource, List<Fruit> fruits) {
        super(context, resource, fruits);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext())
                    .inflate(resourceId, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        viewHolder.imageView.setImageResource(fruit.getImageId());
        viewHolder.textView.setText(fruit.getName());
        return view;
    }

    public class ViewHolder {

        ImageView imageView;
        TextView textView;

        public ViewHolder(View view) {
            imageView = view.findViewById(R.id.fruit_image);
            textView = view.findViewById(R.id.fruit_name);
        }

    }
}
