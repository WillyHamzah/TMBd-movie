package com.example.kursustmdb3;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieService {
    public static final String BASE_URL ="https://api.themoviedb.org/3/";


    public static APIEndPoint getAPI() {
        final Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        return retrofit.create(APIEndPoint.class);
    }

}