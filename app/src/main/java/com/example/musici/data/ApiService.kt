package com.example.musici.data

import com.example.musici.API_KEY
import com.example.musici.data.model.*
import com.example.musici.ui.adapters.TopAlbums
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("?method=chart.gettoptracks&api_key=${API_KEY}&format=json")
    fun getTopTracks():Call<TopTracks>

    @GET("?method=tag.gettopalbums&tag=disco&api_key=${API_KEY}&format=json")
    fun getTopAlbums():Call<TopAlbum>

    @GET("?method=chart.gettopartists&api_key=${API_KEY}&format=json")
    fun getTopArtists(): Call<TopArtists>

    @GET("?method=track.search&api_key=${API_KEY}&format=json")
    fun searchTopTracks(@Query("track")track:String) :Call<SearchTracks>

    @GET("?method=track.search&api_key=${API_KEY}&format=json")
    fun searchTopAlbums(@Query("track") track: String) : Call<SearchAlbums>

}