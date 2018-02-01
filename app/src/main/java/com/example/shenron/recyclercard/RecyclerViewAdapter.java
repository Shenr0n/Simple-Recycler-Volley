package com.example.shenron.recyclercard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shenron on 01-02-2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<SongInfo> songs = new ArrayList<>();
    Context context;

    public RecyclerViewAdapter(List<SongInfo> songs,Context context){
        this.songs = songs;
        this.context = context;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootview = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_recycler,parent,false);
        return new ViewHolder(rootview);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.vol_song.setText(songs.get(position).getName());
        holder.vol_artist.setText(songs.get(position).getArtist());
        Glide.with(context).load(songs.get(position).getImageurl()).into(holder.vol_pic);
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView vol_song,vol_artist;
        ImageView vol_pic;
        public ViewHolder(View itemView) {
            super(itemView);
            vol_song= itemView.findViewById(R.id.volley_song);
            vol_artist = itemView.findViewById(R.id.volley_artist);
            vol_pic = itemView.findViewById(R.id.volley_pic);

        }
    }
}
