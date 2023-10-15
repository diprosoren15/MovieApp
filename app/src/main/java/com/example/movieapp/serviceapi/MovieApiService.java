package com.example.movieapp.serviceapi;

import com.example.movieapp.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {

    @GET("movie/popular")
    Call<Result> getPopularMovies(@Query("api_key") String apiKey);

}
