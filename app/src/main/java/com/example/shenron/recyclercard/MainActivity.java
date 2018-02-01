package com.example.shenron.recyclercard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    RecyclerViewAdapter adapter;
    StringRequest request;
    RequestQueue queue;

    List<SongInfo> songs = new ArrayList<>();
    String url = "http://starlord.hackerearth.com/studio";
    String LOG_TAG = "mainactivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // getFont kya hai ? kidhar use kiya hai tu?

        recycler = (RecyclerView)findViewById(R.id.recycler_main);
        recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        getSongs();
    }
    public void getSongs(){
        queue = Volley.newRequestQueue(this);
        request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v(LOG_TAG,response);
                try{
                    JSONArray root = new JSONArray(response);
                    for(int i=0;i<root.length();i++){
                        JSONObject songInfo = root.optJSONObject(i);
                        String songName = songInfo.optString("song");
                        String artistName = songInfo.optString("artists");
                        String songPic = songInfo.optString("cover_image");
                        songs.add(new SongInfo(songName,artistName,songPic));
                    }
                    adapter = new RecyclerViewAdapter(songs, MainActivity.this);
                    recycler.setAdapter(adapter);
                }
                catch(Exception e){
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ;
                Log.v(LOG_TAG,"Error");
                //Log.v(LOG_TAG,error.String());
            }
        });
        queue.add(request);
    }
}
