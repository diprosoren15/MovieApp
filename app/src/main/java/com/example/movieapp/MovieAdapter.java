package com.example.movieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.movieapp.databinding.MovieListItemsBinding;
import com.example.movieapp.model.Movies;
import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private ArrayList<Movies> moviesArrayList;

    public MovieAdapter(Context context, ArrayList<Movies> moviesArrayList) {
        this.context = context;
        this.moviesArrayList = moviesArrayList;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieListItemsBinding movieListItemsBinding = DataBindingUtil
                .inflate(LayoutInflater.from(context), R.layout.movie_list_items, parent, false);

        return new MovieViewHolder(movieListItemsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {

        Movies movieItems = moviesArrayList.get(position);
        holder.movieListItemsBinding.setMovies(movieItems);

    }

    @Override
    public int getItemCount() {
        return moviesArrayList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{

        private MovieListItemsBinding movieListItemsBinding;

        public MovieViewHolder(MovieListItemsBinding movieListItemsBinding) {
            super(movieListItemsBinding.getRoot());
            this.movieListItemsBinding = movieListItemsBinding;

            movieListItemsBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
