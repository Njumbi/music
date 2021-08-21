package com.example.musici.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.service.controls.ControlsProviderService
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musici.R
import com.example.musici.data.ApiClient
import com.example.musici.data.model.Album
import com.example.musici.data.model.TopAlbum
import com.example.musici.data.model.TopTracks
import com.example.musici.data.model.Track
import com.example.musici.ui.AlbumSearchActivity
import com.example.musici.ui.TracksSearchActivity
import com.example.musici.ui.adapters.TopAlbums
import com.example.musici.ui.adapters.TopTracksAdapter
import kotlinx.android.synthetic.main.activity_album_search.*
import kotlinx.android.synthetic.main.fragment_albums.*
import kotlinx.android.synthetic.main.fragment_albums.et_search_albums
import kotlinx.android.synthetic.main.fragment_tracks.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumsFragment : Fragment() {

    private lateinit var adapter: TopAlbums

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_albums, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        adapter = TopAlbums()

        rv_topAlbums.layoutManager = GridLayoutManager(
            requireContext(),
            3
        )
        rv_topAlbums.adapter = adapter

        pb_albums.visibility = View.VISIBLE
        ll_topAlbums.visibility = View.GONE

        et_search_albums.setOnClickListener {
            var intent = Intent(activity, AlbumSearchActivity::class.java)
            startActivity(intent)
        }

        loadAlbums()

    }

    private fun loadAlbums() {
        val call = ApiClient().service?.getTopAlbums()
        call?.enqueue(object : Callback<TopAlbum> {
            override fun onResponse(call: Call<TopAlbum>, response: Response<TopAlbum>) {

                if (response.isSuccessful) {

                    val list = response.body()?.albums?.album
                    adapter.setData(list!! as List<Album>)

                    pb_albums.visibility = View.GONE
                    ll_topAlbums.visibility = View.VISIBLE


                } else {
                    Toast.makeText(
                        requireActivity(),
                        response.errorBody().toString(),
                        Toast.LENGTH_SHORT
                    ).show()


                }

            }

            override fun onFailure(call: Call<TopAlbum>, t: Throwable) {
                Toast.makeText(requireActivity(), t.message, Toast.LENGTH_SHORT).show()


            }

        })
    }






}