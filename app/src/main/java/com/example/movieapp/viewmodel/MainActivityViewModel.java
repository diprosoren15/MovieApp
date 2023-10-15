package com.example.movieapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movieapp.model.MovieRepository;
import com.example.movieapp.model.Movies;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    //ViewModel - suitable for non android specific logic
    //AndroidViewModel - suitable for android specific logic

    private MovieRepository movieRepository;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        this.movieRepository = new MovieRepository(application);

    }

    public LiveData<List<Movies>> getAllMovies() {
        return movieRepository.getLiveData();
    }
}
