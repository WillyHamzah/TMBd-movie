package com.example.kursustmdb3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import static com.example.kursustmdb3.MovieResponse.*;

public class MainActivity extends AppCompatActivity {

    private RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        MovieService.getAPI()
                .jadwalRilis("119377682a1e98f078b0484aa494acb1")
                .enqueue(new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                        if (response.isSuccessful()){
                            List<MovieResponse.ResultsBean> list = response.body().getResults();
                            adapter = new RecyclerViewAdapter(list);
                            recyclerView.setAdapter(adapter);

                            for (MovieResponse.ResultsBean resultsBean :list) {
                                resultsBean.getReleaseDate();

                                Log.d("berhasil", resultsBean.getReleaseDate());

                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {
                        Log.e("pesan gagal", t.getMessage());

                    }

                });

    }
}
