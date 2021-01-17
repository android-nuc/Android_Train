package com.example.android_train.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android_train.R;
import com.example.android_train.bean.Movie;

import java.util.List;

/**
 * @author 65667
 */
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {


    private List<Movie> movieList;
    private Context context;

    public MovieListAdapter(List<Movie> movies){
        movieList = movies;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);
        context = parent.getContext();
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.movieTitle.setText(movie.getTitle());
        holder.movieGenres.setText(movie.getGenres());
        holder.movieAverage.setText(movie.getAverage());
        holder.movieTime.setText(movie.getTime());
        //加载图片
        Glide.with(context).load(movie.getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView movieTitle,movieGenres,movieAverage,movieTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.movie_image);
            movieTitle = itemView.findViewById(R.id.movie_title);
            movieGenres = itemView.findViewById(R.id.movie_genres);
            movieAverage = itemView.findViewById(R.id.movie_average);
            movieTime = itemView.findViewById(R.id.movie_time);
        }
    }


}
