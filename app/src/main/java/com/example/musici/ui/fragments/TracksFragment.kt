package com.example.musici.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musici.R
import com.example.musici.data.ApiClient
import com.example.musici.data.model.TopTracks
import com.example.musici.data.model.Track
import com.example.musici.ui.TracksSearchActivity
import com.example.musici.ui.adapters.TopTracksAdapter
import kotlinx.android.synthetic.main.fragment_tracks.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TracksFragment : Fragment() {

    private lateinit var adapter: TopTracksAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tracks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        adapter = TopTracksAdapter()

        rv_topTracks.layoutManager = GridLayoutManager(
            requireContext(),
            3
        )
        rv_topTracks.adapter = adapter


        loadTracks()
        et_search_tracks.setOnClickListener {
            var intent = Intent(activity,TracksSearchActivity::class.java)
            startActivity(intent)
        }
        pb_tracks.visibility = View.VISIBLE
        ll_topTracks.visibility = View.GONE

    }

    private fun loadTracks() {
        Log.d(TAG, "THIS IS LOAD TRACKS")
        val call = ApiClient().service?.getTopTracks()
        call?.enqueue(object : Callback<TopTracks> {
            override fun onResponse(call: Call<TopTracks>, response: Response<TopTracks>) {

                if (response.isSuccessful) {

                    val list = response.body()?.tracks?.track
                    adapter.setData(list!! as List<Track>)

                    pb_tracks.visibility = View.GONE
                    ll_topTracks.visibility = View.VISIBLE


                } else {
                    Toast.makeText(
                        requireActivity(),
                        response.errorBody().toString(),
                        Toast.LENGTH_SHORT
                    ).show()

                    println(response.errorBody())
                }

            }

            override fun onFailure(call: Call<TopTracks>, t: Throwable) {
                Toast.makeText(requireActivity(), t.message, Toast.LENGTH_SHORT).show()


            }

        })
    }
}