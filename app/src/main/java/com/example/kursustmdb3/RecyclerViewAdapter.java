package com.example.kursustmdb3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<MovieResponse.ResultsBean> dataList;

    public RecyclerViewAdapter(List<MovieResponse.ResultsBean> dataList) {
        this.dataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.judul.setText(dataList.get(i).getTitle());
        holder.rilis.setText(dataList.get(i).getReleaseDate());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView judul, rilis;

        public ViewHolder( View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.judul_movie);
            rilis = itemView.findViewById(R.id.tahun_rlis);
        }
    }
}
