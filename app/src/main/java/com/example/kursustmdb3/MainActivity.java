package com.example.kursustmdb3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        MovieService.getAPI()
                .jadwalRilis("Movie")
                .enqueue(new Callback<MovieService>() {
                    @Override
                    public void onResponse(Call<MovieService> call, Response<MovieService> response) {
                        if (response.isSuccessful()){
                            List<MovieResponse.ResultsBean> list = response.body().getClass();
                            adapter = new RecyclerViewAdapter(list);
                            recyclerView.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieService> call, Throwable t) {

                    }
                });

    }
}
