package com.example.musici.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musici.R
import com.example.musici.data.ApiClient
import com.example.musici.data.model.TopArtist
import com.example.musici.data.model.TopArtists
import com.example.musici.ui.adapters.TopArtistAdapter
import kotlinx.android.synthetic.main.fragment_top_artists.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopArtistsFragment : Fragment() {

    private lateinit var adapter: TopArtistAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top_artists, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TopArtistAdapter()
        rv_topArtists.layoutManager = GridLayoutManager(
            requireContext(),
            3
        )
        rv_topArtists.adapter = adapter

        pb_artists.visibility = View.VISIBLE
        ll_topArtists.visibility = View.GONE

        loadTopArtists()
    }

    private fun loadTopArtists() {
        val call = ApiClient()?.service?.getTopArtists()

        call?.enqueue(object : Callback<TopArtists> {
            override fun onResponse(call: Call<TopArtists>, response: Response<TopArtists>) {
                if (response.isSuccessful) {
                    val list = response.body()?.artists?.artist
                    adapter.setData(list!! as List<TopArtist>)

                    pb_artists.visibility = View.GONE
                    ll_topArtists.visibility = View.VISIBLE


                } else {
                    Toast.makeText(
                        requireActivity(),
                        response.errorBody().toString(),
                        Toast.LENGTH_SHORT
                    ).show()


                }
            }

            override fun onFailure(call: Call<TopArtists>, t: Throwable) {
                Toast.makeText(requireActivity(), t.message, Toast.LENGTH_SHORT).show()
            }

        })

    }
}