package com.example.kursustmdb3;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIEndPoint {
    @GET("movie/now_playing")
    Call<MovieResponse> jadwalRilis(
            @Query("api_key") String key);
}
