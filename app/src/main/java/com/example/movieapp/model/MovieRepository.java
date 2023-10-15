package com.example.movieapp.model;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.example.movieapp.R;
import com.example.movieapp.serviceapi.MovieApiService;
import com.example.movieapp.serviceapi.RetrofitInstance;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    //used to abstract data source details and provides a clean API for the ViewModel to fetch and manage data

    private ArrayList<Movies> movies = new ArrayList<>();
    private MutableLiveData<List<Movies>> liveData = new MutableLiveData<>();
    private Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movies>> getLiveData() {

        MovieApiService movieApiService = RetrofitInstance.getService();
        Call<Result> call = movieApiService.getPopularMovies(application.getApplicationContext().getString(R.string.api_key));

        //perform network request in the background thread and handle the response to the main UI thread
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                Result result= response.body();

                if (result != null){
                    movies = (ArrayList<Movies>) result.getResults();
                    liveData.setValue(movies);
                }

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
        return liveData;
    }
}
