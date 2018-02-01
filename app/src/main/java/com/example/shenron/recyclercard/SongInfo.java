package com.example.shenron.recyclercard;

/**
 * Created by Shenron on 01-02-2018.
 */

public class SongInfo {
    String name,artist,imageurl;

    public SongInfo(String name,String artist,String imageurl)
    {
        this.name = name;
        this.artist = artist;
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }


}
